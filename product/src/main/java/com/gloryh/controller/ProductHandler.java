package com.gloryh.controller;

import com.gloryh.entity.Cart;
import com.gloryh.entity.Product;
import com.gloryh.entity.ProductVO;
import com.gloryh.repository.CartRepository;
import com.gloryh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * product controller
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@RestController
@RequestMapping("/product")
public class ProductHandler {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/findAll/{thisPage}")
    public ProductVO findAll(@PathVariable int thisPage){
        int current =thisPage;
        if (thisPage == 0){
            current =1;
        }
        ProductVO productVO =new ProductVO(current, productRepository.count());
        productVO.setPageSize(4);
        productVO.setList(productRepository.findAll(productVO.getStartIndex(),productVO.getPageSize()));
        return productVO;
    }
    @GetMapping("/findById/{id}")
    public Product findById(@PathVariable long id){
        return productRepository.findById(id);
    }
    @GetMapping("/findByCategory/{type_name}")
    public List<Product> findByCategory(@PathVariable String type_name){
        return productRepository.findByCategory(type_name);
    }
    @GetMapping("/findByIndex/{index}/{orderType}")
    public List<Product> findByIndex(@PathVariable String index, @PathVariable int orderType){
        return productRepository.findByIndex(index,orderType);
    }
    @GetMapping("/findByName/{name}")
    public List<Product> findByName(@PathVariable String name){
        return productRepository.findByName(name);
    }
    @PostMapping("/save")
    public long save(@RequestBody Product product){
        productRepository.save(product);
        return product.getProduct_id();
    }
    @PutMapping("/updatePhoto/{id}/{state}")
    public void updatePhoto(@PathVariable long id,@PathVariable int state){
        productRepository.updatePhoto(id,state);
    }
    @PutMapping("/update")
    public void update(@RequestBody Product product){
        productRepository.update(product);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        productRepository.delete(id);
    }
    @DeleteMapping("/deleteMore")
    public void deleteMore(@RequestBody int[] ids){
        productRepository.deleteMore(ids);
    }
    @GetMapping("/findToIndex/{category_id}")
    public List<Product> findToIndex(@PathVariable Integer category_id){
        return productRepository.findToIndex(category_id);
    }
    @GetMapping("/findByCategoryId/{orderType}/{category_id}/{thisPage}")
    public ProductVO findToCategoryId(@PathVariable int orderType,@PathVariable Integer category_id,@PathVariable int thisPage){
        int current =thisPage;
        if (thisPage == 0){
            current =1;
        }
        ProductVO productVO =new ProductVO(current,productRepository.countByCategory(category_id));
        productVO.setPageSize(12);
        productVO.setList(productRepository.findByCategoryId(category_id,productVO.getStartIndex(),productVO.getPageSize(),orderType));
        return productVO;
    }
    @Autowired
    private CartRepository cartRepository;
    @GetMapping("/findCartById/{id}")
    public Cart findCartById(@PathVariable int id){
        return cartRepository.findById(id);
    }
    @GetMapping("/findCartByVipId/{v_id}")
    public List<Cart> findCartByVipId(@PathVariable int v_id){
        return cartRepository.findByVipId(v_id);
    }
    @GetMapping("/findCartByProductId/{p_id}")
    public Cart findCartByProductId(@PathVariable int p_id){
        return cartRepository.findByProductId(p_id);
    }
    @PostMapping("/saveCart")
    public void saveCart(@RequestBody Cart cart){
        cartRepository.saveCart(cart);
    }
    @PutMapping("/updateCart")
    public void updateCart(@RequestBody Cart cart){
        cartRepository.updateCart(cart);
    }
    @DeleteMapping("/deleteCart/{id}")
    public void deleteCart(@PathVariable int id){
        cartRepository.deleteCart(id);
    }
    @DeleteMapping("/deleteMoreCart")
    public void deleteMoreCart(@RequestBody int[] ids){
        cartRepository.deleteMore(ids);
    }
}
