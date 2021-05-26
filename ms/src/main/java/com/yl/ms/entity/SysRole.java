package com.yl.ms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by yl on 2021/3/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
