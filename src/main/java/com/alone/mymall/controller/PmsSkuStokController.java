package com.alone.mymall.controller;

import com.alone.mymall.common.api.CommonResult;
import com.alone.mymall.mgb.model.PmsSkuStock;
import com.alone.mymall.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Constraint;
import java.util.List;

//sku库存controller
@Api(tags = "PmsSkuStockController",description = "SKU库存Contoller")
@Controller
@RequestMapping(value = "/sku")
public class PmsSkuStokController {
    @Autowired
    private PmsSkuStockService skuStockService;

    //根据商品编号及商品名称模糊搜索sku库存
    @ApiOperation("根据商品编号及商品名称模糊搜索SKU库存")
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword" ,required = false) String keyWord){
        List<PmsSkuStock> list= skuStockService.getList(pid,keyWord);
        return CommonResult.success(list);
    }

    @ApiOperation("更新SKU库存")
    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id,@RequestParam List<PmsSkuStock> skuStock){
        int count=skuStockService.update(id,skuStock);
        if (count==1){
            return CommonResult.success(id);
        }else{
            return CommonResult.failed();
        }
    }
}






