package com.alone.mymall.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class PmsProductCategoryParam {
    //父分类的编号
    private Long parentId;
    //商品分类名称
    @NotEmpty(message = "商品分类名称不能为空")
    private String name;
    //分类单位
    private String productUnit;
    //是否在导航栏显示
    private Integer navStatus;
    //是否进行显示
    private Integer showStatus;
    //排序
    private Integer sort;
    //图标
    private String icon;
    //关键字
    private String keywords;
    //描述
    private String description;
    //产品相关筛选属性集合
    private List<Long> productAttributeIdList;
}
