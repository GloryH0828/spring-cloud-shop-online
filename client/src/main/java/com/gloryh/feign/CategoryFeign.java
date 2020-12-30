package com.gloryh.feign;

import com.gloryh.entity.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通过 Feign 调用 category 服务
 *
 * @author 黄光辉
 * @since 2020/11/14
 **/
@Repository
@FeignClient(value = "category")
public interface CategoryFeign {
    /**
     * 按 id 查询分类信息
     * @param id 编号
     * @return  Category
     */
    @GetMapping("/category/findById/{id}")
    public Category findById(@PathVariable Long id);

    /**
     * 不分页 查询所有分类信息
     * @return List<Category>
     */
    @GetMapping("/category/findAllNoPage")
    public List<Category> findAllNoPage();

}
