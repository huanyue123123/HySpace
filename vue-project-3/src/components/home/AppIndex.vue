<template>
  <el-container>
    <el-button @click="logout">退出</el-button>
  </el-container>
</template>

<script>
export default {
  name: 'AppIndex',
  data () {
    return {}
  },
  methods: {
    logout () {
      sessionStorage.setItem("token", 'false');
      this.$store.commit('login', {'username': null})
      this.$router.replace({path: '/login'})
    }
  }
}
</script>

<style scoped>

</style>
