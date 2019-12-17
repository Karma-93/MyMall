package com.alone.mymall.service.impl;

import com.alone.mymall.dao.SmsCouponDao;
import com.alone.mymall.dao.SmsCouponProductCategoryRelationDao;
import com.alone.mymall.dao.SmsCouponProductRelationDao;
import com.alone.mymall.mgb.mapper.SmsCouponMapper;
import com.alone.mymall.mgb.mapper.SmsCouponProductCategoryRelationMapper;
import com.alone.mymall.mgb.mapper.SmsCouponProductRelationMapper;
import com.alone.mymall.mgb.model.*;
import com.alone.mymall.pojo.SmsCouponParam;
import com.alone.mymall.service.SmsCouponService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        //删除商品关联
        deleteProductRelation(id);
        //删除商品分类关联
        deleteProductCategoryRelation(id);
        return 0;
    }

    private void deleteProductRelation(Long id) {
        SmsCouponProductRelationExample couponProductRelationExample=new SmsCouponProductRelationExample();
        couponProductRelationExample.createCriteria().andCouponIdEqualTo(id);
        couponProductRelationMapper.deleteByExample(couponProductRelationExample);
    }

    private void deleteProductCategoryRelation(Long id) {
        SmsCouponProductCategoryRelationExample couponProductCategoryRelationExample=new SmsCouponProductCategoryRelationExample();
        couponProductCategoryRelationExample.createCriteria().andCouponIdEqualTo(id);
        couponProductCategoryRelationMapper.deleteByExample(couponProductCategoryRelationExample);
    }

    @Override
    public int update(Long id, SmsCouponParam couponParam) {
        couponParam.setId(id);
        int count =couponMapper.updateByPrimaryKey(couponParam);
        //删除后插入优惠券和商品关系表
        if(couponParam.getUseType().equals(2)){
            for(SmsCouponProductRelation productRelation:couponParam.getProductRelationList()){
                productRelation.setCouponId(couponParam.getId());
            }
            deleteProductRelation(id);
            couponProductRelationDao.insertList(couponParam.getProductRelationList());
        }
        //删除后插入优惠券和商品分类关系表
        if(couponParam.getUseType().equals(1)){
            for (SmsCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            deleteProductCategoryRelation(id);
            couponProductCategoryRelationDao.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        SmsCouponExample example = new SmsCouponExample();
        SmsCouponExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if(type!=null){
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum,pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return couponDao.getItem(id);
    }
}
