package com.gloryh.entity;

import lombok.Data;

/**
 * 管理员信息实体类
 *
 * @author 黄光辉
 * @since 2020/11/3
 **/
@Data
public class Admin {
    private Integer admin_id;
    private String username;
    private String password;
    private String name;
}
