package com.yl.ms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by yl on 2021/3/17
 * @author yl
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<SysRole> roles;

}
