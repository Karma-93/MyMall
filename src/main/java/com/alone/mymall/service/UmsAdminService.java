package com.alone.mymall.service;

import java.util.List;

import com.alone.mymall.mgb.model.UmsAdmin;
import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.mgb.model.UmsRole;
import com.alone.mymall.pojo.UmsAdminParam;
import com.alone.mymall.pojo.UpdateAdminPasswordParam;

import org.springframework.transaction.annotation.Transactional;
/**
 * 后台管理service
 */
public interface UmsAdminService{

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username); 

    /**
     * 注册后台管理账户
     * @param adminParam
     * @return
     */
    UmsAdmin register(UmsAdminParam adminParam);

    /**
     * 登录
     * @return 生成的JWT的token
     */
    String longin(String username,String password);

    /**
     * 刷新token的功能
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);

    /**
     * 根据Id获取用户
     * @return
     */
    UmsAdmin getItem(Long id);

    /**
     * 根据用户名昵称分页查询用户列表
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsAdmin> list(String name,Integer pageNum,Integer pageSize);

    /**
     * 修改制定的用户信息
     */
    int update(Long id,UmsAdmin admin);

    /**
     * 删除指定用户
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     * @param adminId
     * @param roleIds
     * @return
     */
    @Transactional
    int updateRole(Long adminId,List<Long> roleIds);

    /**
     * 获取用户对于角色
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 修改用户的+-权限
     * @param adminId
     * @param permissionIds
     * @return
     */
    int updatePermission(Long adminId,List<Long> permissionIds);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);
}