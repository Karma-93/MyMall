package com.alone.mymall.mgb.model;

import java.io.Serializable;

public class SmsCouponProductCategoryRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_coupon_product_category_relation.id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_coupon_product_category_relation.coupon_id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    private Long couponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_coupon_product_category_relation.product_category_id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    private Long productCategoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_coupon_product_category_relation.product_category_name
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    private String productCategoryName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_coupon_product_category_relation.parent_category_name
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    private String parentCategoryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_coupon_product_category_relation.id
     *
     * @return the value of sms_coupon_product_category_relation.id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_coupon_product_category_relation.id
     *
     * @param id the value for sms_coupon_product_category_relation.id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_coupon_product_category_relation.coupon_id
     *
     * @return the value of sms_coupon_product_category_relation.coupon_id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_coupon_product_category_relation.coupon_id
     *
     * @param couponId the value for sms_coupon_product_category_relation.coupon_id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_coupon_product_category_relation.product_category_id
     *
     * @return the value of sms_coupon_product_category_relation.product_category_id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_coupon_product_category_relation.product_category_id
     *
     * @param productCategoryId the value for sms_coupon_product_category_relation.product_category_id
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_coupon_product_category_relation.product_category_name
     *
     * @return the value of sms_coupon_product_category_relation.product_category_name
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_coupon_product_category_relation.product_category_name
     *
     * @param productCategoryName the value for sms_coupon_product_category_relation.product_category_name
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_coupon_product_category_relation.parent_category_name
     *
     * @return the value of sms_coupon_product_category_relation.parent_category_name
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public String getParentCategoryName() {
        return parentCategoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_coupon_product_category_relation.parent_category_name
     *
     * @param parentCategoryName the value for sms_coupon_product_category_relation.parent_category_name
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_coupon_product_category_relation
     *
     * @mbggenerated Mon Dec 16 10:47:53 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", couponId=").append(couponId);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", productCategoryName=").append(productCategoryName);
        sb.append(", parentCategoryName=").append(parentCategoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}