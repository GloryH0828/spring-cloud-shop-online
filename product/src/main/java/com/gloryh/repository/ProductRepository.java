package com.gloryh.repository;

import com.gloryh.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品相关接口类
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Repository
public interface ProductRepository {
    /**
     * 查询所有商品信息
     * @param index
     * @param limit
     * @return
     */
    public List<Product> findAll(int index,int limit);
    /**
     * 按 id 查询信息
     * @param id 编号
     * @return  Product
     */
    public Product findById(Long id);

    /**
     * 按 分类 查询信息
     * @param typeName 分类名
     *
     * @return  Product
     */
    public List<Product> findByCategory(@Param("type_name")String typeName);
    /**
     * 按 名称 查询信息
     * @param name 名称
     *
     * @return  Product
     */
    public List<Product> findByName(@Param("name")String name);
    /**
     * 添加信息
     * @param product
     * @return
     */
    public long save(Product product);

    /**
     * 更新信息
     * @param product
     */
    public void update(Product product);

    /**
     * 按id删除信息
     * @param id 编号
     */
    public void delete(long id);

    /**
     * 查询商品数量
     * @return int
     */
    public int count();
    /**
     * 按品类查询商品数量
     * @param cId
     * @return int
     */
    public int countByCategory(int cId);
    /**
     * 批量删除
     * @param ids
     */
    public  void deleteMore(@Param("ids") int[] ids);
    /**
     * 按品类查询商品数量
     * @param name
     * @return int
     */
    public int countByName(String name);

    /**
     * 查询对应分类的前12条商品信息
     * @param category_id
     * @return List
     */
    public List<Product> findToIndex(Integer category_id);
    /**
     * 查询对应分类的前12条商品信息
     * @param category_id
     * @param thisPage
     * @param limit
     * @return List
     */
    public List<Product> findByCategoryId(@Param("category_id") int category_id,@Param("page") int thisPage,@Param("limit") int limit,@Param("order") int orderType);

    /**
     * 更新图片状态
     * @param id
     * @param state
     */
    public void updatePhoto(@Param("id") long id,@Param("state") int state);

    /**
     * 按 关键字查询
     * @param index 关键字
     * @param orderType 排序方式
     * @return List<Product>
     */
    public List<Product> findByIndex(@Param("index")String index,@Param("orderType") int orderType);
}
