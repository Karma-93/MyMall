package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.pojo.PmsProductResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品列表自定义Dao
 */
@Mapper
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
