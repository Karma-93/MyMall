package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsProductAttributeCategory;
import com.alone.mymall.pojo.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 商品属性分类管理
 */
public interface PmsProductAttributeCategoryService {

    /**
     * 添加商品属性分类(根据名称)
     * @param
     * @return
     */
    int create(String name);

    /**
     * 分页查询所有商品属性分类
     * @return
     */
    List<PmsProductAttributeCategory> list(Integer pageNum,Integer pageSize);

    /**
     * 删除单个商品属性分类
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     *
     * 批量删除商品属性分类
     * @param id
     * @return
     */
    int deleteBatch(List<Long> id);

    /**
     * 修改、更新单个商品属性分类
     * @param
     * @return
     */
    int update(Long id,String name);

    /**
     * 查询单个属性分类信息
     * @param id
     * @return
     */
    PmsProductAttributeCategory getItem(Long id);

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
