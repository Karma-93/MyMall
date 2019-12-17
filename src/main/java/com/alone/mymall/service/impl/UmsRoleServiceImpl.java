package com.alone.mymall.service.impl;

import com.alone.mymall.dao.UmsRolePermissionRelationDao;
import com.alone.mymall.mgb.mapper.UmsRoleMapper;
import com.alone.mymall.mgb.mapper.UmsRolePermissionRelationMapper;
import com.alone.mymall.mgb.model.*;
import com.alone.mymall.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UmsRoleServiceImpl  implements UmsRoleService {

    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private UmsRolePermissionRelationDao rolePermissionRelationDao;

    @Override
    public int create(UmsRole role) {
        role.setCreateTime(new Date());
        role.setStatus(1);
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        UmsRoleExample roleExample=new UmsRoleExample();
        roleExample.createCriteria().andIdIn(ids);
        return roleMapper.deleteByExample(roleExample);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long role) {
        return rolePermissionRelationDao.getPermissionList(role);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        UmsRolePermissionRelationExample rolePermissionRelationExample=new UmsRolePermissionRelationExample();
        rolePermissionRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(rolePermissionRelationExample);
        //批量插入新关系
        List<UmsRolePermissionRelation> relationList=new ArrayList<UmsRolePermissionRelation>();
        for (Long permissionId:permissionIds){
            UmsRolePermissionRelation relation=new UmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return rolePermissionRelationDao.insertList(relationList);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }
}

