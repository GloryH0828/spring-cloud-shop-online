package com.gloryh.entity;

import lombok.Data;

import java.util.List;

/**
 * 主页接受数据的数据模型
 *
 * @author 黄光辉
 * @since 2020/11/14
 **/
@Data
public class IndexVO {
    private Integer c_id;
    private String name;
    private List<Product> products;
}
