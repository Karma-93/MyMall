package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.PmsSkuStock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PmsSkuStockDao {
    int relaceList(List<PmsSkuStock> pmsSkuStockList);
}
