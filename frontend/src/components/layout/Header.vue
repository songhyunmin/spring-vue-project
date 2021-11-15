<template>
    <div>
        <a href="#" v-on:click="$router.go(-1)" class="ui-btn-left ui-btn ui-icon-arrow-l ui-btn-icon-left ui-shadow ui-corner-all" data-role="button" role="button">이전</a>
        <h4 id="headerH4" class="ui-title"><router-link to="/">디모데요람교회 스마트요람</router-link></h4>
        <router-link to="/" class="ui-btn-right ui-btn ui-icon-grid ui-btn-icon-right ui-shadow ui-corner-all" style="padding-left:10px" data-role="button" role="button">메인</router-link>
    </div>
</template>

<script>
export default {
  name: "commonheader"
}
</script>
