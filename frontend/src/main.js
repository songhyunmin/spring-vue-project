import Vue from 'vue'
import App from './App'
import router from '@/router/index'
import axios from 'axios'

axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
Vue.prototype.$axios = axios
Vue.prototype.$backendApp = 'http://localhost:8080'

// 공통함수 설정
window.$ = window.jQuery = require('jquery')

import jQuery from 'jquery'
global.$ = jQuery

import Vuex from 'vuex'
import lib from '@/assets/js/library'
Vue.use(Vuex)
Vue.use(lib)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router, Vuex, lib, axios,
  render: h => h(App), /** 여기에 넣어야 뒤에서 쓸 수 있음. **/
}).$mount('#app')
