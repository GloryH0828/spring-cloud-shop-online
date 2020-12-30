package com.gloryh.controller;

import com.gloryh.entity.Promotion;
import com.gloryh.feign.ProductFeign;
import com.gloryh.feign.PromotionFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * product controller
 *
 * @author 黄光辉
 * @since 2020/11/15
 **/
@Controller
@RequestMapping("/product")
public class ProductHandler {
    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private PromotionFeign promotionFeign;
    @GetMapping("/findByCategoryId/{orderType}/{c_id}/{thisPage}")
    public ModelAndView findByCategoryId(@PathVariable int orderType,@PathVariable Integer c_id,@PathVariable int thisPage){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("productList");
        modelAndView.addObject("category_id",c_id);
        modelAndView.addObject("orderType",orderType);
        modelAndView.addObject("page",productFeign.findByCategoryId(orderType,c_id,thisPage));
        return modelAndView;
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable long id){
        List<Promotion> list =promotionFeign.findByProductId(id,1);
        ModelAndView modelAndView =new ModelAndView();
        if(!list.isEmpty()){
            modelAndView.addObject("promotion",list.get(0).getPromotion_price());
        }
        modelAndView.addObject("product",productFeign.findById(id));
        modelAndView.setViewName("productDetails");
        return modelAndView;
    }
    @GetMapping("/findByIndex/{index}/{orderType}")
    public ModelAndView findByIndex(@PathVariable String index,@PathVariable int orderType){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",productFeign.findByIndex(index,orderType));
        modelAndView.addObject("index",index);
        modelAndView.addObject("orderType",orderType);
        modelAndView.setViewName("productList");
        return modelAndView;
    }
}
