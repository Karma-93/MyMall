package com.alone.mymall.service.impl;

import com.alone.mymall.dao.*;
import com.alone.mymall.mgb.mapper.*;
import com.alone.mymall.mgb.model.*;
import com.alone.mymall.pojo.PmsProductParam;
import com.alone.mymall.pojo.PmsProductQueryParam;
import com.alone.mymall.pojo.PmsProductResult;
import com.alone.mymall.service.PmsProductService;
import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * 商品列表service
 */
@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    private PmsProductDao productDao;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductLadderDao productLadderDao;
    @Autowired
    private PmsMemberPriceDao memberPriceDao;
    @Autowired
    private PmsMemberPriceMapper memberPriceMapper;
    @Autowired
    private PmsProductLadderMapper productLadderMapper;
    @Autowired
    private PmsProductFullReductionDao productFullReductionDao;
    @Autowired
    private PmsProductFullReductionMapper productFullReductionMapper;
    @Autowired
    private PmsSkuStockDao skuStockDao;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductAttributeValueDao productAttributeValueDao;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private PmsProductVerifyRecordDao productVerifyRecordDao;


    @Override
    public int create(PmsProductParam pmsProductParam) {
        int count;
        //创建商品
        PmsProduct pmsProduct=pmsProductParam;
        pmsProduct.setId(null);
        productMapper.insertSelective(pmsProduct);
        //根据促销类型设置价格：/阶梯价格、满减价格
        Long productId=pmsProduct.getId();
        //会员价格
        relateAndInsertList(memberPriceDao,pmsProductParam.getMemberPriceList(),productId);
        //阶梯价格
        relateAndInsertList(productLadderDao,pmsProductParam.getProductLadderList(),productId);
        //满减价格
        relateAndInsertList(productFullReductionDao,pmsProductParam.getProductFullReductionList(),productId);
        //处理sku编码
        handleSkuStockCode(pmsProductParam.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(skuStockDao,pmsProductParam.getSkuStockList(),productId);
        //添加商品参数，添加自定义商品规格
        relateAndInsertList(productAttributeValueDao,pmsProductParam.getProductAttributeValueList(),productId);

        count=1;
        return count;
    }

    //处理sku编码
    private void handleSkuStockCode(List<PmsSkuStock> skuStockList,Long productId){
        if(CollectionUtils.isEmpty(skuStockList))return;
        for(int i=0;i<skuStockList.size();i++){
            PmsSkuStock pmsSkuStock=skuStockList.get(i);
            if(StringUtils.isEmpty(pmsSkuStock.getSkuCode())){
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb=new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d",productId));
                //三位索引ID
                sb.append(String.format("%03d",i+1));
                pmsSkuStock.setSkuCode(sb.toString());
            }
        }
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {
        return productDao.getUpdateInfo(id);

    }

    @Override
    public int update(Long id, PmsProductParam productParam) {
        int count;
        //更新商品信息
        PmsProduct pmsProduct=productParam;
        pmsProduct.setId(id);
        productMapper.updateByPrimaryKeySelective(pmsProduct);

        //会员价格
        PmsMemberPriceExample pmsMemberPriceExample = new PmsMemberPriceExample();
        pmsMemberPriceExample.createCriteria().andProductIdEqualTo(id);
        memberPriceMapper.deleteByExample(pmsMemberPriceExample);
        relateAndInsertList(memberPriceDao, productParam.getMemberPriceList(), id);
        //阶梯价格
        PmsProductLadderExample ladderExample = new PmsProductLadderExample();
        ladderExample.createCriteria().andProductIdEqualTo(id);
        productLadderMapper.deleteByExample(ladderExample);
        relateAndInsertList(productLadderDao, productParam.getProductLadderList(), id);
        //满减价格
        PmsProductFullReductionExample fullReductionExample = new PmsProductFullReductionExample();
        fullReductionExample.createCriteria().andProductIdEqualTo(id);
        productFullReductionMapper.deleteByExample(fullReductionExample);
        relateAndInsertList(productFullReductionDao, productParam.getProductFullReductionList(), id);
        //修改sku库存信息
        PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
        skuStockExample.createCriteria().andProductIdEqualTo(id);
        skuStockMapper.deleteByExample(skuStockExample);
        handleSkuStockCode(productParam.getSkuStockList(),id);
        relateAndInsertList(skuStockDao, productParam.getSkuStockList(), id);
        //修改商品参数,添加自定义商品规格
        PmsProductAttributeValueExample productAttributeValueExample = new PmsProductAttributeValueExample();
        productAttributeValueExample.createCriteria().andProductIdEqualTo(id);
        productAttributeValueMapper.deleteByExample(productAttributeValueExample);
        relateAndInsertList(productAttributeValueDao, productParam.getProductAttributeValueList(), id);
        count=1;
        return count;
    }

    @Override
    public List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample productExample=new PmsProductExample();
        PmsProductExample.Criteria criteria=productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (pmsProductQueryParam.getPublishStatus() != null) {
            criteria.andPublishStatusEqualTo(pmsProductQueryParam.getPublishStatus());
        }
        if (pmsProductQueryParam.getVerifyStatus() != null) {
            criteria.andVerifyStatusEqualTo(pmsProductQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(pmsProductQueryParam.getKeyword())) {
            criteria.andNameLike("%" + pmsProductQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(pmsProductQueryParam.getProductSn())) {
            criteria.andProductSnEqualTo(pmsProductQueryParam.getProductSn());
        }
        if (pmsProductQueryParam.getBrandId() != null) {
            criteria.andBrandIdEqualTo(pmsProductQueryParam.getBrandId());
        }
        if (pmsProductQueryParam.getProductCategoryId() != null) {
            criteria.andProductCategoryIdEqualTo(pmsProductQueryParam.getProductCategoryId());
        }
        return productMapper.selectByExample(productExample);
    }

    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        PmsProduct pmsProduct=new PmsProduct();
        pmsProduct.setVerifyStatus(verifyStatus);
        PmsProductExample pmsProductExample=new PmsProductExample();
        pmsProductExample.createCriteria().andIdIn(ids);
        List<PmsProductVerifyRecord> list=new ArrayList<>();
        int count=productMapper.updateByExampleSelective(pmsProduct,pmsProductExample);
        for(Long id:ids){
            PmsProductVerifyRecord record=new PmsProductVerifyRecord();
            record.setProductId(id);
            record.setCreateTime(new Date());
            record.setDetail(detail);
            record.setVertifyMan("test");
            record.setStatus(verifyStatus);
            list.add(record);
        }
        productVerifyRecordDao.insertList(list);
        return count;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        PmsProduct product=new PmsProduct();
        product.setPublishStatus(publishStatus);
        PmsProductExample pmsProductExample=new PmsProductExample();
        pmsProductExample.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(product,pmsProductExample);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommend) {
        PmsProduct product=new PmsProduct();
        product.setRecommandStatus(recommend);
        PmsProductExample productExample=new PmsProductExample();
        productExample.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(product,productExample);
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newstatus) {
        PmsProduct product=new PmsProduct();
        product.setNewStatus(newstatus);
        PmsProductExample productExample=new PmsProductExample();
        productExample.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(product,productExample);
    }

    @Override
    public int updateDeleteStatus(List<Long> ids,Integer deletestatus) {
        PmsProduct product=new PmsProduct();
        product.setDeleteStatus(deletestatus);
        PmsProductExample productExample=new PmsProductExample();
        productExample.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(product,productExample);
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        PmsProductExample productExample=new PmsProductExample();
        PmsProductExample.Criteria criteria= productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (StringUtils.isEmpty(keyword)){
            criteria.andNameLike("%"+keyword+"%");
            productExample.or().andDeleteStatusEqualTo(0).andProductSnLike("%" + keyword + "%");
        }
        return productMapper.selectByExample(productExample);
    }


    /**
     * 建立插入表关系操作
     * @param dao       可以操作的Dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的ID
     */
    private void relateAndInsertList(Object dao,List dataList,Long productId){
        try {
            if(CollectionUtils.isEmpty(dataList)) return;
            for(Object item:dataList){
                Method setId=item.getClass().getMethod("setId",Long.class);
                setId.invoke(item,(Long)null);
                Method setProductId=item.getClass().getMethod("setProductId",Long.class);
                setProductId.invoke(item,productId);
            }
            Method insertList=dao.getClass().getMethod("insertList",List.class);
            insertList.invoke(dao,dataList);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}


