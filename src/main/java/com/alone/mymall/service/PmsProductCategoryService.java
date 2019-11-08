package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductCategoryService {
    List<PmsProductCategory> listAllProductCategory();
    int createProductCategory(PmsProductCategory pmsProductCategory);
    int updateProductCategory(Long id,PmsProductCategory pmsProductCategory);
    int deleteProductCategory(Long id);
    int deleteProductCategory(List<Long> ids);
    List<PmsProductCategory> getList(Long parentId,Integer pageNum,Integer PageSize);
    PmsProductCategory getItem(Long id);
    int updateNavStatus(List<Long> ids, Integer navStatus);
    int updateShowStatus(List<Long> ids, Integer showStatus);
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

}
