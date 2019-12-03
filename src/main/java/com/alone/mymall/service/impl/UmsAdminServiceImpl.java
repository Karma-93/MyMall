package com.alone.mymall.service.impl;

import java.util.Date;
import java.util.List;

import com.alone.mymall.common.utils.JwtTokenUtil;
import com.alone.mymall.mgb.mapper.UmsAdminMapper;
import com.alone.mymall.mgb.model.UmsAdmin;
import com.alone.mymall.mgb.model.UmsAdminExample;
import com.alone.mymall.mgb.model.UmsPermission;
import com.alone.mymall.mgb.model.UmsRole;
import com.alone.mymall.pojo.UmsAdminParam;
import com.alone.mymall.pojo.UpdateAdminPasswordParam;
import com.alone.mymall.service.UmsAdminService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        // TODO Auto-generated method stub
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> list= adminMapper.selectByExample(umsAdminExample);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam adminParam) {
        UmsAdmin umsAdmin=new UmsAdmin();
        BeanUtils.copyProperties(adminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> list= adminMapper.selectByExample(umsAdminExample);
        if(list.size()>0){
            return null;
        }
        String encodePassword=passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String longin(String username, String password) {
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> list=adminMapper.selectByExample(umsAdminExample);
        if(list==null  ||list.size()==0){
            return null;
        }
        UmsAdmin umsAdmin=list.get(0);
        umsAdmin.getPassword();

        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UmsAdmin getItem(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UmsAdmin> list(String name, Integer pageNum, Integer pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam updatePasswordParam) {
        // TODO Auto-generated method stub
        return 0;
    }

}