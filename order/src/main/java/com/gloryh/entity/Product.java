package com.gloryh.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体类
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Data
public class Product {
    private Long product_id;
    private String name;
    private float mark_price;
    private float price;
    private Integer quantity;
    private Integer hit;
    private Date time;
    private Integer photo;
    private String content;
    private Category category;
}
