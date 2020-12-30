package com.gloryh.feign;

import com.gloryh.entity.Cart;
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
 * @since 2020/11/14
 **/
@Repository
@FeignClient(value = "product")
public interface ProductFeign {

    /**
     * 按 id 查询信息
     * @param id 编号
     * @return  Product
     */
    @GetMapping("/product/findById/{id}")
    public Product findById(@PathVariable Long id);

    /**
     * 按 分类 查询信息
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
     * 将对应分类的前12商品展示在index
     * @param category_id
     * @return List<Product>
     */
    @GetMapping("/product/findToIndex/{category_id}")
    public List<Product> findToIndex(@PathVariable Integer category_id);

    /**
     * 按 分类 id 查询对应的 商品列表
     * @param c_id 分类 id
     * @param thisPage
     * @param orderType
     * @return List<Product>
      */
    @GetMapping("/product/findByCategoryId/{orderType}/{c_id}/{thisPage}")
    public ProductVO findByCategoryId(@PathVariable int orderType,@PathVariable Integer c_id,@PathVariable int thisPage);

    /**
     * 按购物车 id 查询
     * @param cartId 购物车id
     * @return Cart
     */
    @GetMapping("/product/findCartById/{id}")
    public Cart findCartById(@PathVariable("id") int cartId);

    /**
     * 按 vip id 查询
     * @param vipId
     * @return
     */
    @GetMapping("/product/findCartByVipId/{vipId}")
    public List<Cart> findCartByVipId(@PathVariable int vipId);

    /**
     * 按商品id 查询
     * @param productId
     * @return
     */
    @GetMapping("/product/findCartByProductId/{p_id}")
    public Cart findCartByProductId(@PathVariable("p_id") long productId);

    /**
     * 保存到购物车
     * @param cart
     */
    @PostMapping("/product/saveCart")
    public void saveCart(Cart cart);

    /**
     * 更新购物车信息
     * @param cart
     */
    @PutMapping("/product/updateCart")
    public void updateCart(Cart cart);

    /**
     * 从购物车删除
     * @param cartId
     */
    @DeleteMapping("/product/deleteCart/{id}")
    public void deleteCart(@PathVariable("id") int cartId);

    /**
     * 批量删除
     * @param ids
     */
    @DeleteMapping("/product/deleteMoreCart")
    public void deleteMoreCart(int[] ids);

    /**
     * 按关键字查询商品信息
     * @param index
     * @param orderType
     * @return List<Product>
     */
    @GetMapping("/product/findByIndex/{index}/{orderType}")
    public List<Product> findByIndex(@PathVariable String index,@PathVariable int orderType);
}
