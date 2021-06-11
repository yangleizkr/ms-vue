<template>
  <div class="index">
    <el-container style="border: 1px solid #eee;">
      <el-header style="border: 1px solid #eee;height: 50px ;background-color: #545c64">
        <el-row >
          <el-col :span="3" class="logo" style="font-weight: bold;font-size: xx-large ;color: white;">
            {{ collapsed ? '' : sysName }}
          </el-col>
          <el-col :span="10"></el-col>
          <el-col :span="4" class="userinfo">
            <el-dropdown trigger="hover">
              <span class="el-dropdown-link userinfo-inner"><img :src="this.sysUserAvatar"/> {{ sysUserName }}</span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>我的消息</el-dropdown-item>
                <el-dropdown-item>设置</el-dropdown-item>
                <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </el-col>
        </el-row>
      </el-header>
      <el-container style="border: 1px solid #eee">
        <el-aside style="border: 1px solid #eee">
          <el-menu
            :default-active="$route.path"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            @select="handleselect"
            unique-opened router
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <div v-for="(item,index) in $router.options.routes" v-if="!item.hidden">
              <el-submenu :index="index+''" v-if="!item.leaf">
                <div slot="title"><i :class="item.iconCls"></i>{{ item.name }}</div>
                <el-menu-item v-for="child in item.children" :index="child.path" :key="child.path" v-if="!child.hidden">
                  <i :class="child.iconCls"></i>{{ child.name }}
                </el-menu-item>
              </el-submenu>
<!--              <el-menu-item v-if="item.leaf&&item.children.length>0" :index="item.children[0].path"><i-->
<!--                :class="item.iconCls"></i>{{ item.children[0].name }}-->
<!--              </el-menu-item>-->
            </div>
          </el-menu>
        </el-aside>
        <el-main style="border: 1px solid #eee">
          <el-row :gutter="20" style="margin-bottom: 20px">
           <el-col :span="6"><el-breadcrumb separator="/" class="breadcrumb-inner">
             <el-breadcrumb-item v-for="item in $route.matched" :key="item.path">
               {{ item.name }}
             </el-breadcrumb-item>
           </el-breadcrumb></el-col>
          </el-row>

          <el-row style="border: 1px solid #eee;">
            <router-view></router-view>
          </el-row>
        </el-main>
      </el-container>
      <el-footer style="border: 1px solid #eee ;height: 30px"> © CopyRight 2020-2021 MS MS管理平台</el-footer>

    </el-container>
  </div>
</template>

<script>
  import avatar from '../assets/user.png'

  export default {
    name: "Main",
    data() {
      return {
        collapsed: false,
        sysName: 'MS管理平台',
        sysUserAvatar: avatar,
        sysUserName: '姓名'
      }
    },
    created() {
      sessionStorage.setItem("sysName",'MS管理平台');
      this.sysUserName = sessionStorage.getItem("userName")
    },
    methods: {
      handleOpen() {

      },
      handleClose() {

      },
      handleselect() {

      },
      logout() {
        this.$router.push("/");
      }
    }
  }
</script>

<style scoped>
  .index {
    height: calc(100vh);
  }

  html, body, #app, .el-container {

    /*统一设置高度为100%*/
    height: 100%;
    margin: 0;

  }
  .userinfo {
    text-align: right;
    padding-right: 35px;
    float: right;
  }
  .userinfo-inner {
    cursor: pointer;
    color: #fff;
  }
  img {
    width: 40px;
    height: 40px;
    border-radius: 20px;
    margin: 10px 0px 10px 10px;
    float: right;
  }


</style>
