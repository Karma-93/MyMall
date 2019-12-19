package com.alone.mymall.service.impl;


import com.alone.mymall.mgb.mapper.OmsCompanyAddressMapper;
import com.alone.mymall.mgb.model.OmsCompanyAddress;
import com.alone.mymall.mgb.model.OmsCompanyAddressExample;
import com.alone.mymall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
