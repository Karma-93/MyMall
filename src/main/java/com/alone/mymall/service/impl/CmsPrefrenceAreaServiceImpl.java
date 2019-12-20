package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.CmsPrefrenceAreaMapper;
import com.alone.mymall.mgb.model.CmsPrefrenceArea;
import com.alone.mymall.mgb.model.CmsPrefrenceAreaExample;
import com.alone.mymall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
