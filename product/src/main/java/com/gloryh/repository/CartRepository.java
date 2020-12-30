package com.gloryh.repository;

import com.gloryh.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 购物车接口
 *
 * @author 黄光辉
 * @since 2020/11/18
 **/
@Repository
public interface CartRepository {
    /**
     * 按购物车 id 查询
     * @param cartId 购物车id
     * @return Cart
     */
    public Cart findById(int cartId);

    /**
     * 按 vip id 查询
     * @param vipId
     * @return
     */
    public List<Cart> findByVipId(int vipId);

    /**
     * 按商品id 查询
     * @param productId
     * @return
     */
    public Cart findByProductId(long productId);

    /**
     * 保存到购物车
     * @param cart
     */
    public void saveCart(Cart cart);

    /**
     * 更新购物车信息
     * @param cart
     */
    public void updateCart(Cart cart);

    /**
     * 从购物车删除
     * @param cartId
     */
    public void deleteCart(int cartId);

    /**
     * 批量删除
     * @param ids
     */
    public void deleteMore(int[] ids);
}
