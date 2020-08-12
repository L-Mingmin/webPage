// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

// 完整引入ElementUI
Vue.use(ElementUI)

// 设置反向代理，前端请求默认发送到http://localhost.8443/api
var axios = require('axios')
// axios.defaults.baseURL = 'http://47.104.188.61:8443/api'
axios.defaults.baseURL = 'http://127.0.0.1:8443/api'

// 全局注册，之后可在其它组件中通过this.$axios()发送数据
Vue.prototype.$axios = axios

Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
