package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Activate;
import com.gloryh.entity.Admin;
import com.gloryh.entity.Vip;
import com.gloryh.repository.AdminRepository;
import com.gloryh.repository.VipRepository;
import com.gloryh.repository.impl.MailRepositoryImpl;
import com.gloryh.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * account controller
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private VipRepository vipRepository;
    @Autowired
    private MailRepositoryImpl mailRepositoryImpl;


    @PostMapping("/adminLogin/{username}/{password}")
    public Admin adminLogin(@PathVariable String username, @PathVariable String password) {
        Admin admin = adminRepository.login(username, password);
        return admin;
    }

    @PostMapping("/vipLogin/{username}/{password}")
    public Vip vipLogin(@PathVariable String username, @PathVariable String password) {
        Vip vip =vipRepository.login(username, password);
        if (vip != null) {
            vipRepository.updateLoginTime(username, new Date());
        }else {
            vip=new Vip();
            vip.setVip_id(0);
        }
        return vip;

    }

    @GetMapping("/findVipByUsername/{username}")
    public Vip findVipByUsername(@PathVariable String username) {
        return vipRepository.findByUsername(username);
    }

    @PostMapping("/register")
    public void register(@RequestBody Vip vip) {
        vipRepository.register(vip);
        Activate activate = new Activate();
        activate.setVip(vip);
        activate.setCode(UUID.randomUUID().toString().replace("-", ""));
        activate.setExpire_date(DateUtils.getNextNow());
        vipRepository.addActivation(activate);
        mailRepositoryImpl.send(vip.getEmail(), activate.getCode());
    }

    @PutMapping("/activate/{code}")
    public JSONObject activate(@PathVariable String code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        Activate activate = vipRepository.findActivateByCode(code);
        Vip vip = vipRepository.findVipById(activate.getVip().getVip_id());
        if (vip.getStatus() == 1) {
            jsonObject.put("status", 3);
        } else {
            if (activate == null) {
                jsonObject.put("status", 0);
            } else {
                if (DateUtils.isNotExpired(activate.getExpire_date())) {
                    vipRepository.updateStatusByVipId(activate.getVip().getVip_id());

                    jsonObject.put("status", 1);
                } else {
                    jsonObject.put("status", 2);
                }
            }
        }
        return jsonObject;
    }

    @PostMapping("/updateActivation/{code}")
    public void updateActivation(@PathVariable("code") String oldCode) {
        String newCode = UUID.randomUUID().toString().replace("-", "");
        Activate activate = vipRepository.findActivateByCode(oldCode);
        activate.setCode(newCode);
        activate.setExpire_date(DateUtils.getNextNow());
        vipRepository.updateActivation(activate);
        mailRepositoryImpl.send(activate.getVip().getEmail(), newCode);
    }

}
