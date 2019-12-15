package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.SmsCoupon;
import com.alone.mymall.mgb.model.SmsCouponProductCategoryRelation;
import com.alone.mymall.mgb.model.SmsCouponProductRelation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 */
@Getter
@Setter
public class SmsCouponParam extends SmsCoupon{
    //优惠券绑定的商品
    private List<SmsCouponProductRelation> productRelationList;
    //优惠券绑定的商品分类
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;


}
