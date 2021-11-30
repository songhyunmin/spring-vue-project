<template>
  <div>
    <ul data-role="listview" data-inset="true" id="lvResult" class="ui-listview ui-listview-inset ui-corner-all ui-shadow">
      <li data-role="list-divider" role="heading" class="ui-li-divider ui-bar-inherit ui-li-has-count ui-first-child">“{{ keyword }}” 검색결과 <span class="ui-li-count ui-body-inherit">{{ list.count }}</span></li>
      <li :id="s.id" v-for="(s, index) in list.data" :key="index" class="ui-li-has-thumb">
          <router-link :to="{ name: 'pview', params: { id: s.id}}" class="ui-btn ui-btn-icon-right ui-icon-carat-r">
            <img :src="require('@/assets/picture/'+s.filename)" :alt="s.name" style="width:65px;height:80px;" />
            <div style="margin-top: 6px;">
              {{ s.name }}
              <p>{{ s.range1 }} {{ s.range2 }} {{ s.range3 }}</p>
            </div>
          </router-link>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  name: 'search',
  data() {
    return {
      list: {
          count: 0,
          data: []
      },
      keyword: null
    };
  },
  methods: {
    set: function () {
        let t = this;

        t.keyword = localStorage.getItem('keyword');

        t.$axios.get(this.$backendApp + '/api/search',
        {
          params: { keyword: t.keyword }
        }).then((res) => {
            let result = res.data;
            t.list.count = result.total;
            for (let i in result.data) {
                result.data[i].filename = '@/assets/picture/'+ result.data[i].name + result.data[i].id + '.jpg';
                if (!this.$fileExist(result.data[i].filename)){
                    result.data[i].filename = 'empty.jpg';
                }
                else {
                    result.data[i].filename = result.data[i].name + result.data[i].id + '.jpg';
                }
                t.list.data.push(result.data[i]);
            }
        }).catch(function(err) {
            console.error(err); // Error 출력
        });
    },
    init: function () {
        let t = this;
        t.set();
    }
  },
  created() {
    this.init();
  }
}
</script>

<style scoped>
</style>
