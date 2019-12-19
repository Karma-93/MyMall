package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.OmsCompanyAddress;
import com.alone.mymall.mgb.model.OmsOrderReturnApply;

import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
