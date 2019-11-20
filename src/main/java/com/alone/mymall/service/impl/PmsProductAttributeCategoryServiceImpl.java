package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.PmsProductAttributeCategoryMapper;
import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.mgb.model.PmsProductAttributeCategory;
import com.alone.mymall.mgb.model.PmsProductAttributeCategoryExample;
import com.alone.mymall.service.PmsProductAttributeCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {

    @Autowired
    private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;
    @Override
    public int create(String name) {
        PmsProductAttributeCategory pmsProductAttributeCategory=new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setName(name);
        return pmsProductAttributeCategoryMapper.insert(pmsProductAttributeCategory);
    }

    @Override
    public List<PmsProductAttributeCategory> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductAttributeCategoryExample pmsProductAttributeCategoryExample=new PmsProductAttributeCategoryExample();
        pmsProductAttributeCategoryExample.setOrderByClause("sort desc");
        return pmsProductAttributeCategoryMapper.selectByExample(pmsProductAttributeCategoryExample);
    }

    @Override
    public int delete(Long id) {
        return pmsProductAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        PmsProductAttributeCategoryExample pmsProductAttributeCategoryExample=new PmsProductAttributeCategoryExample();
        pmsProductAttributeCategoryExample.createCriteria().andIdIn(ids);
        return pmsProductAttributeCategoryMapper.deleteByExample(pmsProductAttributeCategoryExample);
    }

    @Override
    public int update(Long id, String name) {
        PmsProductAttributeCategory pmsProductAttributeCategory=new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setName(name);
        pmsProductAttributeCategory.setId(id);
        pmsProductAttributeCategoryMapper.updateByPrimaryKeySelective(pmsProductAttributeCategory);
        return 0;
    }

    @Override
    public PmsProductAttributeCategory getItem(Long id) {
        return pmsProductAttributeCategoryMapper.selectByPrimaryKey(id);
    }
}
