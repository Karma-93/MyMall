package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员价格的dao
 */
@Mapper
public interface PmsMemberPriceDao {
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
