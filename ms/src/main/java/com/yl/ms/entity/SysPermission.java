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
@TableName(value = "sys_permission")
public class SysPermission {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "permission_id")
    private String permissionId;

    /**
     * 按钮权限
     */
    @TableField(value = "permission_type")
    private String permissionType;

    @TableField(value = "permission_code")
    private String permissionCode;

    public static final String COL_ID = "id";

    public static final String COL_PERMISSION_ID = "permission_id";

    public static final String COL_PERMISSION_TYPE = "permission_type";

    public static final String COL_PERMISSION_CODE = "permission_code";
}