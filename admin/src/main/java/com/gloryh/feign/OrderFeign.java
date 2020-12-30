package com.gloryh.feign;

import com.gloryh.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Order 微服务接口
 *
 * @author 黄光辉
 * @since 2020/11/25
 **/
@Repository
@FeignClient(value = "order")
public interface OrderFeign {

    /**
     * 查询所有订单信息
     * @param thisPage
     * @return
     */
    @GetMapping("/order/findAll/{thisPage}")
    public OrderVO findAll(@PathVariable int thisPage);
}
