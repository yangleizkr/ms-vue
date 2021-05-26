/*
package com.yl.ms.utils;

import com.yl.ms.entity.Permissions;
import com.yl.ms.entity.SysRole;
import com.yl.ms.entity.User;
import com.yl.ms.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

*/
/**
 * Created by yl on 2021/3/17
 *//*

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    */
/**
     * @MethodName doGetAuthorizationInfo
     * @Description 权限配置类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     * @Author WangShiLin
     * @param principalCollection
     * @return
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String)principalCollection.getPrimaryPrincipal();
        User user = sysUserService.getUserByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (SysRole role : user.getRoles()){
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (Permissions permissions :role.getPermissions()){
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
            }
        }
        return simpleAuthorizationInfo;
    }

    */
/**
     * @MethodName doGetAuthenticationInfo
     * @Description 认证配置类
     * @Param [authenticationToken]
     * @Return AuthenticationInfo
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (StringUtils.isEmpty(authenticationToken.getPrincipal())) {
            return null;
        }
        String name = authenticationToken.getPrincipal().toString();
        User user = sysUserService.getUserByName(name);
        if (user == null) {
            return null;
        }else {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
*/
