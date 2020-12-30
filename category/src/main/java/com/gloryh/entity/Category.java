package com.gloryh.entity;

import lombok.Data;

/**
 * 商品分类实体类
 *
 * @author 黄光辉
 * @since 2020/11/4
 **/
@Data
public class Category {
    private Long category_id;
    private String type_name;
    private Integer sort;
}
