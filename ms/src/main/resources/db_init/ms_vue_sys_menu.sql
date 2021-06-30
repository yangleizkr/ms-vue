insert into `ms-vue`.sys_menu (id, menu_code, menu_name, menu_url, parent_code, pre_code, next_code, hidden, componentName, iconCls)
values  (1, '123', '测试菜单', '/sysMenu/list', '0', '0', '1234', null, null, null),
        (2, '12345', 'test1', '/sysMenu/list1', '123', '0', '0', null, null, null),
        (3, '00000', '首页', '/main', null, null, null, 1, 'Main', 'el-icon-user-solid'),
        (4, '00001', '系统管理', '/', '00000', null, null, 0, 'Main', 'el-icon-user-solid'),
        (5, '000010', '用户管理', '/User', '00001', null, null, 0, 'buss/User', 'el-icon-user-solid'),
        (6, '000011', '角色管理', '/Role', '00001', '000010', '000012', 0, 'buss/Role', 'el-icon-user-solid'),
        (7, '000012', '菜单管理', '/Menu', '00001', '000011', null, 0, 'buss/Menu', 'el-icon-user-solid');
