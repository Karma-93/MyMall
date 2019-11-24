package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.pojo.PmsProductAttrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品属性dao
 *
 */
@Mapper
public interface PmsProductAttributeDao {
    List<PmsProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
