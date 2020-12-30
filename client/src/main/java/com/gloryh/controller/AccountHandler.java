package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Vip;
import com.gloryh.feign.AccountFeign;
import com.gloryh.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * account controller
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login/{username}/{password}")
    @ResponseBody
    public String login(@PathVariable String username, @PathVariable String password, HttpSession session) {
        Vip vip = accountFeign.login(username, Md5Utils.md5(password));
        JSONObject jsonObject = new JSONObject();
        if (vip.getVip_id()!=0) {
           if(vip.getStatus() ==1){
               Vip viper = new Vip();
               viper.setVip_id(vip.getVip_id());
               viper.setName(vip.getName());
               viper.setUsername(vip.getUsername());
               Date date = vip.getLast_login_time();
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String last_login_time=simpleDateFormat.format(date);
               session.setAttribute("viper", viper);
               jsonObject.put("status", 0);
               jsonObject.put("lastLogin", last_login_time);
               jsonObject.put("name", viper.getName());
           }else {
               jsonObject.put("status",2);
           }

        } else {
            jsonObject.put("status", 1);
        }
        return jsonObject.toJSONString();
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody Vip vip) {
        JSONObject jsonObject = new JSONObject();
        Vip vip1=accountFeign.findByUsername(vip.getUsername());
        if(vip1 ==null){
            vip.setPassword(Md5Utils.md5(vip.getPassword()));
            accountFeign.register(vip);
            jsonObject.put("status", 1);
        }else{
            jsonObject.put("status", 0);
        }
        return jsonObject.toJSONString();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable String location) {
        return location;
    }
    @GetMapping("/activate/{code}")
    public ModelAndView activate(@PathVariable String code){
        JSONObject jsonObject =accountFeign.activate(code);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("result",jsonObject);
        modelAndView.setViewName("activate");
        return modelAndView;
    }
    @PostMapping("/updateActivation/{code}")
    @ResponseBody
    public void updateActivation(@PathVariable String code){
        accountFeign.updateActivation(code);
    }
}
