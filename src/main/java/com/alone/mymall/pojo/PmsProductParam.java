package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 创建和修改商品时使用的参数
 */
@Setter
@Getter
public class PmsProductParam extends PmsProduct {
    //商品阶梯价格设置
    private List<PmsProductLadder> productLadderList;
    //商品满减价格设置
    private List<PmsProductFullReduction> productFullReductionList;
    //商品会员价格设置
    private List<PmsMemberPrice> memberPriceList;
    //商品sku库存信息
    private List<PmsSkuStock> skuStockList;
    //商品参数及自定义规格设置
    private List<PmsProductAttributeValue> productAttributeValueList;


}
