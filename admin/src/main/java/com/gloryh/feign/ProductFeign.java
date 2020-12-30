package com.gloryh.feign;

import com.gloryh.entity.Product;
import com.gloryh.entity.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Repository
@FeignClient(value = "product")
public interface ProductFeign {
    /**
     * 查询所有商品信息
     * @param thisPage
     * @return ProductVO
     */
    @GetMapping("/product/findAll/{thisPage}")
    public ProductVO findAll(@PathVariable int thisPage);
    /**
     * 按 id 查询信息
     * @param id 编号
     * @return  Product
     */
    @GetMapping("/product/findById/{id}")
    public Product findById(@PathVariable Long id);

    /**
     * 按 分类id 查询信息
     * @param type_name
     * @return  Product
     */
    @GetMapping("/product/findByCategory/{type_name}")
    public List<Product> findByCategory(@PathVariable String type_name);
    /**
     * 按 名称 查询信息
     * @param name 名称
     * @return  Product
     */
    @GetMapping("/product/findByName/{name}")
    public List<Product> findByName(@PathVariable("name")String name);
    /**
     * 添加信息
     * @param product
     * @return int
     */
    @PostMapping("/product/save")
    public long save(Product product);
    @PutMapping("/product/updatePhoto/{id}/{state}")
    public void updatePhotoState(@PathVariable String id,@PathVariable int state);


    /**
     * 更新信息
     * @param product
     */
    @PutMapping("/product/update")
    public void update(Product product);

    /**
     * 按id删除信息
     * @param id 编号
     */
    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable("id")long id);

    /**
     * 批量删除
     * @param ids
     */
    @DeleteMapping("/product/deleteMore")
    public  void deleteMore( int[] ids);

}
