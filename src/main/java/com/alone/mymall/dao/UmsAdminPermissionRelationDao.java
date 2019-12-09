package com.alone.mymall.dao;

import com.alone.mymall.mgb.model.UmsAdminPermissionRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户权限自定义dao
 */
@Mapper
public interface UmsAdminPermissionRelationDao {

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insesrtList(@Param("list") List<UmsAdminPermissionRelation> list);
}
