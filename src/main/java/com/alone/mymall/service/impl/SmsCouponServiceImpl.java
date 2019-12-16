package com.alone.mymall.service.impl;

import com.alone.mymall.dao.SmsCouponDao;
import com.alone.mymall.dao.SmsCouponProductCategoryRelationDao;
import com.alone.mymall.dao.SmsCouponProductRelationDao;
import com.alone.mymall.mgb.mapper.SmsCouponMapper;
import com.alone.mymall.mgb.mapper.SmsCouponProductCategoryRelationMapper;
import com.alone.mymall.mgb.mapper.SmsCouponProductRelationMapper;
import com.alone.mymall.mgb.model.SmsCoupon;
import com.alone.mymall.mgb.model.SmsCouponProductCategoryRelation;
import com.alone.mymall.mgb.model.SmsCouponProductRelation;
import com.alone.mymall.pojo.SmsCouponParam;
import com.alone.mymall.service.SmsCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsCouponServiceImpl implements SmsCouponService {


    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponDao couponDao;
    @Autowired
    private SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired

    private SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired

    private SmsCouponProductRelationDao couponProductRelationDao;
    @Autowired

    private SmsCouponProductCategoryRelationDao couponProductCategoryRelationDao;

    @Override
    public int create(SmsCouponParam couponParam) {
        couponParam.setCount(couponParam.getPublishCount());
        couponParam.setUseCount(0);
        couponParam.setReceiveCount(0);
        //插入优惠卷表
        int count=couponMapper.insert(couponParam);
        //插入优惠卷和商品关系
        if(couponParam.getUseType().equals(2)){
            for (SmsCouponProductRelation couponProductRelation:couponParam.getProductRelationList()){
                couponProductRelation.setCouponId(couponParam.getId());
            }
            couponProductRelationDao.insertList(couponParam.getProductRelationList());
        }
        //插入优惠卷和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for(SmsCouponProductCategoryRelation couponProductCategoryRelation:couponParam.getProductCategoryRelationList()){
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            couponProductCategoryRelationDao.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public int delete(Long id)
    {
        int count=couponMapper.deleteByPrimaryKey(id);
        couponProductRelationMapper.deleteByPrimaryKey(id);
        couponProductCategoryRelationMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int update(Long id, SmsCouponParam couponParam) {
        return 0;
    }

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return null;
    }
}
