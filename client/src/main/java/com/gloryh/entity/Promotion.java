package com.gloryh.entity;

import lombok.Data;

/**
 * 促销实体类
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@Data
public class Promotion {
    private long promotion_id;
    private Product product;
    private float promotion_price;
    private float discount;
    private int count;
    private int state;
}
