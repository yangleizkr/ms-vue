package com.yl.ms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.ms.entity.SysUser;

/**
 * @author yl
 */
public interface SysUserService extends IService<SysUser> {


    boolean login(SysUser sysUser);

//    User getUserByName(String getMapByName);
}

