package com.alone.mymall.pojo;

import lombok.Data;



import com.alone.mymall.validator.FlagValidator;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
public class PmsProductCategoryParam {
    @ApiModelProperty("父分类的编号")
    private Long parentId;
    @ApiModelProperty("商品分类名称")
    @NotEmpty(message = "商品分类名称不能为空")
    private String name;
    @ApiModelProperty("分类单位")
    private String productUnit;
    @ApiModelProperty("是否在导航栏显示")
    @FlagValidator(value = {"0","1"},message = "状态只能为0,1")
    private Integer navStatus;
    @ApiModelProperty("是否进行显示")
    @FlagValidator(value = {"1","0"},message = "状态只能为0,1")
    private Integer showStatus;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("关键字")
    private String keywords;
    @ApiModelProperty("描述")
    private String description; 
    @ApiModelProperty("产品相关筛选属性集合")
    private List<Long> productAttributeIdList;
}
