package com.alone.mymall.controller;


import com.alone.mymall.common.api.CommonPage;
import com.alone.mymall.common.api.CommonResult;

import com.alone.mymall.mgb.model.PmsBrand;
import com.alone.mymall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * 商品品牌管理
 */
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService service;

    private static final Logger logger= LoggerFactory.getLogger(PmsBrandController.class);


    /**
     *获取所有的品牌列表
     * @return
     */
    @ApiOperation(value = "获取所有的品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(service.listAllBrand());
    }


    /**
     * 创建品牌
     * @param pmsBrand
     * @return
     */
    @ApiOperation(value = "创建品牌")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count=service.createBrand(pmsBrand);
        if(count==1){
            commonResult=CommonResult.success(pmsBrand);
            logger.debug("createBrand success:{}",pmsBrand);
        }else{
            commonResult=CommonResult.failed("操作失败");
            logger.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }


    /**
     * 更新品牌
     * @param id
     * @param pmsBrandDto
     * @param result
     * @return
     */
    @ApiOperation(value = "更新品牌")
    @ResponseBody
    @RequestMapping(value ="/update/{id}",method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;

        int count=service.updateBrand(id,pmsBrandDto);
        if(count==1){
            commonResult=CommonResult.success(pmsBrandDto);
            logger.debug("updateBrand success:{}",pmsBrandDto);
        }else{
            commonResult=CommonResult.failed("操作失败");
            logger.debug("updateBrand failed:{}",pmsBrandDto);
        }
        return commonResult;
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete/{id}")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count=service.deleteBrand(id);
        if(count==1){
            logger.debug("deleteBrand success:id={}",id);
            commonResult=CommonResult.success(null);

        }else
        {
            logger.debug("deleteBrand faield :id={}",id);
            commonResult=CommonResult.failed("操作失败");
        }
        return commonResult;
    }


    /**
     * 根据品牌名称分页查询品牌列表
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "根据品牌名称分页查询品牌列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult listBrand(@RequestParam String keyword,@RequestParam int pageNum,@RequestParam int pageSize){

        List<PmsBrand> list= service.listBrand(keyword,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(list));

    }


    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询品牌类表")
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult brand(@PathVariable Long id)
    {
        return CommonResult.success(service.getBrand(id));

    }
    /**
     * 批量删除品牌
     *
     */
    @ApiOperation(value = "批量删除品牌")
    @ResponseBody
    @RequestMapping(value = "/delete/batch",method = RequestMethod.GET)
    public CommonResult deleteBatch(@RequestParam List<Long> ids){
        CommonResult commonResult;
        int count=service.deleteBrand(ids);
        if(count==1){

            commonResult=CommonResult.success(null);

        }else
        {

            commonResult=CommonResult.failed("操作失败");
        }
        return commonResult;
    }
    /**
     * 批量更新显示状态
     */
    @ApiOperation("批量更新显示状态")
    @ResponseBody
    @RequestMapping(value = "/updata/showStatus")
    public CommonResult updateShowStatus(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("showStatus") Integer showStatus) {
        int count = service.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    /**
     * 批量更新厂家制造状态
     */
    @ApiOperation(value = "批量跟新厂家制造状态")
    @ResponseBody
    @RequestMapping("/update/factorystatus")
    public CommonResult updateFactoryStatus(@RequestParam("ids")List<Long> ids,@RequestParam("factorystatus") Integer factoryStatus){
        int count = service.updateFactoryStatus(ids, factoryStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


}
