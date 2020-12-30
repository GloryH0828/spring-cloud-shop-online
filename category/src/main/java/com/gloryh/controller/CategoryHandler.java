package com.gloryh.controller;

import com.gloryh.entity.Category;
import com.gloryh.entity.CategoryVO;
import com.gloryh.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * category controller
 *
 * @author 黄光辉
 * @since 2020/11/4
 **/
@RestController
@RequestMapping("/category")
public class CategoryHandler {
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/findAll/{thisPage}")
    public CategoryVO findAll(@PathVariable int thisPage ){
        int current=thisPage;
        if (thisPage==0){
            current =1;
        }
        CategoryVO categoryVO=new CategoryVO(current,categoryRepository.count());
        categoryVO.setList(categoryRepository.findAll(categoryVO.getStartIndex(), categoryVO.getPageSize()));
        return categoryVO;
    }
    @GetMapping("/findByName/{type_name}")
    public Category findByName(@PathVariable String type_name){
        return categoryRepository.findByName(type_name);
    }
    @GetMapping("/findAllNoPage")
    public List<Category> findAllNoPage(){
        return categoryRepository.findAllNoPage();
    }
    @GetMapping("/findById/{id}")
    public Category findById(@PathVariable Long id){
        return categoryRepository.findById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Category category){
        categoryRepository.save(category);
    }
    @PutMapping("/update")
    public void update(@RequestBody Category category){
        categoryRepository.update(category);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        categoryRepository.delete(id);
    }

    @DeleteMapping("/deleteMore")
    private void deleteMore(@RequestBody int[] ids){
        categoryRepository.deleteMore(ids);
    }
}
