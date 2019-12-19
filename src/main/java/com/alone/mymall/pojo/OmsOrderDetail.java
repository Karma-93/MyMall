package com.alone.mymall.pojo;

import com.alone.mymall.mgb.model.OmsOrder;
import com.alone.mymall.mgb.model.OmsOrderItem;
import com.alone.mymall.mgb.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
