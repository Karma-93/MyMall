package com.alone.mymall.dao;


import com.alone.mymall.mgb.model.SmsCoupon;
import com.alone.mymall.pojo.SmsCouponParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 优惠券管理自定义dao
 */
@Mapper
public interface SmsCouponDao {
    SmsCouponParam getItem(@Param("id")Long id);
}
