package com.yl.ms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yl.ms.entity.SysMenu;

import java.util.List;

/**
 * @author yl
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> findAllByUserCode(String userCode);

    List<SysMenu> findChildren(List<SysMenu> children,String userCode);
}





