package com.yl.ms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 用户编码
     */
    @TableField(value = "user_code")
    private String userCode;

    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 登陆密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 移动电话
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 家庭地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 固定电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户状态
     */
    @TableField(value = "`status`")
    private String status;

    @TableField(value = "makeDate")
    private String makeDate;

    @TableField(value = "makeTime")
    private String makeTime;

    @TableField(value = "modifyDate")
    private String modifyDate;

    @TableField(value = "modifyTime")
    private String modifytime;

    @TableField(exist = false)
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public static final String COL_ID = "id";

    public static final String COL_USER_CODE = "user_code";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_PASSWORD = "password";

    public static final String COL_EMAIL = "email";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_ADDRESS = "address";

    public static final String COL_PHONE = "phone";

    public static final String COL_STATUS = "status";

    public static final String COL_MAKEDATE = "makeDate";

    public static final String COL_MAKETIME = "makeTime";

    public static final String COL_MODIFYDATE = "modifyDate";

    public static final String COL_MODIFYTIME = "modifyTime";
}
