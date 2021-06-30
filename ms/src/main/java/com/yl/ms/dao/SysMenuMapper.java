package com.yl.ms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yl.ms.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> selectAllByUserCode(@Param("userCode") String userCode);

    List<SysMenu> selectChildren(@Param("menuCode") String menuCode,@Param("userCode") String userCode);
}
