package com.alone.mymall.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品查询参数
 */
@Getter
@Setter
public class PmsProductQueryParam {
    //上架状态
    private Integer publishStatus;
    //审核状态
    private Integer verifyStatus;
    //商品名称模糊关键字
    private String keyword;
    //商品货号
    private String productSn;
    //商品分类编号
    private Long productCategoryId;
    //商品品牌编号
    private Long brandId;
}
