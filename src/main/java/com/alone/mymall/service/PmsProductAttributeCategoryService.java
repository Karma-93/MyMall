package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类管理
 */
public interface PmsProductAttributeCategoryService {

    /**
     * 添加上平属性分类
     * @param pmsProductAttributeCategory
     * @return
     */
    int create(PmsProductAttributeCategory pmsProductAttributeCategory);

    /**
     * 分页查询所有商品属性分类
     * @return
     */
    List<PmsProductAttributeCategory> list();

    /**
     * 删除单个商品属性分类
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改、更新单个商品属性分类
     * @param pmsProductAttributeCategory
     * @return
     */
    int update(PmsProductAttributeCategory pmsProductAttributeCategory);

    /**
     * 查询单个属性分类信息
     * @param id
     * @return
     */
    PmsProductAttributeCategory getProductAttributeCategory(Long id);
}
