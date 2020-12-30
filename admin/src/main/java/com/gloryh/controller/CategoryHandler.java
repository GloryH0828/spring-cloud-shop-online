package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Category;
import com.gloryh.entity.CategoryVO;
import com.gloryh.feign.CategoryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * category controller
 *
 * @author 黄光辉
 * @since 2020/11/4
 **/
@Controller
@RequestMapping("/category")
public class CategoryHandler {
    @Autowired
    private CategoryFeign categoryFeign;

    @GetMapping("/findAll/{thisPage}")
    public ModelAndView findAll(@PathVariable int thisPage){
        CategoryVO categoryVO = categoryFeign.findAll(thisPage);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("categoryList");
        modelAndView.addObject("category", categoryVO);
        return modelAndView;
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("category",categoryFeign.findById(id));
        modelAndView.setViewName("updateCategory");
        return modelAndView;
    }
    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody Category category){
        Category category1 =categoryFeign.findByName(category.getType_name());
        JSONObject jsonObject=new JSONObject();
        if (category1 ==null){
            categoryFeign.save(category);
            jsonObject.put("status", "0");
        }else {
            jsonObject.put("status","1");
        }
        return jsonObject.toJSONString();
    }
    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestBody Category category){
        categoryFeign.update(category);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",0);
        return jsonObject.toJSONString();
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        categoryFeign.delete(id);
        ModelAndView modelAndView =findAll(1);
        return modelAndView;
    }

    @DeleteMapping("/deleteMore")
    @ResponseBody
    public String deleteMore(@RequestBody int[] ids){
        categoryFeign.deleteMore(ids);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("status",0);
        return jsonObject.toJSONString();
    }
    @GetMapping("/addProduct")
    public ModelAndView addProduct(){
        List<Category> list =categoryFeign.findAllNoPage();
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("addProduct");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
