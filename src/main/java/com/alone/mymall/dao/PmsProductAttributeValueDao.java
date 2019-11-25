package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.mgb.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 上平参数，商品自定义规格dao
 */
@Mapper
public interface PmsProductAttributeValueDao {
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
