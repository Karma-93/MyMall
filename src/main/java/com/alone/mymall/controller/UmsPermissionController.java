package com.alone.mymall.controller;

import com.alone.mymall.common.api.CommonResult;
import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.service.UmsPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags="UmsPermissionController", description="后台用户权限管理")
@RequestMapping("/permission")
public class UmsPermissionController{
	@Autowired
	private UmsPermissionService permissionService;

	@ResponseBody
	@ApiOperation("添加权限")
	@RequestMapping(value="/create",method= RequestMethod.POST)
	public CommonResult create(@RequestBody UmsPermission permission){
		int count=permissionService.create(permission);
		if (count>0){
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}

}
