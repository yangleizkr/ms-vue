<template>
  <div id="User">
    <el-form :inline="true" ref="form" :model="form" label-width="80px" size="small" :label-position="labelPosition">
      <el-form-item label="用户编码">
        <el-input v-model="form.userCode"></el-input>
      </el-form-item>

      <el-form-item label="用户名称">
        <el-input v-model="form.userName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search">查询</el-button>
        <el-button type="primary" @click="showDialog">新增用户</el-button>
      </el-form-item>
    </el-form>



    <el-table
      :data="userData"
      stripe
      border
      style="width: 100%">
      <el-table-column label="选择" width="60">
        <template slot-scope="scope">
          <el-checkbox
            @change="handleCheck(scope.row)"
            v-model="scope.row.check">
          </el-checkbox>
        </template>
      </el-table-column>
      <el-table-column
        prop="id"
        v-if="show"
        label="主键"
        width="0">
      </el-table-column>
      <el-table-column
        prop="userCode"
        label="用户编码"
        width="180">
      </el-table-column>
      <el-table-column
        prop="userName"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
      <el-table-column
        prop="email"
        label="邮箱">
      </el-table-column>
      <el-table-column
        prop="mobile"
        label="手机">
      </el-table-column>

      <el-table-column
        fixed="right"
        label="操作"
        width="130">
        <template #default="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small" @click="modifyUser(scope.row,true)">编辑</el-button>
          <el-button @click="handleDelete(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>

    </el-table>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage4"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="10"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
    <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
      <el-form :model="SubmitForm">
        <el-form-item label="主键" :label-width="formLabelWidth" disabled="disabled">
          <el-input v-model="SubmitForm.id" disabled="disabled"></el-input>
        </el-form-item>
        <el-form-item label="编码" :label-width="formLabelWidth">
          <el-input v-model="SubmitForm.userCode" autocomplete="off" @blur="checkUserCode"></el-input>
        </el-form-item>
        <el-form-item label="名称" :label-width="formLabelWidth">
          <el-input v-model="SubmitForm.userName" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="SubmitForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input v-model="SubmitForm.address" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" :label-width="formLabelWidth">
          <el-input v-model="SubmitForm.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机" :label-width="formLabelWidth">
          <el-input v-model="SubmitForm.mobile" autocomplete="off"></el-input>
        </el-form-item>

      </el-form>
      <template #footer>
    <span class="dialog-footer">
      <el-button @click="open = false">取 消</el-button>
      <el-button type="primary" @click="submitForm">提 交</el-button>
    </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "User",
    data() {
      return {
        labelPosition: 'right',
        show: false,
        formLabelWidth: '120px',
        form: {
          id: '',
          userCode: '',
          userName: ''
        },
        flag: false,
        SubmitForm: {
          id : '',
          userCode: '',
          userName: '',
          password:'',
          address: '',
          email: '',
          mobile: '',
        },
        userData: [],
        title: '',
        open: false,
        userList: '',
        currentPage4:1,
        total:0,
        pageInfo:[]
      }
    },
    mounted() {
      this.search();
    },
    methods: {
      reset(){
        this.SubmitForm.id = undefined
        this.SubmitForm.userCode = undefined
        this.SubmitForm.userName = undefined
        this.SubmitForm.password = undefined
        this.SubmitForm.address = undefined
        this.SubmitForm.email = undefined
        this.SubmitForm.mobile = undefined
      },
      search() {
        console.log(this.form);
        axios.get('/sys_user/list', {
          params: {
            userCode: this.form.userCode,
            userName: this.form.userName,
            pageNum : this.pageNum,
            pageSize: this.pageSize
          }
        }).then(res => {
          this.userData = res.data.iPage.records;
          this.total = res.data.iPage.total;
        })
      },
      handleSizeChange(val) {
        this.pageSize = val;
        this.search();
      },
      handleCurrentChange(val) {
        this.pageNum = val;
        this.search();
      },
      handleCheck(row) {
        if (row.check == true) {
          this.form.userCode = row.userCode
          this.form.userName = row.userName
        } else {
          this.form.userCode = ''
          this.form.userName = ''
        }
      },
      checkUserCode(){
        if(this.SubmitForm.userCode == ''){
          this.$message({
            type:'error',
            message:"用户名不能为空"
          })
        }else {
          axios.get('/sys_user/checkUserCode', {
            params: {
              userCode: this.SubmitForm.userCode,
            }
          }).then(res => {
            if (res.data.flag === true){
              this.$message({
                type:'error',
                message:res.data.mes
              })
              this.SubmitForm.userCode = ''
            }
          })
        }
      },
      showDialog() {
        this.reset()
        this.open = true;
        this.title = "新增用户"
        this.flag = false;
      },
      modifyUser(row) {
        this.reset()
        this.open = true;
        this.title = "修改用户";
        this.SubmitForm.id = row.id
        this.SubmitForm.userCode = row.userCode
        this.SubmitForm.userName = row.userName
        this.SubmitForm.password = row.password
        this.SubmitForm.address = row.address
        this.SubmitForm.email = row.email
        this.SubmitForm.mobile = row.mobile
        this.flag = true;
      },
      handleClick(row) {
        alert(row.id + " " + row.userName)
        let sysName = sessionStorage.getItem("sysName")
      },
      handleDelete(row){
        axios.delete('/sys_user/deleteUser',{
          params:{
            id : row.id
          }
        }).then(res => {
            if(res.data.flag === true){
              this.open = false;
              this.$message({
                type:'success',
                message:res.data.mes
              })
              this.search();
            }else {
              this.$message({
                type:'error',
                message:res.data.mes
              })
            }
          })
      },
      submitForm() {
        if(!this.flag){
          axios.post('/sys_user/addUser', this.SubmitForm)
            .then(res => {
              if(res.data.flag === true){
                this.open = false;
                this.$message({
                  type:'success',
                  message:res.data.mes
                })
                this.search();
              }
            })
        }else {
          axios.put('/sys_user/mofidyUser', this.SubmitForm)
            .then(res => {
              if(res.data.flag === true){
                this.open = false;
                this.$message({
                  type:'success',
                  message:res.data.mes
                })
                this.search();
              }
            })
        }
      }

    }
  }
</script>

<style scoped>

</style>
