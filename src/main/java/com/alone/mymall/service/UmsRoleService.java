package com.alone.mymall.service;

import java.beans.Transient;
import java.util.List;

import javax.management.relation.Role;

import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.mgb.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

//后台角色管理Service
public interface UmsRoleService {
    /**
     *创建角色
     * @param role
     * @return
     */
    int create(UmsRole role);

    /**
     * 修改角色
     */
    int update(Long id,UmsRole role);

    /**
     *批量删除角色
     * @param ids
     * @return
     */
    int deleteBatch(List<Long> ids);

    /**
     * 获取指定角色权限
     * @return
     */
    List<UmsPermission> getPermissionList(Long role);

    /**
     * 修改指定角色的权限
     * @param roleId
     * @param permissionIds
     * @return
     */
    @Transactional
    int updatePermission(Long roleId,List<Long> permissionIds);

    /**
     * 获取角色列表
     * @return
     */
    List<UmsRole> list();

}
