package com.alone.mymall.mgb.mapper;

import com.alone.mymall.mgb.model.SmsFlashPromotionProductRelation;
import com.alone.mymall.mgb.model.SmsFlashPromotionProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFlashPromotionProductRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int countByExample(SmsFlashPromotionProductRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int deleteByExample(SmsFlashPromotionProductRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int insert(SmsFlashPromotionProductRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int insertSelective(SmsFlashPromotionProductRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    List<SmsFlashPromotionProductRelation> selectByExample(SmsFlashPromotionProductRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    SmsFlashPromotionProductRelation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") SmsFlashPromotionProductRelation record, @Param("example") SmsFlashPromotionProductRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int updateByExample(@Param("record") SmsFlashPromotionProductRelation record, @Param("example") SmsFlashPromotionProductRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int updateByPrimaryKeySelective(SmsFlashPromotionProductRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_product_relation
     *
     * @mbggenerated Sun Dec 15 20:46:17 CST 2019
     */
    int updateByPrimaryKey(SmsFlashPromotionProductRelation record);
}