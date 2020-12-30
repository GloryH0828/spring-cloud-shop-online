package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Admin;
import com.gloryh.feign.AccountFeign;
import com.gloryh.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public String login(@PathVariable String username, @PathVariable String password,HttpSession session) {
        JSONObject jsonObject =new JSONObject();
        Admin admin =accountFeign.login(username, Md5Utils.md5(password));
        if (admin != null){
                    //单个赋值处理强转错误
                    Admin admin1 =new Admin();
                    admin1.setAdmin_id(admin.getAdmin_id());
                    admin1.setName(admin.getName());
                    session.setAttribute("admin",admin1);
                    jsonObject.put("status",0);
                    jsonObject.put("name",admin.getName());
        }else {
            jsonObject.put("status",1);
        }
        return jsonObject.toJSONString();
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable String location) {
        String redirect="redirect:/"+location+".html";
        return redirect;
    }
}
