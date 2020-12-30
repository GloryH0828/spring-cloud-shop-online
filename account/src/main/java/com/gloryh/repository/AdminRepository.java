package com.gloryh.repository;

import com.gloryh.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * 管理员登录相关接口类
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@Repository
public interface AdminRepository {
    /**
     * 管理员身份验证
     * @param username 用户名
     * @param password 密码
     * @return Admin
     */
    public Admin login(String username,String password);
}
