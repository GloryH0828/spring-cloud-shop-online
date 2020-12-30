package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Cart;
import com.gloryh.entity.Product;
import com.gloryh.feign.ProductFeign;
import com.gloryh.utils.BaseCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * cart controller
 *
 * @author 黄光辉
 * @since 2020/11/18
 **/
@Controller
@RequestMapping("/cart")
public class CartHandler {
    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private BaseCalculate baseCalculate;

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @GetMapping("/findByVipId/{v_id}")
    public ModelAndView findByVipId(@PathVariable int v_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cartList", productFeign.findCartByVipId(v_id));
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @GetMapping("/findByProductId/{p_id}")
    public ModelAndView findByProductId(@PathVariable int p_id) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveCart(@RequestBody Cart cart) {
        Cart cart1 = productFeign.findCartByProductId(cart.getProduct().getProduct_id());
        if (cart1 != null) {
            cart1.setTotal_price(baseCalculate.multiply(cart.getProduct().getPrice(), cart.getCart_count()));
            productFeign.updateCart(cart1);
        } else {
            cart.setTotal_price(baseCalculate.multiply(cart.getProduct().getPrice(), cart.getCart_count()));
            productFeign.saveCart(cart);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 1);
        return jsonObject.toJSONString();
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateCart(@RequestBody Cart cart) {
        Product product = productFeign.findById(cart.getProduct().getProduct_id());
        cart.setTotal_price(product.getPrice() * cart.getCart_count());
        productFeign.updateCart(cart);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cart_count", cart.getCart_count());
        jsonObject.put("total_price", cart.getTotal_price());
        return jsonObject.toJSONString();
    }

    @GetMapping("/delete/{v_id}/{id}")
    public ModelAndView deleteCart(@PathVariable int v_id, @PathVariable int id) {
        productFeign.deleteCart(id);
        ModelAndView modelAndView = findByVipId(v_id);
        return modelAndView;
    }

    @DeleteMapping("/deleteMore")
    @ResponseBody
    public String deleteMore( @RequestBody int[] ids) {
        productFeign.deleteMoreCart(ids);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",1);
        return jsonObject.toJSONString();
    }
}
