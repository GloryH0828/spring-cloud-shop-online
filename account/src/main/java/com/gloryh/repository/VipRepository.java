package com.gloryh.repository;

import com.gloryh.entity.Activate;
import com.gloryh.entity.Vip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 会员登录注册相关接口
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@Repository
public interface VipRepository {
    /**
     * 会员登录验证
     * @param username 用户名
     * @param password 密码
     * @return Vip
     */
    public Vip login(String username,String password);

    /**
     * 会员注册
     * @param vip 相关信息
     */
    public void register(Vip vip);

    /**
     * 更新最近登录时间
     * @param username 对应用户名
     * @param date 当前时间
     */
    public void updateLoginTime(@Param("username") String username,@Param("date") Date date);

    /**
     * 按 用户名 查找
     * @param username 用户名
     * @return Vip
     */
    public Vip findByUsername(String username);

    /**
     * 处理激活码
     * @param activate
     */
    public void addActivation(Activate activate);

    /**
     * 根据 验证码 查询 对应 激活实体类
     * @param code 验证码
     * @return Activate
     */
    public Activate findActivateByCode(String code);

    /**
     * 更新 账户状态 代表激活
     * @param vip_id vip_id
     */
    public void updateStatusByVipId(Integer vip_id);

    /**
     * 更新 激活 信息
     * @param activate 激活信息 实体类
     */
    public void updateActivation(Activate activate);

    /**
     * 根据 vip_id 查询 对应账号是否已激活
     * @param vip_id
     * @return Vip
     */
    public Vip findVipById(Integer vip_id);
}
