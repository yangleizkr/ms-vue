import Vue from 'vue'
import Vuex from 'vuex'
import router from "../router";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    route: [],
    reRoute:[],
    userInfo:[],
  },
  mutations: {
    initRoutes(state, data) {
      state.route = data
      state.reRoute = router.options.routes
      state.route = state.reRoute.concat(state.route)

    },
    initUserInfo(state,data){
      state.userInfo = data
      return state.userInfo
    }
  },
  actions: {},
  modules: {},
})
