package com.gloryh.controller;

import com.gloryh.entity.Promotion;
import com.gloryh.feign.PromotionFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * promotion controller
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@Controller
@RequestMapping("/promotion")
public class PromotionHandler {
    @Autowired
    private PromotionFeign promotionFeign;
    @GetMapping("/findByProductId/{id}/{type}")
    private List<Promotion> findByProductId(@PathVariable long id,@PathVariable int type){
        return promotionFeign.findByProductId(id, type);
    }
}
