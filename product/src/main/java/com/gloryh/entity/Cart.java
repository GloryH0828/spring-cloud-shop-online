package com.gloryh.entity;

import lombok.Data;

/**
 * 购物车
 *
 * @author 黄光辉
 * @since 2020/11/18
 **/
@Data
public class Cart {
    private int cart_id;
    private Product product;
    private int cart_count;
    private Vip vip;
    private float total_price;
}
