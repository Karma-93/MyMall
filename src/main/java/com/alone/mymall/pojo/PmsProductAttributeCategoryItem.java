package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.PmsProductAttribute;
import lombok.Data;

import java.util.List;

@Data
public class PmsProductAttributeCategoryItem {
    private List<PmsProductAttribute> productAttributeList;
}
