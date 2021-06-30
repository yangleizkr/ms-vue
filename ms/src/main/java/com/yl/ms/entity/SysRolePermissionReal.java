package com.yl.ms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role_permission_real")
public class SysRolePermissionReal {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "role_code")
    private String roleCode;

    @TableField(value = "permission_id")
    private String permissionId;

    public static final String COL_ID = "id";

    public static final String COL_ROLE_CODE = "role_code";

    public static final String COL_PERMISSION_ID = "permission_id";
}