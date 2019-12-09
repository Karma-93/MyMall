package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.UmsMemberLevelMapper;
import com.alone.mymall.mgb.model.UmsMemberLevel;
import com.alone.mymall.mgb.model.UmsMemberLevelExample;
import com.alone.mymall.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example=new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
