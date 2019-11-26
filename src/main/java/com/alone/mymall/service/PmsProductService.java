package com.alone.mymall.service;

import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.pojo.PmsProductParam;
import com.alone.mymall.pojo.PmsProductQueryParam;
import com.alone.mymall.pojo.PmsProductResult;

import java.util.List;

/**
 * 商品管理Service
 */
public interface PmsProductService {
    /**
     * 创建商品
     * @param pmsProductParam
     * @return
     */
    int create(PmsProductParam pmsProductParam);

    /**
     * 根据id获取商品更新信息
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品信息
     * @param id
     * @param pmsProductParam
     * @return
     */
    int update(Long id,PmsProductParam pmsProductParam);

    /**
     * 分页查询商品
     * @param pmsProductQueryParam
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam,Integer pageNum,Integer pageSize);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     * @return
     */
    int updateVerifyStatus(List<Long>ids,Integer verifyStatus,String detail);

    /**
     * 批量修改上架状态
     * @param ids
     * @param publishStatus
     * @return
     */
    int updatePublishStatus(List<Long>ids,Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     * @return
     */
    int updateRecommendStatus(List<Long> ids,Integer recommend);

    /**
     * 批量修改新品状态
     * @return
     */
    int upddateNewStatus(List<Long> ids,Integer newstatus);

    /**
     * 批量删除商品
     * @return
     */
    int updateDeleteStatus(List<Long> ids,Integer deletestatus);

    /**
     * 根据商品名称或货号模糊查询
     * @param keyword
     * @return
     */
    List<PmsProduct> list(String keyword);
}
