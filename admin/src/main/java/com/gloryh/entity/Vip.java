package com.gloryh.entity;

import lombok.Data;

import java.util.Date;

/**
 * 会员实体类
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@Data
public class Vip {
    private Integer vip_id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String email;
    private String photo;
    private Integer score;
    private String question;
    private String answer;
    private Date last_login_time;
    private String phone;
    private Integer status;
}
