package com.alone.mymall.controller;

import com.alone.mymall.common.api.CommonPage;
import com.alone.mymall.common.api.CommonResult;
import com.alone.mymall.mgb.model.PmsProductAttribute;
import com.alone.mymall.mgb.model.PmsProductAttributeCategory;
import com.alone.mymall.pojo.PmsProductAttributeCategoryItem;
import com.alone.mymall.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {

    @Autowired
    private PmsProductAttributeCategoryService productAttributeCategoryService;

    //添加商品属性分类
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult create(@RequestParam String name){
        int count=productAttributeCategoryService.create(name);
        if (count==1){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }


    //修改商品属性分类
    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id, @RequestParam String name){
        int count=productAttributeCategoryService.update(id,name);
        if (count==1){
            return CommonResult.success(id);
        }else {
            return CommonResult.failed();
        }
    }

    //删除单个商品属性分类
    @ResponseBody
    @RequestMapping(value = "/delete/id",method =RequestMethod.GET)
    public CommonResult delete( @PathVariable Long id){
        int count=productAttributeCategoryService.delete(id);
        if(count==1){
            return CommonResult.success(id);
        }else {
            return CommonResult.failed();
        }
    }

    //获取单个商品属性分类
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult getItem(@PathVariable Long id){
        PmsProductAttributeCategory productAttributeCategory =productAttributeCategoryService.getItem(id);
        return CommonResult.success(productAttributeCategory);

    }

    //分页查询所有商品属性分类
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult getList(@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "1") Integer pageNum){
        List<PmsProductAttributeCategory> productAttributeCategoryList=productAttributeCategoryService.list(pageNum,pageSize);
        return CommonResult.success(new CommonPage<>().restPage(productAttributeCategoryList));
    }

    //获取所有商品属性分类及其下属属性
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductAttributeCategoryItem>> getListWithAttr() {
        List<PmsProductAttributeCategoryItem> productAttributeCategoryResultList = productAttributeCategoryService.getListWithAttr();
        return CommonResult.success(productAttributeCategoryResultList);
    }
}










