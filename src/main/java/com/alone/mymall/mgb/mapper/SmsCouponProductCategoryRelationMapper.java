package com.alone.mymall.mgb.mapper;

import com.alone.mymall.mgb.model.SmsCouponProductCategoryRelation;
import com.alone.mymall.mgb.model.SmsCouponProductCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsCouponProductCategoryRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int countByExample(SmsCouponProductCategoryRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int deleteByExample(SmsCouponProductCategoryRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int insert(SmsCouponProductCategoryRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int insertSelective(SmsCouponProductCategoryRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    List<SmsCouponProductCategoryRelation> selectByExample(SmsCouponProductCategoryRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    SmsCouponProductCategoryRelation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") SmsCouponProductCategoryRelation record, @Param("example") SmsCouponProductCategoryRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int updateByExample(@Param("record") SmsCouponProductCategoryRelation record, @Param("example") SmsCouponProductCategoryRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int updateByPrimaryKeySelective(SmsCouponProductCategoryRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    int updateByPrimaryKey(SmsCouponProductCategoryRelation record);
}