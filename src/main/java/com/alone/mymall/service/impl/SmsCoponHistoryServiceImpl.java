package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.SmsCouponHistoryMapper;
import com.alone.mymall.mgb.model.SmsCouponHistory;
import com.alone.mymall.mgb.model.SmsCouponHistoryExample;
import com.alone.mymall.service.SmsCouponHistoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SmsCoponHistoryServiceImpl implements SmsCouponHistoryService {

    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;

    @Override
    public List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = example.createCriteria();
        if(couponId!=null){
            criteria.andCouponIdEqualTo(couponId);
        }
        if(useStatus!=null){
            criteria.andUseStatusEqualTo(useStatus);
        }
        if(!StringUtils.isEmpty(orderSn)){
            criteria.andOrderSnEqualTo(orderSn);
        }
        return couponHistoryMapper.selectByExample(example);
    }
}
