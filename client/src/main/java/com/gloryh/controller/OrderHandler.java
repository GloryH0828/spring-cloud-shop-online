package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.*;
import com.gloryh.feign.OrderFeign;
import com.gloryh.feign.ProductFeign;
import com.gloryh.utils.BaseCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * order controller
 *
 * @author 黄光辉
 * @since 2020/11/21
 **/
@Controller
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private BaseCalculate baseCalculate;
    @PostMapping("/saveOnCart/{v_id}")
    @ResponseBody
    public String saveOrderOnCart(@RequestBody int[] ids , @PathVariable int v_id){
        Order order =new Order();
        String orderId= UUID.randomUUID().toString().replace("-","");
        List<OrderItem> orderItems=new ArrayList<>();
        order.setOrder_id(orderId);
        Order order1=new Order();
        order1.setOrder_id(orderId);
        float totalPrice =0;
        for (int id:ids){
            Cart cart=productFeign.findCartById(id);
            OrderItem orderItem =new OrderItem();
            orderItem.setBuy_count(cart.getCart_count());
            orderItem.setBuy_price(cart.getTotal_price());
            orderItem.setProduct(cart.getProduct());
            orderItem.setOrder(order1);
            totalPrice =baseCalculate.add(orderItem.getBuy_price(),totalPrice );
            orderItems.add(orderItem);
        }
        Vip vip =new Vip();
        vip.setVip_id(v_id);
        order.setOrder_time(new Date());
        order.setTotal_price(totalPrice );
        order.setVip(vip);
        order.setOrderItems(orderItems);
        order.setStatus(0);;
        orderFeign.saveOrder(order);
        productFeign.deleteMoreCart(ids);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("orderId",orderId);
        return jsonObject.toJSONString();
    }
    @PostMapping("/creat")
    @ResponseBody
    public String creat(@RequestBody Cart cart){
        Product product =productFeign.findById(cart.getProduct().getProduct_id());
        Order order =new Order();
        String orderId= UUID.randomUUID().toString().replace("-","");
        order.setOrder_id(orderId);
        Order order1=new Order();
        order1.setOrder_id(orderId);
        OrderItem orderItem=new OrderItem();
        orderItem.setOrder(order1);
        orderItem.setBuy_price(baseCalculate.multiply(product.getPrice(),cart.getCart_count()));
        orderItem.setBuy_count(cart.getCart_count());
        orderItem.setProduct(cart.getProduct());
        order.setOrder_time(new Date());
        order.setTotal_price(orderItem.getBuy_price());
        order.setVip(cart.getVip());
        List<OrderItem> orderItems=new ArrayList<>();
        orderItems.add(orderItem);
        order.setOrderItems(orderItems);
        order.setStatus(0);
        orderFeign.saveOrder(order);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("orderId",orderId);
        return jsonObject.toJSONString();
    }
    @GetMapping("/findByOrderId/{orderId}/{v_id}")
    public ModelAndView findByOrderId(@PathVariable String orderId,@PathVariable int v_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("address",orderFeign.findAddressByVipId(v_id));
        modelAndView.addObject("order",orderFeign.findOrderById(orderId));
        modelAndView.setViewName("pay");
        return modelAndView;
    }
    @GetMapping("/findToInfo/{id}")
    public ModelAndView findToInfo(@PathVariable String id){
        ModelAndView modelAndView=new ModelAndView();
        Order order=orderFeign.findOrderById(id);
        modelAndView.addObject("order",order);
        try {
            modelAndView.addObject("address", orderFeign.findAddressById(order.getAddress().getAddress_id()));
        }catch (Exception e){
            System.out.println(e);
            modelAndView.addObject("address",null);
        }
        modelAndView.setViewName("orderInfo");
        return modelAndView;
    }
    @GetMapping("/findByVipId/{v_id}")
    public ModelAndView findByVipId(@PathVariable int v_id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("orders",orderFeign.findOrderByVipId(v_id));
        modelAndView.setViewName("order");
        return modelAndView;
    }
    @GetMapping("/pay/{order_id}/{address_id}")
    public ModelAndView pay(@PathVariable String order_id,@PathVariable int address_id){
        ModelAndView modelAndView =new ModelAndView();
        orderFeign.updateOrderByOrderId(order_id,address_id);
        orderFeign.updateStatusByOrderId(order_id,1);
        Order order=orderFeign.findOrderById(order_id);
        modelAndView.addObject("price",order.getTotal_price());
        modelAndView.addObject("order_id",order_id);
        modelAndView.addObject("address",orderFeign.findAddressById(address_id));
        modelAndView.setViewName("paySuccess");
        return modelAndView;
    }

}
