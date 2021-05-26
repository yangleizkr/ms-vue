package com.yl.ms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.ms.dao.SysUserMapper;
import com.yl.ms.entity.SysUser;
import com.yl.ms.service.SysUserService;
import com.yl.ms.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author yl
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 1、判断传入用户是否为空
     * 2、根据用户编码查询，判断用户是否存在
     * 3、判断传入密码与加密后的密码是否一致
     */
    @Override
    public boolean login(SysUser sysUser) {
        if(Objects.isNull(sysUser)){
            System.out.println("传入用户为空");
            return false;
        }
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("user_code",sysUser.getUserCode());
        SysUser findedUser = sysUserMapper.selectOne(sysUserQueryWrapper);
        if(Objects.isNull(findedUser)){
            System.out.println("该用户不存在!");
            return false;
        }
        if (Objects.equals(findedUser.getPassword(), PasswordUtils.digestPassword(sysUser.getPassword()))){
            System.out.println("密码匹配成功");
            return true;
        }

        return false;
    }

}

