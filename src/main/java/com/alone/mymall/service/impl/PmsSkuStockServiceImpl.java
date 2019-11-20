package com.alone.mymall.service.impl;

import com.alone.mymall.dao.PmsSkuStockDao;
import com.alone.mymall.mgb.mapper.PmsSkuStockMapper;
import com.alone.mymall.mgb.model.PmsSkuStock;
import com.alone.mymall.mgb.model.PmsSkuStockExample;
import com.alone.mymall.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;
    @Autowired
    private PmsSkuStockDao pmsSkuStockDao;

    @Override
    public List<PmsSkuStock> getList(Long pid, String keyWord) {
        PmsSkuStockExample pmsSkuStockExample=new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria= pmsSkuStockExample.createCriteria().andProductIdEqualTo(pid);
        if(!StringUtils.isEmpty(keyWord)){
            criteria.andSkuCodeLike("%"+keyWord+"%");
        }
        return pmsSkuStockMapper.selectByExample(pmsSkuStockExample);
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        return pmsSkuStockDao.relaceList(skuStockList);

    }
}
