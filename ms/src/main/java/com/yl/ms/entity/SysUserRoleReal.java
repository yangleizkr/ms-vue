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
@TableName(value = "sys_user_role_real")
public class SysUserRoleReal {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "user_code")
    private String userCode;

    @TableField(value = "role_code")
    private String roleCode;

    public static final String COL_ID = "id";

    public static final String COL_USER_CODE = "user_code";

    public static final String COL_ROLE_CODE = "role_code";
}