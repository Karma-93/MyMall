package com.alone.mymall.mgb.model;

import java.io.Serializable;

public class PmsProductCategory implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.id
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.parent_id
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.name
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.level
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.product_count
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Integer productCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.product_unit
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private String productUnit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.nav_status
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Integer navStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.show_status
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Integer showStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.sort
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.icon
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.keywords
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private String keywords;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.description
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_product_category
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.id
     *
     * @return the value of pms_product_category.id
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.id
     *
     * @param id the value for pms_product_category.id
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.parent_id
     *
     * @return the value of pms_product_category.parent_id
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.parent_id
     *
     * @param parentId the value for pms_product_category.parent_id
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.name
     *
     * @return the value of pms_product_category.name
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.name
     *
     * @param name the value for pms_product_category.name
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.level
     *
     * @return the value of pms_product_category.level
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.level
     *
     * @param level the value for pms_product_category.level
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.product_count
     *
     * @return the value of pms_product_category.product_count
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.product_count
     *
     * @param productCount the value for pms_product_category.product_count
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.product_unit
     *
     * @return the value of pms_product_category.product_unit
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public String getProductUnit() {
        return productUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.product_unit
     *
     * @param productUnit the value for pms_product_category.product_unit
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.nav_status
     *
     * @return the value of pms_product_category.nav_status
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Integer getNavStatus() {
        return navStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.nav_status
     *
     * @param navStatus the value for pms_product_category.nav_status
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.show_status
     *
     * @return the value of pms_product_category.show_status
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.show_status
     *
     * @param showStatus the value for pms_product_category.show_status
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.sort
     *
     * @return the value of pms_product_category.sort
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.sort
     *
     * @param sort the value for pms_product_category.sort
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.icon
     *
     * @return the value of pms_product_category.icon
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.icon
     *
     * @param icon the value for pms_product_category.icon
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.keywords
     *
     * @return the value of pms_product_category.keywords
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.keywords
     *
     * @param keywords the value for pms_product_category.keywords
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.description
     *
     * @return the value of pms_product_category.description
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.description
     *
     * @param description the value for pms_product_category.description
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_product_category
     *
     * @mbggenerated Fri Nov 08 10:32:16 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", productCount=").append(productCount);
        sb.append(", productUnit=").append(productUnit);
        sb.append(", navStatus=").append(navStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", sort=").append(sort);
        sb.append(", icon=").append(icon);
        sb.append(", keywords=").append(keywords);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}