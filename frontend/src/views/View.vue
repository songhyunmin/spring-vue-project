<template>
  <div>
    <div id="personInfoMain">
				<ul data-role="listview" data-inset="true" class="ui-listview ui-listview-inset ui-corner-all ui-shadow">
					<li data-role="list-divider" class="ui-li-divider ui-bar-inherit ui-first-child">교인정보</li>
					<li style="padding: 0px; margin: 0px;" class="ui-li-static ui-body-inherit">
						<table style="width: 100%; table-layout: fixed;" cellpadding="0"
							cellspacing="0" border="0">
							<col width="105px;" />
							<col width="*" />
							<tr>
								<td style="text-align: center; vertical-align: middle;">
                  <img :src="require('@/assets/picture/'+info.data.filename)" :alt="info.data.name" />
								</td>
								<td style="vertical-align: top;">
									<p>
										{{ info.data.name }} <br>({{ info.data.age }}세) ({{ info.data.gender }})
									</p>
									<p>{{ info.data.birth }} ({{ info.data.solar }})</p>
									<p>{{ info.data.core }} {{ info.data.coreRelative }}</p>
									<p>
										<span class="title">HP) </span> 
                    <!--<a :href="'tel:${info.data.mobileNum}'">{{ info.data.mobileNum }}</a>-->
                    <input type="tel" v-model="info.data.mobileNum" />
									</p>
									<p>
										<span class="title">자택) </span> 
                    <!--<a :href="'tel:${info.data.telNum}'">{{ info.data.telNum }}</a>-->
                    <input type="tel" v-model="info.data.telNum" />
									</p>
									<p>
										<span class="title">주소) </span> {{ info.data.addr }} {{ info.data.addrDetail }}
									</p>
									<p>
										<span class="title"> 등록일) </span> {{ info.data.regDate }}
									</p>

								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p></p>
									<a href="#" v-on:click="$naverMap(info.data.addr, info.data.addrDetail)" class="btn-green ui-link ui-btn ui-icon-location ui-btn-icon-left ui-btn-inline ui-shadow ui-corner-all ui-mini"
									data-role="button" data-inline="true" data-mini="true" data-icon="location">네이버맵</a>
									<a href="#" v-on:click="$daumMap(info.data.addr, info.data.addrDetail)" class="btn-blue ui-link ui-btn ui-icon-location ui-btn-icon-left ui-btn-inline ui-shadow ui-corner-all ui-mini"
									data-role="button" data-inline="true" data-mini="true" data-icon="location">다음맵</a>
									<p>
										<span class="title">구역 :</span> {{ info.data.range1 }} &gt; {{ info.data.range2 }} &gt; {{ info.data.range3 }}
									</p>
									<p>
										<span class="title">선교회 :</span> {{ info.data.g }}
									</p>
								</td>
							</tr>

						</table>
					</li>

					<li class="ui-li-static ui-body-inherit ui-last-child">
						<div data-role="controlgroup" data-type="horizontal"
							data-mini="true" style="text-align: center;" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all ui-mini">
							<div class="btn-list">
								<a href="#" data-role="button" data-position-to="window" class="tel-menu ui-link ui-btn ui-shadow ui-corner-all"
								  v-on:click="telMenu()">문자/전화</a>
                <a href="#" data-role="button" data-position-to="window" class="tel-menu ui-link ui-btn ui-shadow ui-corner-all ui-last-child"
								  v-on:click="updateData()">연락처 수정</a>
							</div>
						</div>
					</li>
				</ul>
			</div>

      <div id="personInfoFamily">
				<ul data-role="listview" data-inset="true" class="ui-listview ui-listview-inset ui-corner-all ui-shadow">
					<li data-role="list-divider" class="ui-li-divider ui-bar-inherit ui-first-child ui-last-child">가족사항</li>
          <li v-for="(s, index) in list.data" :key="index" class="list ui-li-static ui-body-inherit ui-li-has-thumb" style="height: 85px; cursor:pointer" v-on:click="familyView(s.id)">
            <img :src="require('@/assets/picture/'+s.filename)" />
						<p>
							{{ s.name }} <span>(</span>{{ s.coreRelative }}<span>)</span>
						</p>
						<p>({{ s.age }}세)</p>
						<p>
							<a :href="'tel:${s.mobileNum}'">{{ s.mobileNum }}</a>
						</p>
						<p>
							<a :href="'tel:${s.telNum}'">{{ s.telNum }}</a>
						</p>
					</li>	

				</ul>
			</div>

      <div id="popupMenuPerson" data-history="false">
				<ul id="popupMenuDetailPerson" data-role="listview" data-inset="true" class="ui-listview ui-listview-inset ui-corner-all ui-shadow" style="min-width: 210px;">
          <li data-role="divider" data-theme="b" class="ui-li-static ui-body-b ui-first-child">{{ info.name }} 전화걸기</li>
          <li><a :href="'tel:${info.data.mobileNum}'" class="ui-btn ui-btn-icon-right ui-icon-carat-r">휴대전화</a></li>
          <li><a :href="'sms:${info.data.mobileNum}'" class="ui-btn ui-btn-icon-right ui-icon-carat-r">문자발송</a></li>
          <li><a :href="'tel:${info.data.telNum}'" class="ui-btn ui-btn-icon-right ui-icon-carat-r">일반전화</a></li>
          <li data-role="divider" data-theme="b" data-icon="back" class="ui-last-child"><a href="#" v-on:click="closeMenu" class="ui-btn ui-btn-b ui-btn-icon-right ui-icon-back">취소</a></li>
        </ul>
			</div>
  </div>
</template>

<script>

import $ from 'jquery'

export default {
  name: 'pview',
  data() {
    return {
      info: {
          data: {
            id: null,
            name: null,
            age: null,
            gender: null,
            birth: null,
            solar: null,
            core: null,
            coreRelative: null,            
            mobileNum: null,
            telNum: null,
            regDate: null,
            addr: null,
            addrDetail: null,
            range1: null,
            range2: null,
            range3: null,
            g: null,
            filename: 'empty.jpg'
          }
      },
      list: {
          count: 0,
          data: []
      }
    };
  },
  methods: {
    set: function () {
        let t = this;
        t.$axios.get(t.$backendApp + '/api/person/' + t.$route.params.id).then((res) => {
            res.data.filename = '@/assets/picture/'+ res.data.name + res.data.id + '.jpg';
            if (!this.$fileExist(res.data.filename)){
                res.data.filename = 'empty.jpg';
            }
            else {
                res.data.filename = res.data.name + res.data.id + '.jpg';
            }
            t.info.data = res.data;
        }).catch(function(err) {
            console.error(err); // Error 출력
        });

        t.$axios.get(this.$backendApp + '/api/family/' + t.$route.params.id).then((res) => {
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
    updateData: function () {
        let t = this;
        let args = t.$renew(t.info.data);
        
        t.$axios.post(this.$backendApp + '/api/update/' + t.$route.params.id, args).then(res => {
          if (res.data == "success") {
            alert('수정되었습니다.');
          }
          else if (res.data == "error") {
            alert('오류가 발생하였습니다.');
            return;
          }
        })
        .catch(err => console.log(err));
    },
    familyView: function (id) {
        if (this.$route.params.id != id) {
          this.$router.push('/view/' + id);
        }
    },
    telMenu: function () {
        $('#popupMenuPerson').show();
    },
    closeMenu: function () {
        $('#popupMenuPerson').hide();
    },
    init: function () {
        let t = this;
        t.set();
    }
  },
  mounted() {
    this.init();
  }
}
</script>

<style scoped>
  .btn-green { background: green; color: #FFFFFF; text-shadow: 0 0 0; }
  .btn-blue { background: #5C96FE; color: #FFFFFF; text-shadow: 0 0 0; }
  .tel-menu { padding-left: 10px !important; padding-right: 10px !important; }
  #popupMenuPerson {
    position: absolute; top: 45%; left: 50%; margin-left: -110px; width: 220px; display:none;
    z-index: 1;
  }
  .btn-list {
    width: 10rem; margin: auto;
  }

  .btn-list .ui-btn {
    display: inline-block;
  }
</style>
