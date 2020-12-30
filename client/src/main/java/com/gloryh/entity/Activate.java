package com.gloryh.entity;

import lombok.Data;

import java.util.Date;

/**
 * 激活验证
 *
 * @author 黄光辉
 * @since 2020/11/29
 **/
@Data
public class Activate {
    private int activate_id;
    private Vip vip;
    private String code;
    private Date expire_date;
}
