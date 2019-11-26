package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.PmsProductVerifyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品审核日志自定义dao
 */
@Mapper
public interface PmsProductVerifyRecordDao {
    int insertList(@Param("list") List<PmsProductVerifyRecord> productVerifyRecordList);
}
