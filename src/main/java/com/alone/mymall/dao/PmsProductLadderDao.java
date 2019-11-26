package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProductLadder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员阶梯价格dao
 */
@Mapper
public interface PmsProductLadderDao {
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
