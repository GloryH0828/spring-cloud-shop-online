package com.gloryh.repository;

import org.springframework.stereotype.Repository;

/**
 * 激活时发送邮件
 *
 * @author 黄光辉
 * @since 2020/11/27
 **/
@Repository
public interface MailRepository {
    /**
     * 发送文本邮件
     * @param vip_mail      收件人地址
     * @param code 激活码
     */
    public void send(String vip_mail, String code);
}
