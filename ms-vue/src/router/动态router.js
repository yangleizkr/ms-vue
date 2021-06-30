import Vue from 'vue'
import login from '@/components/login'
import Main from '@/components/Main'
import VueRouter from "vue-router";
import {initMenu2} from "@/api/system/menu";
import store from '@/store'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: "history",
  routes:[
    {
      path: '/login',
      name: 'login',
      component: login,
      hidden: true
    }, {
      // 首页
      path: '/main',
      component: Main,
      hidden: true,
      meta:{
        requireAuth:true
      }
    },{
      // 首页
      path: '/myMsg',
      name: '我的信息',
      component: () => import('../views/buss/myMsg'),
      hidden: true
    },{
      path: '/',
      component: Main,
      name: '日志管理',
      iconCls: 'el-icon-user-solid',
      children: [
        {
          path: '/User1',
          name: '日志管理1',
          iconCls: 'a fa-address-card',
          component: (resolve) => require(['../views/buss/log'], resolve),
          // component: () => import('../views/buss/log')
        }
      ]
    }
  ]
})



//路由导航守卫函数
router.beforeEach((to, from, next) => {

  const userCode = window.sessionStorage.getItem("userCode");
  const userInfo = store.state.userInfo


  if (userCode){
    if (userCode !== userInfo){
      store.state.route = []
      store.state.reRoute = []
    }
    initMenu2();
    next();

  }
  else {
    if (to.path === "/login") {
      return next();
    } else {
      next("/" + to.path);
    }
  }
});

export default router;
