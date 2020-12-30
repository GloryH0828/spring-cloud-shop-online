package com.gloryh.repository;

import com.gloryh.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单条目相关操作
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Repository
public interface OrderRepository {
    /**
     * 查询对应订单列表
     *
     * @param index
     * @param limit
     * @return List<Order>
     */
    public List<Order> findAll(@Param("index") int index, @Param("limit") int limit);

    /**
     * 按 id 查询订单
     *
     * @param order_id
     * @return Order
     */
    public Order findById(String order_id);

    /**
     * 新建订单
     *
     * @param order
     */
    public void save(Order order);

    /**
     * 更新订单状态
     *
     * @param status
     * @param order_id
     */
    public void updateStatus(@Param("status") int status, @Param("order_id") String order_id);

    /**
     * 删除订单
     *
     * @param order_id
     */
    public void delete(String order_id);

    /**
     * 根据 会员 id 查询 订单信息
     *
     * @param v_id 会员 id
     * @return List<Order>
     */
    public List<Order> findByVipId(int v_id);

    /**
     * 获取 订单数量
     *
     * @return
     */
    public int count();

    /**
     * 更新 地址信息
     * @param order_id
     * @param address_id
     */
    public void updateAddressById(@Param("order_id") String order_id,@Param("address_id") int address_id);
}
