package com.gloryh.repository;

import com.gloryh.entity.Address;
import com.gloryh.entity.Area;
import com.gloryh.entity.City;
import com.gloryh.entity.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址信息增删改查接口
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Repository
public interface AddressRepository {
    /**
     * 按 会员 id 查询其所有收货地址
     * @param vip_id 会员id
     * @return List<Address>
     */
    public List<Address> findAllByVip(int vip_id);

    /**
     * 按 id 查询收货地址信息
     * @param id id
     * @return Address
     */
    public Address findById(int id);

    /**
     * 添加收货信息
     * @param address
     */
    public void save(Address address);

    /**
     * 修改收货信息
     * @param address
     */
    public void update(Address address);

    /**
     * 删除收货信息
     * @param id
     */
    public void delete(int id);

    /**
     * 获取 省份、直辖市 信息
     * @return List<Province>
     */
    public List<Province> getProvinces();

    /**
     * 根据 省份获取对应城市信息
     * @param province_id 省份id
     * @return List<Cities>
     */
    public List<City> getCitiesByProvinceId(String province_id);

    /**
     * 根据 城市信息 获取对应 区域信息
     * @param city_id 城市id
     * @return List<Area>
     */
    public List<Area> getAreasByCityId(String city_id);
}
