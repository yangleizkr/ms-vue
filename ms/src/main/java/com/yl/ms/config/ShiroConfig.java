/*
package com.yl.ms.config;

import com.yl.ms.utils.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @author by yl on 2021/3/17
 *//*

// Shiro配置类,开启Shrio配置需打开注解,同时需要配置登陆接口Line85,目前前端用的登陆接口为/sys_user/login
// @Configuration
public class ShiroConfig {

    */
/**
     * cookie对象
     * @return rememberMe
     *//*

    @Bean
    public SimpleCookie rememberMeCookie(){
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie rememberMe = new SimpleCookie("rememberMe");
        rememberMe.setMaxAge(86400);
        return rememberMe;
    }

    */
/**
     * cookie管理对象
     * @return cookieRememberMeManager
     *//*

    @Bean
    public CookieRememberMeManager manager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());

        cookieRememberMeManager.setCipherKey(Base64.getDecoder().decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    */
/**
     *  将自己的验证方式加入容器
     *//*

    @Bean
    public CustomRealm myShiroRealm() {
        return new CustomRealm();
    }

    */
/**
     * 权限管理,配置主要是Realm的管理认证
     *//*

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setRememberMeManager(manager());
        return securityManager;
    }

    */
/**
     * ilter工厂，设置对应的过滤条件和跳转条件
     *//*

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>(4);
        //登出
        map.put("/logout", "logout");
        //对所有用户认证
        map.put("/**", "authc");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    */
/**
     * 注入权限管理
     *//*

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
*/
