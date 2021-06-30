import axios from "axios";
import request from "../../utils/request";
import store from '@/store'
import Main from '@/components/Main'
import router from "../../router";
// 获取路由
export function getRouters(){
  request({
    url: '/sys_user/getRouters',
    method: 'get'
  }).then(res => {
    if (res.data.flag == true){
    }
  })
}

export const initMenu = () => {
  if (store.state.route.length > 0) {
    return;
  }
  request("/sys_user/getRouters").then((res) => {
    if (res.data.flag == true) {
      //格式化router
      let fmtRoutes = getAsyncRoutes(res.data.menu); //添加到router
      // router.options.routes = fmtRoutes;
      router.addRoutes(fmtRoutes)
      store.commit("initRoutes", fmtRoutes);
      store.commit("initUserInfo", res.data.userCode);
    }
  });
};

export const initMenu2 = () => {
  initMenu()
};

export const formatRoutes = (routes) =>{
  let fmRoutes = [];

  routes.forEach((router) => {

    let {menuUrl,componentname,menuName,iconcls,children,hidden} = router;

    if (children && children instanceof Array){
      children  = formatRoutes(children)
    }
    let fmRouter = {
      path: menuUrl,
      name: menuName,
      iconCls: iconcls,
      hidden:hidden,
      children: children,
      component : () => import('@/views/'+componentname)
      // component: (resolve) => require([`@/views/${componentname}.vue`], resolve),
    };
    fmRoutes.push(fmRouter);
  });
  return fmRoutes;
}

export function getAsyncRoutes(routes) {

  const res = []

  routes.forEach(route => { // 所有菜单都是二级结构，一级没有页面功能，所以只要添加二级菜单的路由
    const children = []
    route.children.forEach(menu => { // 二级菜单需匹配页面
      children.push({
        path: menu.menuUrl,
        name: menu.menuName,
        iconCls: menu.iconcls,
        // 此处使用require，由于import会有奇怪的错误
        component: (resolve) => require([`@/views/${menu.componentname}`], resolve),
      })
    })
    res.push({
      path: route.menuUrl,
      name: route.menuName,
      component: Main,
      iconCls: route.iconcls,
      children: children
    })

  })
  return res
}
