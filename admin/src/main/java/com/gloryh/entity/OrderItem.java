package com.gloryh.entity;

import lombok.Data;

/**
 * 订单条目表
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Data
public class OrderItem {
    private long id;
    private int buy_count;
    private float buy_price;
    private Product product;
    private Order order;
}
