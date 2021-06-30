package com.yl.ms.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yl.ms.dao.SysPermissionMapper;
import com.yl.ms.entity.SysPermission;
import com.yl.ms.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

}

