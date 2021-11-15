<template>
    <div class="ui-grid-b">
        <div class="ui-block-a search">
            <input type="text" name="keyword" id="keyword" v-model="item.keyword"
              placeholder="이름 혹은 전화번호를 입력하세요." data-mini="true"
              data-clear-btn="true" style="height: 30px; width: 90%;" v-on:keyup.enter="search()" />
        </div>
        <div class="ui-block-b search"></div>
        <div class="ui-block-c search">
            <a href="#" data-role="button" type="search" v-on:click="search()" data-theme="button" style="height: 12px; font-size: 1em;" class="ui-link ui-btn ui-btn-button ui-shadow ui-corner-all">검 색</a>
        </div>
    </div>
</template>

<script>

export default {
  name: "search-top",
  data() {
    return {
      item: {
          keyword: null
      },
      pageView: 0
    };
  },
  methods: {
    search: function () {
        let t = this;
        let args = this.$renew(t.item);
        
        if (!args.keyword) {
            alert('검색어를 입력해 주세요.');
            return;
        }

        localStorage.setItem('keyword', args.keyword);

        // if(this.$route.path!=='/search')
        //     this.$router.push('/search')
        // else
        //     this.$router.go(); 

        this.pageView++;
        this.$router.push('/search?' + this.pageView);
    }
  }
}
</script>
