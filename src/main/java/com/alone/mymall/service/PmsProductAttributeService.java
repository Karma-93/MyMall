package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.PmsProductAttribute;

import java.util.List;

/**
 * 商品属性管理
 */
public interface PmsProductAttributeService {

    /**
     * 创建商品属性
     * @param pmsProductAttribute
     * @return
     */
    int create(PmsProductAttribute pmsProductAttribute);

    /**
     * 根据分类查询属性列表或者参数列表（分页，）
     * @return
     */
    List<PmsProductAttribute> list();

    /**
     * 查询单个商品属性
     * @param id
     * @return
     */
    PmsProductAttribute getProductAttribute(Long id);

    /**
     * 批量删除商品属性
     * @param ids
     * @return
     */
    int deleteBatch(List<Long> ids);

    /**
     * 更新商品属性
     * @param pmsProductAttribute
     * @return
     */
    int update(PmsProductAttribute pmsProductAttribute);
}
