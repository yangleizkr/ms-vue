package com.yl.ms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 系统菜单表
 * @author yl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
public class SysMenu {
    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 菜单编码
     */
    @TableField(value = "menu_code")
    private String menuCode;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 菜单路径
     */
    @TableField(value = "menu_url")
    private String menuUrl;

    /**
     * 父菜单编码
     */
    @TableField(value = "parent_code")
    private String parentCode;

    /**
     * 前菜单编码
     */
    @TableField(value = "pre_code")
    private String preCode;

    /**
     * 后菜单编码
     */
    @TableField(value = "next_code")
    private String nextCode;

    public static final String COL_ID = "id";

    public static final String COL_MENU_CODE = "menu_code";

    public static final String COL_MENU_NAME = "menu_name";

    public static final String COL_MENU_URL = "menu_url";

    public static final String COL_PARENT_CODE = "parent_code";

    public static final String COL_PRE_CODE = "pre_code";

    public static final String COL_NEXT_CODE = "next_code";
}
