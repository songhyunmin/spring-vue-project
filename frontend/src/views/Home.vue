<template>
  <div class="mainMenuCenter">
      <ul class="mainMenuImageBlock">
          <li v-for="(s, index) in list.data" :key="index">
              <router-link :to="{ name: 'list', params: { pos: s.link}}">
                  <img :src="require('@/assets' + s.img)" v-bind:title="s.title" />
                  <div class=white>{{ s.title }}</div>
              </router-link>
          </li>
      </ul>
  </div>
</template>

<script>
export default {
  name: 'home',
  data() {
    return {
      list: {
          args: {},
          count: 0,
          data: []
      }
    };
  },
  methods: {
    set: function () {
        let t = this;

        this.$axios.get(this.$backendApp + '/api/menu/list').then((res) => {
            let result = res.data;
            t.list.count = result.total;
            for (let i in result.data) {
                result.data[i].link = result.data[i].link.replace('/person/','');
                t.list.data.push(result.data[i]);
            }
        }).catch(function(err) {
            console.error(err); // Error 출력
        });

        //console.log(t.list.data);
    },
    init: function () {
        let t = this;
        t.set();
    }
  },
  created() {
    this.init()
  }
}
</script>

<style scoped>
</style>
