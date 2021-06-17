<template>
  <div class="personalCenter">
    <el-container>
      <el-header>我的消息</el-header>
      <el-container>
        <el-aside width="400px">
          <el-col :span="10">
            <div class="sub-title"></div>
            <div class="demo-basic--circle">
              <div class="img">
                <el-avatar
                  :size="100"
                  :src="circleUrl"
                  align="center"
                ></el-avatar>
              </div>
              <div class="block">
                <span>ADMIN</span>
              </div>
            </div>
          </el-col>
          <el-input
            v-model="input1"
            type="text"
            placeholder="编码"
            show-word-limit
          ></el-input>
          <el-input
            v-model="input2"
            type="text"
            placeholder="用户名"
            show-word-limit
          ></el-input>
          <el-input
            v-model="input4"
            placeholder="密码"
            show-password
          ></el-input>
          <el-input
            v-model="input5"
            type="text"
            placeholder="地址"
            show-word-limit
          ></el-input>
          <el-input v-model="input7" placeholder="邮箱">
          </el-input>
          <el-input
            v-model="input8"
            type="text"
            placeholder="手机号码"
            maxlength="20"
            show-word-limit
          ></el-input>
          <el-button-group style="float: right; padding: 3px 0" type="text">
            <el-button type="primary" size="medium" round>保存</el-button>
          </el-button-group>
        </el-aside>
        <el-container>
          <el-main>
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span style="float: left"><b>账号绑定</b></span>
                <el-button-group
                  style="float: right; padding: 3px 0"
                  type="text">
                  <el-button
                    type="primary"
                    icon="el-icon-edit"
                    size="medium"
                    round>
                    修改信息
                  </el-button>
                  <el-button
                    type="primary"
                    icon="el-icon-check"
                    size="medium"
                    round>
                    确认修改
                  </el-button>
                </el-button-group>
              </div>
              <div v-for="o in 1" :key="o" class="text item">

              </div>
              <div v-for="o in 1" :key="o" class="text item">

              </div>
            </el-card>
            <el-card class="box-card">
              <div>
                <span style="float: left" shadow="hover"><b>个人签名</b></span>
                <br />
                <br />
                <span>哦雷洛卡</span>
                <el-divider></el-divider>
                <span>多咯</span>
                <el-divider></el-divider>
                <span>所累哇多卡拉</span>
              </div>
            </el-card>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  name: 'PersonalCenter',
  data() {
    return {
      text: '',
      input1: '',
      input2: '',
      input3: '',
      input4: '',
      input5: '',
      input6: '',
      input7: '',
      input8: '',
      input9: '',
      circleUrl:'*头像图片*',
      sizeList: ['large'],
      tableData: [
        {
          date: '2021-06-17',
        },
      ],
    }
  },
  methods: {

  },
}
</script>
<style>
.el-header {
  line-height: 60px;
  text-align: center;
  background-color: #b3c0d1;
}
.el-aside {
  line-height: 44px;
  text-align: center;
  background-color: #d3dce6;
}
.el-main {
  line-height: 36px;
  text-align: center;
  background-color: #e9eef3;
}

.demo-basic--circle {
  align: 'center';
  margin-top: 30px;
  margin-left: 150px;
}
.block {
  margin-left: 25px;
  font-weight: bold;
}
.text {
  font-size: 14px;
}
.item {
  margin-bottom: 180px;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: '';
}
.clearfix:after {
  clear: both;
}
</style>

