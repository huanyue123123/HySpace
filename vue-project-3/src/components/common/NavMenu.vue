<template>
  <el-menu router style="min-width: 1300px"
    :default-active="activerouter" class="el-menu-demo" mode="horizontal" @select="selectEvent">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name" >
      {{item.navItem}}
    </el-menu-item>
    <el-menu-item style="width: 50%;float: right;font-size: 14px;text-align: right" >
      {{username}}
      {{cityName}}
      {{date}}
      {{weather}}
    </el-menu-item>

  </el-menu>

</template>
<script>

  export default {
    name: 'NavMenu',
    data () {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/note', navItem: '笔记本'},
          {name: '/library', navItem: '图书馆'},
          {name: '/user', navItem: '个人中心'}
        ],
        activerouter:'/index',
        cityName:'',
        date:'',
        weather:'',
        username:''
      }
    },
    mounted(){
      this.activerouter = window.location.pathname;
      this.getWeather();
      this.getUserInfo();
    },

    methods:{
      selectEvent(key,keyPath){
        console.log(key+"-"+keyPath)
      },
      getWeather(){
        this.$axios
          .post('/menu/getWeather/天津/天津').then(resp => {
          if (resp && resp.data.code === 200) {
            var weatherMsg = resp.data.data;
            if(weatherMsg.length > 0){
              var city = resp.data.data[0]
              var date = resp.data.data[3];
              var weather = resp.data.data[4];
              this.cityName = city;
              this.date = date;
              this.weather = weather;
            }

          }
        })
      },
      getUserInfo(){
        this.$axios.post('/login/getUserInfo').then(resp =>{
          if (resp && resp.data.code === 200) {
            this.username = resp.data.data.username;
          }
        });
      }
    }
  }
</script>
<style scoped>
  a{
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
</style>
