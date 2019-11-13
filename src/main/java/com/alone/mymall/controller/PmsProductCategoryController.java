package com.alone.mymall.controller;

import com.alone.mymall.common.api.CommonResult;
import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.pojo.PmsProductCategoryParam;
import com.alone.mymall.service.PmsProductCategoryService;
import com.alone.mymall.service.impl.PmsProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * 商品分类管理
 */
@Controller
@RequestMapping("/productCatetory")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService productCategoryService;

    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductCategoryParam pmsProductCategoryParam){
        int count=productCategoryService.createProductCategory(pmsProductCategoryParam);
        if(count==1){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ResponseBody
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public CommonResult update(@RequestBody PmsProductCategoryParam pmsProductCategoryParam,Long id){
        int count=productCategoryService.updateProductCategory(id,pmsProductCategoryParam);
        if (count == 1) {
            return CommonResult.success(count);
        }
        else {
            return CommonResult.failed();
        }
    }
}
