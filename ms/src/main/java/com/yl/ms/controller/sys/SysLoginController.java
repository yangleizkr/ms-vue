package com.yl.ms.controller.sys;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yl.ms.entity.SysMenu;
import com.yl.ms.entity.SysUser;
import com.yl.ms.service.SysMenuService;
import com.yl.ms.service.SysUserService;
import com.yl.ms.utils.PasswordUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 * @author yl
 */

@RequestMapping("/sys_user")
@Controller
public class SysLoginController extends BaseController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuService sysMenuService;


    /**
     * optimize
     *
     * @param sysUser 用户
     * @return 返回Json对象
     */
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String, Object> loginSystem(@RequestBody SysUser sysUser) {
        HashMap<String, Object> map = new HashMap<>(4);
        SysUser fundedSysUser = sysUserService.login(sysUser);
        if (!Objects.isNull(fundedSysUser)) {
            map.put("flag", true);
            map.put("mes", "登陆成功");
            StpUtil.setLoginId(sysUser.getUserCode());
            map.put("sysUser", fundedSysUser);
            return map;
        }
        map.put("flag", false);
        map.put("mes", "账号或密码不正确,请重新输入");
        return map;
    }

    @GetMapping("/list")
    @ResponseBody
    public HashMap<String, Object> listsSysUser(SysUser sysUser, @RequestParam(required = false, value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize) {

        HashMap<String, Object> map = new HashMap<>(4);

        IPage<SysUser> iPage = sysUserService.listUsers(sysUser, pageNum, pageSize);
        map.put("iPage", iPage);
        return map;
    }

    @GetMapping("/checkUserCode")
    @ResponseBody
    public HashMap<String, Object> checkUserCode(@RequestParam(value = "userCode") String userCode) {
        HashMap<String, Object> map = new HashMap<>(4);

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (!"".equals(userCode)) {
            queryWrapper.eq("user_code", userCode);
        }

        List<SysUser> list = sysUserService.list(queryWrapper);
        if (list.size() > 0) {
            map.put("flag", false);
            map.put("mes", "用户名已存在");
            return map;
        }
        map.put("flag", true);
        return map;

    }

    @PostMapping("/addUser")
    @ResponseBody
    public HashMap<String, Object> addSysUser(@RequestBody @Valid SysUser sysUser, BindingResult result) {
        HashMap<String, Object> map = new HashMap<>(4);
        if (result.hasErrors()) {
            return checkObject(map, result);
        }
        HashMap<String, Object> map1 = this.checkUserCode(sysUser.getUserCode());
        if ((Boolean) map1.get("flag") == false){
            return map1;
        }
        sysUser.setStatus("1");
        sysUser.setPassword(PasswordUtils.digestPassword(sysUser.getPassword()));
        boolean flag = sysUserService.save(sysUser);
        map.put("flag", flag);
        map.put("mes", "添加成功");
        return map;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public HashMap<String, Object> deleteSysUser(@PathVariable Integer id) {
        HashMap<String, Object> map = new HashMap<>(4);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        SysUser one = sysUserService.getOne(queryWrapper);
        if (Objects.isNull(one)) {
            map.put("flag", false);
            map.put("mes", "未查询到该用户");

        } else {
            sysUserService.remove(queryWrapper);
            map.put("flag", true);
            map.put("mes", "删除成功");
        }

        return map;
    }

    @PutMapping("/modifyUser")
    @ResponseBody
    public HashMap<String, Object> modifySysUser(@RequestBody @Valid SysUser sysUser, BindingResult result) {
        HashMap<String, Object> map = new HashMap<>(4);
        if (result.hasErrors()) {
            return checkObject(map, result);
        }
        boolean flag = sysUserService.updateById(sysUser);
        map.put("flag", flag);
        return map;
    }
    @GetMapping("/getRouters")
    @ResponseBody
    public HashMap<String,Object> getMenus(){
        HashMap<String, Object> map = new HashMap<>(4);
        String userCode = (String)StpUtil.getLoginId();
        List<SysMenu> allByMenuCode = sysMenuService.findAllByUserCode(userCode);
        map.put("flag",true);
        map.put("menu",allByMenuCode);
        map.put("userCode",userCode);
        return map;
    }

}

