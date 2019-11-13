package com.alone.mymall.service.impl;

import com.alone.mymall.common.api.CommonPage;
import com.alone.mymall.dao.PmsProductCategoryDao;
import com.alone.mymall.mgb.mapper.PmsProductCategoryMapper;
import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.mgb.model.PmsProductCategoryExample;
import com.alone.mymall.pojo.PmsProductCategoryParam;
import com.alone.mymall.pojo.PmsProductCategoryWithChildrenItem;
import com.alone.mymall.service.PmsProductCategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {


    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao;
   @Autowired
    private PmsProductCategoryMapper productCategoryMapper;

    @Override
    public List<PmsProductCategory> listAllProductCategory() {
        return productCategoryMapper.selectByExample(new PmsProductCategoryExample());
    }

    @Override
    public int createProductCategory(PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory productCategory=new PmsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(pmsProductCategoryParam,productCategory);
        setCategoryLevel(productCategory);
        return productCategoryMapper.insertSelective(productCategory);
    }

    @Override
    public int updateProductCategory(Long id, PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory pmsProductCategory=new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryParam,pmsProductCategory);
        pmsProductCategory.setId(id);
        return productCategoryMapper.updateByPrimaryKeySelective(pmsProductCategory);
    }

    @Override
    public int deleteProductCategory(Long id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteProductCategory(List<Long> ids) {
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andIdIn(ids);
        return productCategoryMapper.deleteByExample(pmsProductCategoryExample);
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageNum, Integer PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.setOrderByClause("sort desc");
        pmsProductCategoryExample.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(pmsProductCategoryExample);
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }


    //批量修改导航栏显示状态
    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory productCategory=new PmsProductCategory();
        productCategory.setNavStatus(navStatus);
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory,pmsProductCategoryExample);
    }


    //修改显示状态
    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory productCategory=new PmsProductCategory();
        productCategory.setShowStatus(showStatus);
        PmsProductCategoryExample productCategoryExample=new PmsProductCategoryExample();
        productCategoryExample.createCriteria().andIdIn(ids);
        return productCategoryMapper.updateByExampleSelective(productCategory,productCategoryExample);
    }

    //查询子分类
    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return pmsProductCategoryDao.listWithChildren();

    }

    //设置分类等级
    private void setCategoryLevel(PmsProductCategory pmsProductCategory){
        if (pmsProductCategory.getParentId()==0) {
            pmsProductCategory.setLevel(0);
        }else {
            //有父分类是根据父分类等级配置
            PmsProductCategory parentCategory=productCategoryMapper.selectByPrimaryKey(pmsProductCategory.getParentId());
            if (parentCategory!=null){
                pmsProductCategory.setLevel(parentCategory.getLevel()+1);
            }else {
                pmsProductCategory.setLevel(0);
            }
        }
    }
}
