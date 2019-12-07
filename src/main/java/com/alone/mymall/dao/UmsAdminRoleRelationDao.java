package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.UmsAdminRoleRelation;
import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.mgb.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理Dao
 */
@Mapper
public interface UmsAdminRoleRelationDao {

    /**
     * 批量插入用户与角色关系
     * @param adminRoleRelationList
     * @return
     */
    int isnertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 用于获取所有用户与角色关系
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有角色权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getRolePermissionList(@Param("adminId") Long adminId);
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
