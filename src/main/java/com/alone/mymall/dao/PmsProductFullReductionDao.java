package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 自定义商品满减dao
 */
@Mapper
public interface PmsProductFullReductionDao {
    int insertList(List<PmsProductFullReduction> productFullReductionList);
}
