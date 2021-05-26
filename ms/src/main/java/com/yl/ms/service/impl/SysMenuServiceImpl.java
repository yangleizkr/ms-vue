package com.yl.ms.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.ms.entity.SysMenu;
import com.yl.ms.dao.SysMenuMapper;
import com.yl.ms.service.SysMenuService;

import javax.annotation.Resource;

/**
 * @author yl
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findAllByMenuCode(String menuCode) {
        System.out.println(menuCode);
        return sysMenuMapper.selectAllByMenuCode(menuCode);
    }
}
