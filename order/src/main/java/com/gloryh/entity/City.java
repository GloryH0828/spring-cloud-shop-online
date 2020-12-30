package com.gloryh.entity;

import lombok.Data;

/**
 * 城市信息
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Data
public class City {
    private int id;
    private String city_id;
    private String city;
    private Province province;
}
