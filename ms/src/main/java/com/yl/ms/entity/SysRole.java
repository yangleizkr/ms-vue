package com.yl.ms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role")
public class SysRole {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "role_code")
    private String roleCode;

    @TableField(value = "role_name")
    private String roleName;

    @TableField(exist = false)
    private List<SysMenu> sysMenuList;

    @TableField(exist = false)
    private List<SysPermission> sysPermissionList;

    public List<SysMenu> getSysMenuList() {
        return sysMenuList;
    }

    public void setSysMenuList(List<SysMenu> sysMenuList) {
        this.sysMenuList = sysMenuList;
    }

    public List<SysPermission> getSysPermissionList() {
        return sysPermissionList;
    }

    public void setSysPermissionList(List<SysPermission> sysPermissionList) {
        this.sysPermissionList = sysPermissionList;
    }

    public static final String COL_ID = "id";

    public static final String COL_ROLE_CODE = "role_code";

    public static final String COL_ROLE_NAME = "role_name";
}
