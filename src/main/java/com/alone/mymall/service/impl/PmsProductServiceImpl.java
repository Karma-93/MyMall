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
import org.springframework.util.CollectionUtils;

import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 商品列表service
 */
@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    public int create(PmsProductParam pmsProductParam) {
        int count;
        //创建商品
        PmsProduct pmsProduct=pmsProductParam;
        pmsProduct.setId(null);
        pmsProductMapper.insertSelective(pmsProduct);
        //根据促销类型设置价格：/阶梯价格、满减价格
        Long productId=pmsProduct.getId();
        //会员价格

        return count;
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


    /**
     * 建立插入表关系操作
     * @param dao       可以操作的Dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的ID
     */
    private void relateAndInsertList(Object dao,List dataList,Long productId){
        try {
            if(CollectionUtils.isEmpty(dataList)) return;
            for(Object item:dataList){
                Method setId=item.getClass().getMethod("setId",Long.class);
                setId.invoke(item,(Long)null);

            }
        }catch (Exception e){

        }
    }
}
