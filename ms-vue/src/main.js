// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index.js'
import axios from "axios"
import store from '@/store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.devtools = true
Vue.config.productionTip = false
Vue.prototype.$axios = axios
axios.defaults.baseURL = '/api'  //关键代码
Vue.use(ElementUI)



new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
