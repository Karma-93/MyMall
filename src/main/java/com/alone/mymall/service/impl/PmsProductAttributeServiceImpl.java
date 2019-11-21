package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.PmsProductAttributeMapper;
import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.mgb.model.PmsProductAttributeExample;
import com.alone.mymall.service.PmsProductAttributeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;
    @Override
    public int create(PmsProductAttribute pmsProductAttribute) {
        return pmsProductAttributeMapper.insertSelective(pmsProductAttribute);
    }

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductAttributeExample pmsProductAttributeExample=new PmsProductAttributeExample();
        pmsProductAttributeExample.setOrderByClause("sort desc");
        pmsProductAttributeExample.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return pmsProductAttributeMapper.selectByExample(pmsProductAttributeExample);
    }

    @Override
    public List<PmsProductAttribute> listAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsProductAttributeMapper.selectByExample(new PmsProductAttributeExample());
    }

    @Override
    public PmsProductAttribute getProductAttribute(Long id) {
        return pmsProductAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        PmsProductAttributeExample pmsProductAttributeExample=new PmsProductAttributeExample();
        pmsProductAttributeExample.createCriteria().andIdIn(ids);
        return pmsProductAttributeMapper.deleteByExample(pmsProductAttributeExample);
    }

    @Override
    public int update(PmsProductAttribute pmsProductAttribute) {
        return pmsProductAttributeMapper.updateByPrimaryKeySelective(pmsProductAttribute);
    }
}
