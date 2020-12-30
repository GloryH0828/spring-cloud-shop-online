package com.gloryh.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 订单表
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Data
public class Order {
    private String order_id;
    private Date order_time;
    private Address address;
    private List<OrderItem> orderItems;
    private float total_price;
    private String content;
    private Vip vip;
    private int status;
}
