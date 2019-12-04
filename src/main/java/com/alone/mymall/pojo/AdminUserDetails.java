package com.alone.mymall.pojo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.alone.mymall.mgb.model.UmsAdmin;
import com.alone.mymall.mgb.model.UmsPermission;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * springSucrity需要的用户信息
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;

    public AdminUserDetails(UmsAdmin umsAdmin,List<UmsPermission> permissions){
        this.umsAdmin=umsAdmin;
        this.permissionList=permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
         return permissionList.stream()
                        .filter(permission -> permission.getValue()!=null)
                        .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                       .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return umsAdmin.getStatus().equals(1);
    }

}