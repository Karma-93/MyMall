package com.alone.mymall.pojo;

import com.alone.mymall.validator.FlagValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class PmsProductAttributeParam {
    @NotEmpty(message = "商品属性不能为空")
    private Long productAttributeCategoryId;
    @NotEmpty(message = "商品名称不能为空")
    private String name;
    @FlagValidator({"0","1","2"})
    private Integer selectType;
    @FlagValidator({"0","1"})
    private Integer inputType;
    private String inputList;

    private Integer sort;
    @FlagValidator({"0","1"})
    private Integer filterType;
    @FlagValidator({"0","1","2"})
    private Integer searchType;
    @FlagValidator({"0","1"})
    private Integer relatedStatus;
    @FlagValidator({"0","1"})
    private Integer handAddStatus;
    @FlagValidator({"0","1"})
    private Integer type;
}
