<template>
  <el-container>
    <el-main>
      <el-calendar v-model="calStr"></el-calendar>
    </el-main>
    <el-footer>{{calStr}}</el-footer>

  </el-container>

</template>

<script>
  export default {
    name: "user",
    data() {
      return {
        calStr: ''
      }
    },
    watch: {
      calStr(val,oldval){
        var date = new Date(val);
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate()
        this.calStr = year + '-' + month + '-' + day;
      }
    },
    methods: {

    }

  }
</script>

<style scoped>

</style>
