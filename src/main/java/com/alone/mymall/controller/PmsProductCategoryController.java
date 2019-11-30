package com.alone.mymall.controller;

import com.alone.mymall.common.api.CommonPage;
import com.alone.mymall.common.api.CommonResult;
import com.alone.mymall.mgb.model.PmsProductCategory;
import com.alone.mymall.pojo.PmsProductCategoryParam;
import com.alone.mymall.pojo.PmsProductCategoryWithChildrenItem;
import com.alone.mymall.service.PmsProductCategoryService;
import com.alone.mymall.service.impl.PmsProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * 商品分类管理
 */
@Api(value = "商品分类管理" ,description = "商品分类管理")
@Controller
@RequestMapping("/productCatetory")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService productCategoryService;


    /**
     * 添加商品分类
     * @param pmsProductCategoryParam
     * @return
     */
    @ApiOperation("添加商品分类")
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

    /**
     * 更新商品分类信息
     * @param pmsProductCategoryParam
     * @param id
     * @return
     */
    @ApiOperation("更新商品分类信息")
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


    /**
     * 查询单个分类
     * @param id
     * @return
     */
    @ApiOperation("查询单个分类")
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult productCategory(@PathVariable Long id){
        return CommonResult.success(productCategoryService.getItem(id));
    }

    @ApiOperation("分页查询商品分类")
    @ResponseBody
    @RequestMapping(value = "/list/{parentId}")
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<PmsProductCategory> list=productCategoryService.getList(parentId,pageNum,pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    /**
     * 删除单个商品分类
     * @param id
     * @return
     */
    @ApiOperation("删除单个商品分类")
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public CommonResult delete(@PathVariable Long id){
        int count=productCategoryService.deleteProductCategory(id);
        if(count==1){
            return CommonResult.success(id);
        }else{
            return CommonResult.failed();
        }
    }


    /**
     * 批量删除商品分类
     * @return
     */
    @ApiOperation("批量删除商品分类")
    @ResponseBody
    @RequestMapping(value = "/delete/batch" ,method = RequestMethod.GET)
    public CommonResult deleteBatch(@RequestParam List<Long> ids){
        int count= productCategoryService.deleteProductCategory(ids);
        if (count==1){
            return CommonResult.success(null);
        }else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("修改导航栏显示状态")
    @ResponseBody
    @RequestMapping(value = "/update/navstatus",method = RequestMethod.POST)
    public CommonResult updateNavStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("navStatus") Integer navStatus){
        int count=productCategoryService.updateNavStatus(ids,navStatus);
        if(count==1){
            return CommonResult.success(null);
        }else {
            return CommonResult.failed("更新失败");
        }

    }


    @ApiOperation("更新商品分类显示状态")
    @ResponseBody
    @RequestMapping(value = "/update/showstatus",method = RequestMethod.POST)
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("showStatus") Integer showStatus){
        int count=productCategoryService.updateShowStatus(ids,showStatus);
        if(count==1){
            return CommonResult.success(null);
        }else {
            return CommonResult.failed("更新失败");
        }
    }

    /**
     * 查询所有一级子类及分类
     * @return
     */
    @ApiOperation("查询所有一级子类分类")
    @ResponseBody
    @RequestMapping("/list/withChildren")
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
