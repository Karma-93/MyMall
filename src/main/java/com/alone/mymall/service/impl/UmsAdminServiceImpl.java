package com.alone.mymall.service.impl;

import java.util.Date;
import java.util.List;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.date.DateTime;
import com.alone.mymall.common.utils.JwtTokenUtil;
import com.alone.mymall.mgb.mapper.UmsAdminLoginLogMapper;
import com.alone.mymall.mgb.mapper.UmsAdminMapper;
import com.alone.mymall.mgb.model.*;
import com.alone.mymall.pojo.UmsAdminLoginParam;
import com.alone.mymall.pojo.UmsAdminParam;
import com.alone.mymall.pojo.UpdateAdminPasswordParam;
import com.alone.mymall.service.UmsAdminService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.builders.RequestHandlerSelectors;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminLoginLogMapper adminLoginLogMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

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
        //查询时候有相同用户名的用户
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> list= adminMapper.selectByExample(umsAdminExample);
        if(list.size()>0){
            return null;
        }
        //将密码加密
        String encodePassword=passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String longin(String username, String password) {
        String toKen=null;
        //密码需要客户端加密后传递
        try{
            UserDetails userDetails=userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            toKen=jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);

        }catch(Exception e){

        }
        return toKen;
    }

    /**
     * 添加登录记录
     * @param username
     */
    private void insertLoginLog(String username){
        UmsAdmin admin=getAdminByUsername(username);
        UmsAdminLoginLog loginLog=new UmsAdminLoginLog();
        loginLog.setId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        loginLog.setIp( request.getRemoteAddr());
        adminLoginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     * @param username
     */
    private void updateLoginTimeByUsername(String username){
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
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