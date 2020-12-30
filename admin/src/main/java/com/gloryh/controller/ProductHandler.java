package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Product;
import com.gloryh.feign.CategoryFeign;
import com.gloryh.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * product controller
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Controller
@RequestMapping("/product")
public class ProductHandler {
    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private CategoryFeign categoryFeign;

    @GetMapping("/findAll/{thisPage}")
    public ModelAndView findAll(@PathVariable int thisPage) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        modelAndView.addObject("product", productFeign.findAll(thisPage));
        modelAndView.addObject("findType",1);
        return modelAndView;
    }

    @GetMapping("/findToUpdate/{id}")
    public ModelAndView findToUpdate(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", productFeign.findById(id));
        modelAndView.addObject("category",categoryFeign.findAllNoPage());
        modelAndView.setViewName("updateProduct");
        return modelAndView;
    }
    @GetMapping("/findToDes/{id}")
    public ModelAndView findToDes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", productFeign.findById(id));
        modelAndView.setViewName("productDes");
        return modelAndView;
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list",productFeign.findById(id));
        modelAndView.addObject("product",map);
        modelAndView.addObject("findType",4);
        return modelAndView;
    }

    @GetMapping("/findByCategory/{type_name}")
    public ModelAndView findByCategory(@PathVariable String type_name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("list", productFeign.findByCategory(type_name));
        modelAndView.addObject("product",map);
        modelAndView.addObject("findType",3);
        return modelAndView;
    }

    @GetMapping("/findByName/{name}")
    public ModelAndView findByName(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productList");
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("list", productFeign.findByName(name));
        modelAndView.addObject("product",map);
        modelAndView.addObject("findType",2);
        return modelAndView;
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody Product product) {
        long id=productFeign.save(product);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("status", "0");
        return jsonObject.toJSONString();
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody Product product) {
        productFeign.update(product);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "0");
        return jsonObject.toJSONString();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        productFeign.delete(id);
        ModelAndView modelAndView = findAll(1);
        return modelAndView;
    }

    @DeleteMapping("/deleteMore")
    @ResponseBody
    public String deleteMore(@RequestBody int[] ids) {
        productFeign.deleteMore(ids);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        return jsonObject.toJSONString();
    }

}
