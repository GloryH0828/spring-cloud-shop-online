package com.gloryh.feign;

import com.gloryh.entity.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/account/adminLogin/{username}/{password}")
    public Admin login(@PathVariable String username, @PathVariable String password);
}
