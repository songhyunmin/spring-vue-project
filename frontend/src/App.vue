<template>
  <div id="app">

    <div id="pageMain" data-role="page" data-url="pageMain" tabindex="0" class="ui-page ui-page-theme-a ui-page-header-fixed ui-page-footer-fixed ui-page-active">

      <div id="mainHeader" data-theme="a" data-role="header" data-position="fixed" role="banner" class="ui-header ui-bar-a ui-header-fixed slidedown">

          <Header />

      </div>

      <div data-role="content" id="content1" class="mainBGColor" style="padding: 4px 7px; margin-bottom: 0; height: 100%;">
        
          <SearchTop ref="searchTop" />

          <router-view :key="$route.fullPath"></router-view>
          
      </div>

      <div data-role="footer" id="mainFooter" data-theme="b" data-position="fixed">
          
          <Footer />

      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import Meta from 'vue-meta'
import Header from './components/layout/Header.vue'
import SearchTop from './components/layout/SearchTop.vue'
import Footer from './components/layout/Footer.vue'
import LoadScript from 'vue-plugin-load-script';

Vue.use(Meta)
Vue.use(LoadScript);

Vue.config.productionTip = false

Vue.loadScript("//code.jquery.com/jquery-1.11.1.min.js")
Vue.loadScript("//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js")

export default {
  name: 'App',
  components: {
    Header,
    SearchTop,
    Footer
  },
  metaInfo: {
    title: 'Vue.js와 Spring Boot',
    titleTemplate: '%s | Vue.js와 Spring Boot를 이용한 사이트 개발',
    htmlAttrs: {
      lang: 'en-US'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'description', content: 'Vue.js와 Spring Boot를 이용한 사이트 개발' },
      { name: 'viewport', content: 'user-scalable=no, width=device-width, initial-scale=1' }
    ]
  },
  methods: {
    init: function () {

    }
  },
  created() {
    this.init()
  }
}
</script>

<style>
  @import url("//code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css");
  @import url("./assets/css/StyleSheet.css");
</style>

