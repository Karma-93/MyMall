package com.alone.mymall.dao;


import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.mgb.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 自定义商品分类和属性关系dao
 *
 */
@Mapper
public interface PmsProductCategoryAttributeRelationDao {
    int insertList(List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
