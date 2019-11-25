package com.alone.mymall.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PmsProductResult extends PmsProductParam {
    //商品所选分类的父ID
    private long cateParentId;
}
