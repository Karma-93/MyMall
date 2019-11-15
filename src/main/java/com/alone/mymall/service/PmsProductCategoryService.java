package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.pojo.PmsProductCategoryParam;
import com.alone.mymall.pojo.PmsProductCategoryWithChildrenItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品分类管理
 */
public interface PmsProductCategoryService {
    List<PmsProductCategory> listAllProductCategory();
    int createProductCategory(PmsProductCategoryParam pmsProductCategoryParam);
    int updateProductCategory(Long id,PmsProductCategoryParam pmsProductCategoryParam);
    int deleteProductCategory(Long id);
    int deleteProductCategory(List<Long> ids);
    List<PmsProductCategory> getList(Long parentId,Integer pageNum,Integer PageSize);
    PmsProductCategory getItem(Long id);
    int updateNavStatus(List<Long> ids, Integer navStatus);
    int updateShowStatus(List<Long> ids, Integer showStatus);
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

}
