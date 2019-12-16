package com.alone.mymall.service.impl;

import com.alone.mymall.dao.SmsCouponDao;
import com.alone.mymall.mgb.mapper.SmsCouponMapper;
import com.alone.mymall.mgb.model.SmsCoupon;
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
    @Override
    public int create(SmsCouponParam couponParam) {
        return 0;
    }

    @Override
    public int delete(Long id) {
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
