import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '.././views/Home.vue'
import Search from '.././views/Search.vue'
import List from '.././views/List.vue'
import View from '.././views/View.vue'
import fs from 'fs';

Vue.use(VueRouter)
Vue.use(fs)

const Err = { template: '<div>Error</div>' }

let routes = [
    { path: '/', component: Home },
    { path: '/search', name: 'search', component: Search },
    { path: '/list/:pos', name: 'list', component: List },
    { path: '/view/:id', name: 'pview', component: View },
    // Errors
    { path: '*',  component: Err  }
]

export default new VueRouter({
    base: 'public', 
    mode: 'history',
    routes
})