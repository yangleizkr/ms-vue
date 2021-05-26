package com.yl.ms.service;

import com.yl.ms.dao.SysMenuMapper;
import com.yl.ms.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yl
 */
public interface SysMenuService extends IService<SysMenu>{

    List<SysMenu> findAllByMenuCode(String MenuCode);

}
