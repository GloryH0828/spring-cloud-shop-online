package com.gloryh.feign;

import com.gloryh.entity.Category;
import com.gloryh.entity.CategoryVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通过 Feign 调用 category 服务
 *
 * @author 黄光辉
 * @since 2020/11/4
 **/
@Repository
@FeignClient(value = "category")
public interface CategoryFeign {
    /**
     * 查询所有分类信息
     * @param thisPage 当前页
     * @return List<Category>
     */
    @GetMapping("/category/findAll/{thisPage}")
    public CategoryVO findAll(@PathVariable int thisPage);

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
    /**
     * 添加分类信息
     * @param category
     */
    @PostMapping("/category/save")
    public void save(Category category);

    /**
     * 更新分类信息
     * @param category
     */
    @PutMapping("/category/update")
    public void update(Category category);

    /**
     * 按id删除分类信息
     * @param id 编号
     */
    @DeleteMapping("/category/delete/{id}")
    public void delete(@PathVariable long id);
    /**
     * 批量删除
     * @param ids
     */
    @DeleteMapping("/category/deleteMore")
    public  void deleteMore(int[] ids);

    /**
     * 按 名称查询 分类 信息
     * @param type_name
     * @return
     */
    @GetMapping("/category/findByName/{type_name}")
    public Category findByName(@PathVariable String type_name);
}
