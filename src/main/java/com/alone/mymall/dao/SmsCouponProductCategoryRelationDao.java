package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 优惠券和商品分类关系自定义Dao
 * Created by macro on 2018/8/28.
 */

@Mapper
public interface SmsCouponProductCategoryRelationDao {
    int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}