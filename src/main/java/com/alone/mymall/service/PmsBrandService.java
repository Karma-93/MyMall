package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand brand);
    int updateBrand(Long id,PmsBrand brand);
    int deleteBrand(Long id);
    int deleteBrand(List<Long> id);
    int updateShowStatus(List<Long> id,Integer showStatus);
    int updateFactoryStatus(List<Long> id,Integer factoryStatus);
    List<PmsBrand> listBrand(String keyword,int pageNum,int pageSize);
    PmsBrand getBrand(Long id);

}
