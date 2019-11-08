package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.mapper.PmsBrandMapper;
import com.alone.mymall.mgb.model.PmsBrand;
import com.alone.mymall.mgb.model.PmsBrandExample;
import com.alone.mymall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper mapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return mapper.selectByExample(new PmsBrandExample());

    }

    @Override
    public int createBrand(PmsBrand brand) {
        return mapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return mapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }


    public int deleteBrand(List<Long> ids){
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        PmsBrandExample.Criteria criteria=pmsBrandExample.createCriteria();
        criteria.andIdIn(ids);
        return mapper.deleteByExample(pmsBrandExample);


    }

    @Override
    public List<PmsBrand> listBrand(String keyword,int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        PmsBrandExample.Criteria criteria=pmsBrandExample.createCriteria();
        pmsBrandExample.setOrderByClause("sort desc");
        if(!StringUtils.isEmpty(keyword)){
            criteria.andNameLike(keyword);
        }
        return mapper.selectByExample(pmsBrandExample);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand pmsBrand=new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        PmsBrandExample.Criteria criteria=pmsBrandExample.createCriteria();
        criteria.andIdIn(ids);
        return mapper.updateByExampleSelective(pmsBrand,pmsBrandExample);
    }

    @Override
    public int updateFactoryStatus(List<Long> id, Integer factoryStatus) {
        PmsBrand pmsBrand=new PmsBrand();
        pmsBrand.setFactoryStatus(factoryStatus);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(id);
        return mapper.updateByExampleSelective(pmsBrand,pmsBrandExample);
    }
}
