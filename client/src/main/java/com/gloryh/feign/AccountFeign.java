package com.gloryh.feign;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Vip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * 通过 Feign 调用 account 微服务
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@Repository
@FeignClient(value = "account")
public interface AccountFeign {

    /**
     * 调用对应服务的登录验证
     * @param username 用户名
     * @param password 密码
     * @return Object
     */
    @PostMapping("/account/vipLogin/{username}/{password}")
    public Vip login(@PathVariable String username,@PathVariable String password);

    /**
     * 调用会员注册方法
     * @param vip 会员信息
     */
    @PostMapping("/account/register")
    public void register(Vip vip);

    /**
     * 用户名是否被占用
     * @param username 用户名
     * @return Vip
     */
    @GetMapping("/account/findVipByUsername/{username}")
    public Vip findByUsername(@PathVariable String username);

    /**
     * 账号激活
     * @param code 密码
     * @return
     */
    @PutMapping("/account/activate/{code}")
    public JSONObject activate(@PathVariable String code);

    /**
     * 激活码过期后进行更新
     * @param code 旧的激活码
     */
    @PostMapping("/account/updateActivation/{code}")
    public void updateActivation(@PathVariable String code);
}
