package com.gloryh.entity;

import lombok.Data;

/**
 * 收货地址表
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Data
public class Address {
    private int address_id;
    private Province province;
    private City city;
    private Area area;
    private String total_address;
    private String postcode;
    private String receiver;
    private String phone;
    private Vip vip;
}
