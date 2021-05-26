package com.yl.ms.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yl on 2021/3/17
 */
@RestController
@Slf4j
@RequestMapping("user")
public class LoginController {


    /**
     *  测试登录，浏览器访问： http://localhost:9002/user/login?username=zhang&password=123456
     * @return
     */
    @GetMapping("/login")
    public String login(String username, String password) {
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.setLoginId(1);
            return "Login success";
        }
        return "login fail";
    }

    /**
     *    查询登录状态，浏览器访问： http://localhost:9002/user/isLogin
     */
    @RequestMapping("isLogin")
    public String isLogin(String username, String password) {
        System.out.println(StpUtil.getLoginId());
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @GetMapping("/admin")
    public String admin() {
        if (StpUtil.hasPermission("user-admin1")) {
            return "admin success!";
        }
        return "admin fail!";
    }

    @GetMapping("/index")
    public String index() {
        return "index success!";
    }

    @GetMapping("/add1")
    public String add2() {
        return "add success!";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete success well!";
    }
}
