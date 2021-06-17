import axios from "axios";
import request from "../../utils/request";

// 查询用户列表
export const listUser = params => {return axios.get('/sys_user/list',{params:params})}

// 查询用户列表
export function getUser(params){
  return request({
    url: '/system/user',
    method: 'get',
    params:params
  })
}

// 新增用户
export function addUser(data){
  return request({
    url: '/sys_user/addUser',
    method: 'post',
    data:data
  })
}

// 修改用户
export function updateUser(data){
  return request({
    url: "/sys_user/modifyUser",
    method: "put",
    data:data
  })
}


// 删除用户
export function delUser(id){
  return request({
    url: '/sys_user/'+id,
    method: 'delete',
  })
}


// 导出用户
export const exportUser = params => {return axios.get('/system/user/export',{params:params})}


// 用户密码重置
export const resetUserPwd = params => {return axios.put('/system/user/resetPwd',{params:params})}


// 用户状态修改
export const changeUserStatus = (userId, status) => {return axios.put('/system/user/changeStatus',{
  userId,
  status
})}
/*


// 查询用户个人信息
export function getUserProfile() {
  return request({
    url: '/system/user/profile',
    method: 'get'
  })
}

// 修改用户个人信息
export function updateUserProfile(data) {
  return request({
    url: '/system/user/profile',
    method: 'put',
    data: data
  })
}

// 用户密码重置
export function updateUserPwd(oldPassword, newPassword) {
  const data = {
    oldPassword,
    newPassword
  }
  return request({
    url: '/system/user/profile/updatePwd',
    method: 'put',
    params: data
  })
}

// 用户头像上传
export function uploadAvatar(data) {
  return request({
    url: '/system/user/profile/avatar',
    method: 'post',
    data: data
  })
}

// 下载用户导入模板
export function importTemplate() {
  return request({
    url: '/system/user/importTemplate',
    method: 'get'
  })
}
*/
