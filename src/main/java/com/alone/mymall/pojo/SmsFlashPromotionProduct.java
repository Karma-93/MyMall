package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.SmsFlashPromotionProductRelation;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.SupportedAnnotationTypes;

@Getter
@Setter
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    private PmsProduct product;
}
