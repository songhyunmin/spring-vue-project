<template>
  <div>
    <div class="ui-corner-all custom-corners" style="padding-bottom: 10px" v-for="(s, index) in list.data" :key="index">
      <div class="ui-bar ui-bar-a">
          <h3 v-if="depth==2">{{ s.duty2 }}</h3>
          <h3 v-if="depth==1">{{ s.duty1 }}</h3>
      </div>
      <div class="ui-body-a">
        <ul class="subListImageBlock">

          <li :id="p.id" v-for="(p, index2) in s.person" :key="index2">
            <router-link :to="{ name: 'pview', params: { id: p.id}}">
              <img :src="require('@/assets/picture/'+p.filename)" :alt="p.name" />
              <p>{{ p.name }} {{ p.duty1 }}</p>
            </router-link>
          </li>

        </ul>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'list',
  data() {
    return {
      list: {
          //data: [{duty1:'1',duty2:'2',person:[{id:1,name:'11'}]}]
          data: []
      },
      depth: 2
    };
  },
  methods: {
    set: function () {
        let t = this;
        t.$axios.get(this.$backendApp + '/api/duty/' + t.$route.params.pos).then((res) => {
            let result = res.data;
            for (let k in result.data) {
                let duty1 = result.data[k].name;
                let duty2 = result.data[k].name1;
                let person = [];
                
                t.$axios.get(this.$backendApp + '/api/person',
                {
                  params: { pos: t.$route.params.pos, duty1: duty1, duty2: duty2 }
                }).then((resP) => {
                  console.log(resP);
                    let resultP = resP.data;
                    for (let i in resultP.data) {
                        resultP.data[i].filename = '@/assets/picture/'+ resultP.data[i].name + resultP.data[i].id + '.jpg';
                        if (!this.$fileExist(resultP.data[i].filename)){
                            resultP.data[i].filename = 'empty.jpg';
                        }
                        else {
                            resultP.data[i].filename = resultP.data[i].name + resultP.data[i].id + '.jpg';
                        }
                        person.push(resultP.data[i]);
                    }
                }).catch(function(err) {
                    console.error(err); // Error 출력
                });

                t.list.data.push(
                  {duty1: duty1, duty2: duty2, person: person}
                );
            }

            console.log(t.list.data);
        }).catch(function(err) {
            console.error(err); // Error 출력
        });
    },
    set_del_imsi: function () {
        let t = this;
        let duty1 = '목사';
        let duty2 = '부목사';
        let person = [];
        
        t.$axios.get(this.$backendApp + '/api/person',
        {
          params: { pos: t.$route.params.pos, duty1: duty1, duty2: duty2 }
        }).then((resP) => {
          console.log(resP);
            let resultP = resP.data;
            for (let i in resultP.data) {
                resultP.data[i].filename = '@/assets/picture/'+ resultP.data[i].name + resultP.data[i].id + '.jpg';
                if (!this.$fileExist(resultP.data[i].filename)){
                    resultP.data[i].filename = 'empty.jpg';
                }
                else {
                    resultP.data[i].filename = resultP.data[i].name + resultP.data[i].id + '.jpg';
                }
                person.push(resultP.data[i]);
            }
            t.list.data.push(
              {duty1: duty1, duty2: duty2, person: person}
            );
        }).catch(function(err) {
            console.error(err); // Error 출력
        });
    },
    init: function () {
        let t = this;
        if (t.$route.params.pos == '007' || t.$route.params.pos == '008' || t.$route.params.pos == '009') {
          t.depth = 1;
        }
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
