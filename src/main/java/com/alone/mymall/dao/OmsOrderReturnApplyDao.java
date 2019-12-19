package com.alone.mymall.dao;


import com.alone.mymall.mgb.model.OmsOrderReturnApply;
import com.alone.mymall.pojo.OmsOrderReturnApplyResult;
import com.alone.mymall.pojo.OmsReturnApplyQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id") Long id);
}
