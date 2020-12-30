package com.gloryh.feign;

import com.gloryh.entity.Promotion;
import com.gloryh.entity.PromotionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 通过 Feign 调用 promotion 微服务
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@Repository
@FeignClient(value = "promotion")
public interface PromotionFeign {
    /**
     * 查询所有促销信息并分页
     * @param thisPage
     * @return
     */
    @GetMapping("/promotion/findAll/{thisPage}")
    public PromotionVO findAll(@PathVariable int thisPage);
    /**
     * 按 商品 id 查询
     * @param p_id
     * @param type
     * @return
     */
    @GetMapping("/promotion/findByProductId/{p_id}/{type}")
    public List<Promotion> findByProductId(@PathVariable("p_id") long p_id, @PathVariable("type") int type);
}
