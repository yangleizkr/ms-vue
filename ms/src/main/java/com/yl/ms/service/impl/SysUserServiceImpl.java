package com.yl.ms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.ms.dao.SysUserMapper;
import com.yl.ms.entity.SysUser;
import com.yl.ms.service.SysUserService;
import com.yl.ms.utils.PasswordUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author yl
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public void test(){
        stringRedisTemplate.opsForValue().set("123","测试");
        stringRedisTemplate.expire("123",1000, TimeUnit.SECONDS);
    }

    /**
     * 1、判断传入用户是否为空
     * 2、根据用户编码查询，判断用户是否存在
     * 3、判断传入密码与加密后的密码是否一致
     */
    @Override
    public SysUser login(SysUser sysUser) {
        if(Objects.isNull(sysUser)){
            System.out.println("传入用户为空");
            return null;
        }

        stringRedisTemplate.opsForValue().set("123","测试");
        stringRedisTemplate.expire("123",1000, TimeUnit.SECONDS);

        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("user_code",sysUser.getUserCode());
        SysUser findedUser = sysUserMapper.selectOne(sysUserQueryWrapper);
        if(Objects.isNull(findedUser)){
            System.out.println("该用户不存在!");
            return null;
        }
        if (Objects.equals(findedUser.getPassword(), PasswordUtils.digestPassword(sysUser.getPassword()))){
            System.out.println("密码匹配成功");
            return findedUser;
        }


        return null;
    }

    @Override
    public IPage<SysUser> listUsers(String userCode, String userName, Integer pageNum, Integer pageSize) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

        if(!"".equals(userCode)){
            queryWrapper.eq("user_code",userCode);
        }
        if (!"".equals(userName)){
            queryWrapper.like("user_name",userName);
        }

        Page<SysUser> page = new Page(pageNum,pageSize);
        IPage<SysUser> iPage = sysUserMapper.selectPage(page,queryWrapper);
        return iPage;
    }

}

