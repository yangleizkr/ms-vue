package com.yl.ms.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yl.ms.entity.SysUser;
import com.yl.ms.service.SysUserService;
import com.yl.ms.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 * @author yl
 */

@RequestMapping("/sys_user")
@Controller
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * optimize
     * @param sysUser
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,Object> loginSystem(@RequestBody SysUser sysUser){
        HashMap<String,Object> map = new HashMap<>(4);
        SysUser findedSysUser = sysUserService.login(sysUser);
        if(!Objects.isNull(findedSysUser)){
            map.put("flag",true);
            map.put("mes","登陆成功");
            map.put("sysUser",findedSysUser);
            return map;
        }
        map.put("flag",false);
        map.put("mes","账号或密码不正确,请重新输入");
        return map;
    }

    @GetMapping("/list")
    @ResponseBody
    public HashMap<String,Object> listsSysUser(HttpServletRequest request,@RequestParam(required = false,value = "pageNum", defaultValue = "1") Integer pageNum,
    @RequestParam(required = false,value = "pageSize",defaultValue = "10") Integer pageSize){

        HashMap<String,Object> map = new HashMap<>(4);
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        IPage<SysUser> iPage = sysUserService.listUsers(userCode, userName, pageNum, pageSize);
        map.put("iPage",iPage);
        return map;
    }
    @GetMapping("/checkUserCode")
    @ResponseBody
    public HashMap<String,Object> checkUserCode(@RequestParam(value = "userCode") String userCode){
        HashMap<String,Object> map = new HashMap<>(4);

            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            if(!"".equals(userCode)){
                queryWrapper.eq("user_code",userCode);
            }

            List<SysUser> list = sysUserService.list(queryWrapper);
            if (list.size() > 0 ){
                map.put("flag",true);
                map.put("mes","已存在");
                return map;
            }
            map.put("flag",false);
            return map;

    }

    @PostMapping("/addUser")
    @Transactional
    @ResponseBody
    public HashMap<String,Object> addSysUser(@RequestBody SysUser sysUser){
        HashMap<String,Object> map = new HashMap<>(4);
        sysUser.setStatus("1");
        sysUser.setPassword(PasswordUtils.digestPassword(sysUser.getPassword()));
        boolean flag = sysUserService.save(sysUser);
        map.put("flag",flag);
        map.put("mes","添加成功");
        return map;
    }
    @DeleteMapping("/deleteUser")
    @ResponseBody
    public HashMap<String,Object> deleteSysUser(Integer id){
        System.out.println(id);
        HashMap<String,Object> map = new HashMap<>(4);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        SysUser one = sysUserService.getOne(queryWrapper);
        if (Objects.isNull(one)){
            map.put("flag",false);
            map.put("mes","未查询到该用户");

        }else {
            sysUserService.remove(queryWrapper);
            map.put("flag",true);
            map.put("mes","删除成功");
        }

        return map;
    }
}

