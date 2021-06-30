package com.yl.ms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.ms.entity.SysUser;

/**
 * @author yl
 */
public interface SysUserService extends IService<SysUser> {


    SysUser login(SysUser sysUser);

    IPage<SysUser> listUsers(SysUser sysUser, Integer pageNum, Integer pageSize);
//    User getUserByName(String getMapByName);
}



