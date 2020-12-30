package com.gloryh.feign;

import com.gloryh.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * 订单 微服务接口
 *
 * @author 黄光辉
 * @since 2020/11/21
 **/
@Repository
@FeignClient(value = "order")
public interface OrderFeign {

    /**
     * 新建订单
     * @param order
     */
    @PostMapping("/order/save")
    public void saveOrder(Order order);

    /**
     * 通过 vip id 查询 地址列表
     * @param v_id 会员 id
     * @return List<Address>
     */
    @GetMapping("/address/findByVipId/{v_id}")
    public List<Address>  findAddressByVipId(@PathVariable int v_id);

    /**
     * 通过 order id 查询订单信息
     * @param orderId 订单 id
     * @return Order
     */
    @GetMapping("/order/findById/{orderId}")
    public Order findOrderById(@PathVariable String orderId);

    /**
     * 查询省份、直辖市信息
     * @return List<Province>
     */
    @GetMapping("/address/getProvinces")
    public List<Province> getProvinces();

    /**
     * 根据省份查询对应 城市
     * @param province_id 省份 id
     * @return List<City>
     */
    @GetMapping("/address/getCitiesByProvinceId/{province_id}")
    public List<City> getCitiesByProvinceId(@PathVariable String province_id);

    /**
     * 根据 城市 查询 区域信息
     * @param city_id 城市 id
     * @return List<Area>
     */
    @GetMapping("/address/getAreasByCityId/{city_id}")
    public List<Area> getAreasByCityId(@PathVariable String city_id);

    /**
     * 添加新的地址信息
     * @param address
     */
    @PostMapping("/address/save")
    public void saveAddress(Address address);

    /**
     * 根据 会员 id 查找 订单列表
     * @param v_id 会员 id
     * @return List<Order>
     */
    @GetMapping("/order/findByVipId/{v_id}")
    public List<Order> findOrderByVipId(@PathVariable int v_id);

    /**
     * 根据 Address id 查找 地址信息
     * @param address_id 编号
     * @return Address
     */
    @GetMapping("/address/findById/{id}")
    public Address findAddressById(@PathVariable("id") int address_id);

    /**
     * 根据 订单编号 更新收货地址
     * @param order_id 订单编号
     * @param address_id 收货地址 id
     */
    @PutMapping("/order/updateAddressById/{order_id}/{address_id}")
    public void updateOrderByOrderId(@PathVariable String order_id,@PathVariable int address_id);

    /**
     * 根据订单ID 订单状态
     * @param order_id
     * @param status
     */
    @PutMapping("/order/updateStatusByOrderId/{order_id}/{status}")
    public void updateStatusByOrderId(@PathVariable String order_id,@PathVariable int status);
}
