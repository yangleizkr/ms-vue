create table sys_menu
(
    id          int auto_increment comment '自增主键'
        primary key,
    menu_code   varchar(10)  not null comment '菜单编码',
    menu_name   varchar(20)  not null comment '菜单名称',
    menu_url    varchar(100) null comment '菜单路径',
    parent_code varchar(10)  null comment '父菜单编码',
    pre_code    varchar(10)  null comment '前菜单编码',
    next_code   varchar(10)  null comment '后菜单编码'
)
    comment '系统菜单表';

INSERT INTO `ms-vue`.sys_menu (id, menu_code, menu_name, menu_url, parent_code, pre_code, next_code) VALUES (1, '123', '测试菜单', '/sysMenu/list', '0', '0', '1234');
INSERT INTO `ms-vue`.sys_menu (id, menu_code, menu_name, menu_url, parent_code, pre_code, next_code) VALUES (2, '12345', 'test1', '/sysMenu/list1', '123', '0', '0');

create table sys_user
(
    id         int auto_increment
        primary key,
    user_code  varchar(30)         not null comment '用户编码',
    user_name  varchar(30)         not null comment '用户名称',
    password   varchar(64)         not null comment '登陆密码',
    email      varchar(30)         null comment '邮箱',
    mobile     varchar(20)         null comment '移动电话',
    address    varchar(100)        null comment '家庭地址',
    phone      varchar(20)         null comment '固定电话',
    status     char(2) default '1' not null comment '用户状态',
    makeDate   varchar(10)         null,
    makeTime   varchar(10)         null,
    modifyDate varchar(10)         null,
    modifyTime varchar(10)         null,
    constraint sys_user_user_code_uindex
        unique (user_code)
)
    comment '用户信息表';

INSERT INTO `ms-vue`.sys_user (id, user_code, user_name, password, email, mobile, address, phone, status, makeDate, makeTime, modifyDate, modifyTime) VALUES (1, 'admin', 'ms管理员', 'e10adc3949ba59abbe56e057f20f883e', null, null, '123123213123', null, '1', null, null, null, null);
INSERT INTO `ms-vue`.sys_user (id, user_code, user_name, password, email, mobile, address, phone, status, makeDate, makeTime, modifyDate, modifyTime) VALUES (2, 'admin1', 'ms管理员1', 'e10adc3949ba59abbe56e057f20f883e', null, null, '123123', null, '1', null, null, null, null);
