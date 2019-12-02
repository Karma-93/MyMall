package com.alone.mymall.pojo;
import java.util.List;

import com.alone.mymall.mgb.model.UmsPermission;

import lombok.Getter;
import lombok.Setter;

public class UmsPermissionNode extends UmsPermission {
    @Getter
    @Setter
    private List<UmsPermissionNode> children;
}