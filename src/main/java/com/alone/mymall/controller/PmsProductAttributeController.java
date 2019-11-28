package com.alone.mymall.controller;

import com.alone.mymall.common.api.CommonPage;
import com.alone.mymall.common.api.CommonResult;
import com.alone.mymall.mgb.model.PmsProduct;
import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.pojo.PmsProductAttrInfo;
import com.alone.mymall.pojo.PmsProductAttributeParam;
import com.alone.mymall.service.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/productAttribute")
public class PmsProductAttributeController {
    @Autowired
    private PmsProductAttributeService productAttributeService;

    //根据分类查询属性列表或参数列表
    @ResponseBody
    @RequestMapping(value = "/list/{cid}",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid, @RequestParam Integer type,@RequestParam Integer PageNum,@RequestParam Integer PageSize){
        List<PmsProductAttribute> productAttributeList=productAttributeService.getList(cid,type,PageNum,PageSize);
        return CommonResult.success(CommonPage.restPage(productAttributeList));
    }

    //添加商品属性
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult create(@RequestParam PmsProductAttributeParam productAttributeParam,BindingResult bindingResult){
        int count= productAttributeService.create(productAttributeParam);
        if(count==1){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    //修改商品属性信息
    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id, @RequestParam PmsProductAttributeParam productAttributeParam, BindingResult bindingResult){
        int count=productAttributeService.update(id,productAttributeParam);
        if(count==1){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    //批量删除商品属性
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = productAttributeService.deleteBatch(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    //根据商品分类的id获取商品属性及属性分类
    @RequestMapping(value = "/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductAttrInfo>> getAttrInfo(@PathVariable Long productCategoryId) {
        List<PmsProductAttrInfo> productAttrInfoList = productAttributeService.getProductAttrInfo(productCategoryId);
        return CommonResult.success(productAttrInfoList);
    }
}
