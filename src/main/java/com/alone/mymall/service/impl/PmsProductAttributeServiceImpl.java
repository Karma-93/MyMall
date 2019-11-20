package com.alone.mymall.service.impl;

import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.service.PmsProductAttributeService;

import java.util.List;

public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {
    @Override
    public int create(PmsProductAttribute pmsProductAttribute) {
        return 0;
    }

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<PmsProductAttribute> listAll(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public PmsProductAttribute getProductAttribute(Long id) {
        return null;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return 0;
    }

    @Override
    public int update(PmsProductAttribute pmsProductAttribute) {
        return 0;
    }
}
