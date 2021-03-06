import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './http.js';


Vue.config.productionTip = false
Vue.use(ElementUI)
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
axios.defaults.withCredentials = true


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
