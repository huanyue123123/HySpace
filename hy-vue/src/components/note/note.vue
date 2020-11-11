<template>
  <el-container>
    <el-header style="text-align: center;line-height: 50px;vertical-align: middle;height: 50px;">
        笔记
    </el-header>
    <el-main style="min-height: 600px">
        <el-table :data="noteList" style="width: 100%">
          <el-table-column prop="id" label="编号"></el-table-column>
          <el-table-column prop="title" label="标题"></el-table-column>
          <el-table-column prop="content" label="内容"></el-table-column>
          <el-table-column prop="date" label="日期"></el-table-column>
        </el-table>
    </el-main>
    <el-footer>
        <el-pagination></el-pagination>
    </el-footer>

  </el-container>


</template>

<script>
    export default {
        name: "note",
        data(){
          return{
            noteList:[{"id":1,"title":"标题1","content":"内容1","date":new Date() +""},
              {"id":1,"title":"标题1","content":"内容1","date":new Date()+""},
              {"id":1,"title":"标题1","content":"内容1","date":new Date()+""},
              {"id":1,"title":"标题1","content":"内容1","date":new Date()+""}
            ]


          }
        }
    }
</script>

<style scoped>

</style>
