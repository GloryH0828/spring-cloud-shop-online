package com.gloryh.repository;

import com.gloryh.entity.Area;
import com.gloryh.entity.City;
import com.gloryh.entity.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址获取接口
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Repository
public interface ProvinceCityAreaRepository {
    /**
     * 查询所有省，直辖市，行政区信息
     * @return List<Province>
     */
    public List<Province> findAllProvince();

    /**
     * 按 Province 索引 查询对应城市信息
     * @param province_id 索引
     * @return List<City>
     */
    public List<City> findCityByProvince(String province_id);

    /**
     * 按 City 索引查询对应地区信息
     * @param city_id 索引
     * @return List<Area>
     */
    public List<Area> findAreaByCity(String city_id);
}
