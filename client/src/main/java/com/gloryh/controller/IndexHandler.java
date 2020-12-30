package com.gloryh.controller;

import com.gloryh.entity.Category;
import com.gloryh.entity.IndexVO;
import com.gloryh.feign.CategoryFeign;
import com.gloryh.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 黄光辉
 * @since 2020/11/14
 **/
@Controller
@RequestMapping("/index")
public class IndexHandler {
    @Autowired
    private CategoryFeign categoryFeign;
    @Autowired
    private ProductFeign productFeign;
    @GetMapping("/all")
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categories= categoryFeign.findAllNoPage();
        List<IndexVO> list =new ArrayList<>();
        for (Category category: categories) {
            IndexVO indexVO =new IndexVO();
            indexVO.setC_id(category.getCategory_id());
            indexVO.setName(category.getType_name());
            indexVO.setProducts(productFeign.findToIndex(category.getCategory_id()));
            list.add(indexVO);
        }
        modelAndView.setViewName("index");
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
