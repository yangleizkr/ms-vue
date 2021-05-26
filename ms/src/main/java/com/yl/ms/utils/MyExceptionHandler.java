/*
package com.yl.ms.utils;

import com.yl.ms.constain.PermissionEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

*/
/**
 * Created by yl on 2021/3/17
 *//*

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        if (e.getLocalizedMessage().contains(PermissionEnum.BUTTON_ADD)) {
            return "没有添加按钮权限,请联系管理员";
        }else if (e.getLocalizedMessage().contains(PermissionEnum.BUTTON_DELETE)){
            return "没有删除按钮权限,请联系管理员";
        }
        log.error("没有通过权限验证");
        return "没有通过权限验证！";
    }
}
*/
