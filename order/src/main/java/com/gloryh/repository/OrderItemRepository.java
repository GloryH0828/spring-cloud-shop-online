package com.gloryh.repository;

import com.gloryh.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单条目相关操作
 *
 * @author 黄光辉
 * @since 2020/11/20
 **/
@Repository
public interface OrderItemRepository {
    /**
     * 按 订单编号查询 订单条目
     * @param order_id 编号
     * @return List<OrderItem>
     */
    public List<OrderItem> findByOrder(String order_id);

    /**
     * 按 条目编号查找
     * @param id
     * @return OrderItem
     */
    public OrderItem findByOrderItemId(long id);

    /**
     * 新建 订单条目
     * @param orderItem
     */
    public void save(OrderItem orderItem);

    /**
     * 按 订单编号 删除相关订单条目
     * @param order_id
     */
    public void deleteByOrderId(String order_id);

    /**
     * 按 条目 编号删除
     * @param id
     */
    public void deleteByOrderItemId(long id);
}
