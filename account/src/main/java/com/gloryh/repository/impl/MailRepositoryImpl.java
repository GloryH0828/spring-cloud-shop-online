package com.gloryh.repository.impl;

import com.gloryh.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * 邮件服务实现接口
 *
 * @author 黄光辉
 * @since 2020/11/27
 **/
@Service
public class MailRepositoryImpl implements MailRepository {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    private final String subject ="账号激活";
    private final String text ="<a href=''http://localhost:8010/account/activate/{0}''>请单击这里获取激活码</a>如果无法打开链接，请复制链接到网页地址栏搜索";
    /**
     * 发送文本邮件
     *
     * @param vip_mail 收件人地址
     * @param code 激活码
     */
    @Override
    public void send(String vip_mail,String code) {
        String content = MessageFormat.format(text,code);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(vip_mail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
