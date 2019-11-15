package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.PmsProductMapper;
import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.PmsProductExample;
import com.alone.mymall.pojo.PmsProductParam;
import com.alone.mymall.pojo.PmsProductQueryParam;
import com.alone.mymall.pojo.PmsProductResult;
import com.alone.mymall.service.PmsProductService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    public int create(PmsProductParam pmsProductParam) {
        PmsProduct pmsProduct=new PmsProduct();
        BeanUtils.copyProperties(pmsProductParam,pmsProduct);
        return pmsProductMapper.insertSelective(pmsProduct);
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {
        return null;
    }

    @Override
    public int update(Long id, PmsProductParam pmsProductParam) {
        PmsProduct pmsProduct=new PmsProduct();
        pmsProduct.setId(id);
        BeanUtils.copyProperties(pmsProductParam,pmsProduct);
        return pmsProductMapper.updateByPrimaryKeySelective(pmsProduct);
    }

    @Override
    public List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageNum, Integer pageSize) {

        return null;
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        PmsProduct pmsProduct=new PmsProduct();
        pmsProduct.setVerifyStatus(verifyStatus);
        PmsProductExample pmsProductExample=new PmsProductExample();
        pmsProductExample.createCriteria().andIdIn(ids);

        return 0;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return 0;
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommend) {
        return 0;
    }

    @Override
    public int upddateNewStatus(List<Long> ids, Integer newstatus) {
        return 0;
    }

    @Override
    public int updateDeleteStatus(List<Long> ids) {
        return 0;
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        return null;
    }
}
