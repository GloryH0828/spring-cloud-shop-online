package com.gloryh.repository;

import com.gloryh.entity.Promotion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 促销相关接口类
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@Repository
public interface PromotionRepository {
    /**
     * 查询所有信息并做分页处理
     * @param index
     * @param limit
     * @return
     */
    public List<Promotion> findAll(int index,int limit);

    /**
     * 按 商品 id 查询
     * @param p_id
     * @param type
     * @return
     */
    public List<Promotion> findByProductId(@Param("p_id") long p_id,@Param("type") int type);

    /**
     * 统计所有促销信息
     * @return
     */
    public int count();

    /**
     * 按 促销 id 查询
     * @param id
     * @return
     */
    public Promotion findById(long id);

    /**
     * 按 分类名查询
     * @param type_name
     * @return
     */
    public List<Promotion> findByCategory(String type_name);

    /**
     * 按商品名称查询
     * @param name
     * @return
     */
    public List<Promotion> findByProductName(String name);

    /**
     * 添加新促销
     * @param promotion
     */
    public void save(Promotion promotion);

    /**
     * 更新促销信息
     * @param promotion
     */
    public void update(Promotion promotion);

    /**
     * 删除促销信息
     * @param id
     */
    public void delete(long id);

    /**
     * 批量删除促销信息
     * @param ids
     */
    public void deleteMore(long[] ids);
}
