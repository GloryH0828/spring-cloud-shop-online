package com.gloryh.controller;

import com.gloryh.entity.Promotion;
import com.gloryh.entity.PromotionVO;
import com.gloryh.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * promotion controller
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@RestController
@RequestMapping("/promotion")
public class PromotionHandler {
    @Autowired
    private PromotionRepository promotionRepository;

    @GetMapping("/findAll/{thisPage}")
    public PromotionVO findAll(@PathVariable int thisPage) {
        PromotionVO promotionVO = new PromotionVO(thisPage, promotionRepository.count());
        promotionVO.setPageSize(4);
        promotionVO.setList(promotionRepository.findAll(promotionVO.getStartIndex(), promotionVO.getPageSize()));
        return promotionVO;
    }

    @GetMapping("/findByProductId/{p_id}/{type}")
    public List<Promotion> findByProductId(@PathVariable long p_id,@PathVariable int type) {
        return promotionRepository.findByProductId(p_id,type);
    }

    @GetMapping("/findById/{id}")
    public Promotion findById(@PathVariable long id) {
        return promotionRepository.findById(id);
    }

    @GetMapping("/findByCategory/{type_name}")
    public List<Promotion> findByCategory(@PathVariable String type_name) {
        return promotionRepository.findByCategory(type_name);
    }

    @GetMapping("/findByProductName/{name}")
    public List<Promotion> findByProductName(@PathVariable String name) {
        return promotionRepository.findByProductName(name);
    }

    @PostMapping("/save")
    public void save(@RequestBody Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @PutMapping("/update")
    public void update(@RequestBody Promotion promotion) {
        promotionRepository.update(promotion);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        promotionRepository.delete(id);
    }

    @DeleteMapping("/deleteMore")
    public void deleteMore(@PathVariable long[] ids) {
        promotionRepository.deleteMore(ids);
    }
}
