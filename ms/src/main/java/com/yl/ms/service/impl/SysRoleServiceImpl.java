package com.yl.ms.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.ms.entity.SysRole;
import com.yl.ms.dao.SysRoleMapper;
import com.yl.ms.service.SysRoleService;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}

