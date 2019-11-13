package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.PmsProductCategory;
import lombok.Data;

import java.util.List;


public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    private List<PmsProductCategory> children;
    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }

}
