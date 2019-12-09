package com.alone.mymall.dao;

import java.util.List;

import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.mgb.model.UmsRolePermissionRelation;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 后台用户角色管理自定义dao
 */
@Mapper
public interface UmsRolePermissionRelationDao{
    /**
     * 批量插入角色和权限管理
     * @param list
     * @return
     */
    int insertList(@Param("list")List<UmsRolePermissionRelation> list);
    /**
     * 根据角色获取权限
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("roleId")Long roleId);
}