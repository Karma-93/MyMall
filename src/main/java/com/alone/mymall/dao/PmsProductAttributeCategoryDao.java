package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProductAttributeCategory;
import com.alone.mymall.pojo.PmsProductAttributeCategoryItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 自定义商品属性分类dao
 */
@Mapper
public interface PmsProductAttributeCategoryDao {
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
