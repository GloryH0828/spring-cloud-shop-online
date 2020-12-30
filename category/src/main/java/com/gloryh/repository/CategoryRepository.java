package com.gloryh.repository;

import com.gloryh.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品分类相关接口类
 *
 * @author 黄光辉
 * @since 2020/11/4
 **/

@Repository
public interface CategoryRepository {
    /**
     * 查询所有分类信息
     * @param index 起始下标
     * @param limit 长度
     * @return List<Category>
     */
    public  List<Category> findAll(int index,int limit);

    /**
     * 不分页 查询所有分类信息
     * @return List<Category>
     */
    public List<Category> findAllNoPage();

    /**
     * 按 id 查询分类信息
     * @param id 编号
     * @return  Category
     */
    public Category findById(Long id);

    /**
     * 添加分类信息
     * @param category
     */
    public void save(Category category);

    /**
     * 更新分类信息
     * @param category
     */
    public void update(Category category);

    /**
     * 按id删除分类信息
     * @param id 编号
     */
    public void delete(long id);

    /**
     * 查询商品分类数量
     * @return int
     */
    public int count();

    /**
     * 批量删除
     * @param ids
     */
    public  void deleteMore(@Param("ids") int[] ids);

    /**
     * 按 分类名称 查询分类信息
     * @param type_name 名称
     * @return Category
     */
    public Category findByName(String type_name);
}
