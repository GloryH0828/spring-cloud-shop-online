package com.gloryh.controller;

import com.gloryh.entity.OrderVO;
import com.gloryh.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * order controller
 *
 * @author 黄光辉
 * @since 2020/11/25
 **/
@RequestMapping("/order")
@Controller
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findAll/{thisPage}")
    public ModelAndView findAll(@PathVariable("thisPage") int thisPage){
       OrderVO orderVO= orderFeign.findAll(thisPage);
       ModelAndView modelAndView =new ModelAndView();
       modelAndView.addObject("page",orderVO);
       modelAndView.setViewName("orderList");
       return modelAndView;
    }
}
