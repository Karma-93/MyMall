package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.PmsSkuStockMapper;
import com.alone.mymall.mgb.model.PmsSkuStock;
import com.alone.mymall.mgb.model.PmsSkuStockExample;
import com.alone.mymall.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;


    @Override
    public List<PmsSkuStock> getList(Long pid, String keyWord) {
        return null;
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {

        return 0;
    }
}
