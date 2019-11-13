package com.alone.mymall.dao;


import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.pojo.PmsProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PmsProductCategoryDao{
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
