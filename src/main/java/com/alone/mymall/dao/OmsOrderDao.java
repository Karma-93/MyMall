package com.alone.mymall.dao;


import com.alone.mymall.mgb.model.OmsOrder;
import com.alone.mymall.pojo.OmsOrderDeliveryParam;
import com.alone.mymall.pojo.OmsOrderDetail;
import com.alone.mymall.pojo.OmsOrderQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 */
@Mapper
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
