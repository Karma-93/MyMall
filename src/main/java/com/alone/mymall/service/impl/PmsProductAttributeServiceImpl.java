package com.alone.mymall.service.impl;

import com.alone.mymall.dao.PmsProductAttributeCategoryDao;
import com.alone.mymall.dao.PmsProductAttributeDao;
import com.alone.mymall.mgb.mapper.PmsProductAttributeCategoryMapper;
import com.alone.mymall.mgb.mapper.PmsProductAttributeMapper;
import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.mgb.model.PmsProductAttributeCategory;
import com.alone.mymall.mgb.model.PmsProductAttributeExample;
import com.alone.mymall.pojo.PmsProductAttrInfo;
import com.alone.mymall.pojo.PmsProductAttributeParam;
import com.alone.mymall.service.PmsProductAttributeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeDao productAttributeDao;

    @Override
    public int create(PmsProductAttributeParam pmsProductAttributeParam) {
        PmsProductAttribute pmsProductAttribute=new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeParam,pmsProductAttribute);
        int count=pmsProductAttributeMapper.insertSelective(pmsProductAttribute);
        //新增商品属性以后要更新商品属性分类数量
        PmsProductAttributeCategory productAttributeCategory=productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        if (pmsProductAttributeParam.getType()==0){
            productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount()+1);
        }else if(pmsProductAttributeParam.getType()==1){
            productAttributeCategory.setParamCount(productAttributeCategory.getParamCount()+1);
        }
        productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
        return count;
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
        //获取分类
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = pmsProductAttribute.getType();
        PmsProductAttributeCategory pmsProductAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = pmsProductAttributeMapper.deleteByExample(example);
        //删除完成后修改数量
        if(type==0){
            if(pmsProductAttributeCategory.getAttributeCount()>=count){
                pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount()-count);
            }else{
                pmsProductAttributeCategory.setAttributeCount(0);
            }
        }else if(type==1){
            if(pmsProductAttributeCategory.getParamCount()>=count){
                pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount()-count);
            }else{
                pmsProductAttributeCategory.setParamCount(0);
            }
        }
        productAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return count;
    }

    @Override
    public int update(Long id,PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute productAttribute=new PmsProductAttribute();
        productAttribute.setId(id);
        BeanUtils.copyProperties(productAttributeParam,productAttribute);
        return pmsProductAttributeMapper.updateByPrimaryKeySelective(productAttribute);
    }
    @Override
    public List<PmsProductAttrInfo> getProductAttrInfo(Long productCategoryId) {
        return productAttributeDao.getProductAttrInfo(productCategoryId);
    }
}
