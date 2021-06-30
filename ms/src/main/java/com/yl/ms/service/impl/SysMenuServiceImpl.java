package com.yl.ms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.ms.dao.SysMenuMapper;
import com.yl.ms.entity.SysMenu;
import com.yl.ms.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yl
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findAllByUserCode(String userCode) {
        //获取根菜单
        List<SysMenu> menus = sysMenuMapper.selectAllByUserCode(userCode);
        List<SysMenu> children = findChildren(menus,userCode);
        //根据根菜单获取子菜单

        return children;
    }

    @Override
    public List<SysMenu> findChildren(List<SysMenu> children,String userCode) {
        for (SysMenu sysMenu : children) {
            List<SysMenu> menus = sysMenuMapper.selectChildren(sysMenu.getMenuCode(),userCode);
            sysMenu.setChildren(menus);
        }
        return children;
    }


}




