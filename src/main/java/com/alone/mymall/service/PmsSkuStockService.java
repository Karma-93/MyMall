package com.alone.mymall.service;


import com.alone.mymall.mgb.model.PmsSkuStock;

import java.util.List;

public interface PmsSkuStockService {
    /**
     * 根据产品id和skuCoke模糊搜索
     * @param pid
     * @param keyWord
     * @return
     */
    List<PmsSkuStock> getList(Long pid,String keyWord);

    /**
     * 批量更新
     * @param pid
     * @param skuStockList
     * @return
     */
    int update(Long pid,List<PmsSkuStock> skuStockList);

}
