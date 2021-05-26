package com.yl.ms.utils;

import cn.dev33.satoken.stp.StpInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yl on 2021/5/25
 */
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user-add");
        list.add("user-admin");
        list.add("user-delete");
        list.add("user-update");
        list.add("user-get");
        list.add("article-get");
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        return null;
    }
}
