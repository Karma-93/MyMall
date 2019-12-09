package com.alone.mymall.service;

import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.pojo.UmsPermissionNode;

import java.time.Period;
import java.util.List;

/**
 * 后台用户权限关系service
 */
public interface UmsPermissionService {
    /**
     * 添加权限
     * @param permission
     * @return
     */
    int create(UmsPermission permission);

    /**
     * 修改权限
     * @param id
     * @param permission
     * @return
     */
    int update(Long id,UmsPermission permission);

    /**
     * 批量删除权限
     * @param list
     * @return
     */
    int deleteBatch(List<Long> list);

    /**
     * 以层级结构返回所有权限
     * @return
     */
    List<UmsPermissionNode> treeList();

    /**
     * 获取所有权限
     * @return
     */
    List<UmsPermission> list();
}
