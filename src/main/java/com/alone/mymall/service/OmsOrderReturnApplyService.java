package com.alone.mymall.service;



import com.alone.mymall.mgb.model.OmsOrderReturnApply;
import com.alone.mymall.pojo.OmsOrderReturnApplyResult;
import com.alone.mymall.pojo.OmsReturnApplyQueryParam;
import com.alone.mymall.pojo.OmsUpdateStatusParam;

import java.util.List;

/**
 * 退货申请管理Service
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
