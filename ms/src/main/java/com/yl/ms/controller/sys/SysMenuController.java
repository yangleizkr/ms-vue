package com.yl.ms.controller.sys;

import com.yl.ms.entity.SysMenu;
import com.yl.ms.service.SysMenuService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yl
 */
@RequestMapping("sysMenu")
@EnableAspectJAutoProxy
@Controller
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    @PostMapping("/addSysMenu")
    @ResponseBody
    public Map<String,Object> insertSysMenu(SysMenu sysMenu){
        HashMap<String,Object> map = new HashMap<>(3);
        boolean result = sysMenuService.save(sysMenu);
        map.put("flag",result);
        map.put("mes","菜单新增成功");
        return map;
    }

    @GetMapping("/listSysMenu")
    @ResponseBody
    public Map<String,Object> listSysMenu(){
        HashMap<String,Object> map = new HashMap<>(3);
        List<SysMenu> list = sysMenuService.list();
        list.stream().forEach((sysMenu -> System.out.println(sysMenu)));
        map.put("flag",true);
        map.put("result",list);

        return map;
    }

}
