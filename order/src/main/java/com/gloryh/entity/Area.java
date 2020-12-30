package com.gloryh.entity;

import lombok.Data;

/**
 * 地区信息
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Data
public class Area {
    private int id;
    private String area_id;
    private String area;
    private City city;
}
