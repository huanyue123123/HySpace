<template>
    <el-container>
        <!-- <el-card >
           <el-image
                   style="width: 100px; height: 100px"
                   :src="url"
                   :fit="fit"></el-image>
         </el-card>
         <el-button @click="logout">退出</el-button>-->
        <el-container>
            <el-aside class="menu-box" :style="asideHeight">
                <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                         :collapse="isCollapse" @click.native="collapseOpen"

                >
                    <!--                    v-for="(item, k) in menu.list"-->
                    <el-submenu v-for="(menu,i) in menuList" :key="menu.id"
                                :index="i + ''">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">{{menu.title}}</span>
                        </template>
                        <el-menu-item v-for="(item, k) in menu.list" :index="i + '-'+k" :key="item.classId"
                                      @click="initList(menu.id,item.classId)">{{item.classTitle}}
                        </el-menu-item>


                    </el-submenu>
                </el-menu>

            </el-aside>
            <el-main class="main-box infinite-list-wrapper" @click.native="collapseClose" style="overflow:auto"
                     :style="asideHeight">
                <ul
                        class="list"
                        v-infinite-scroll="load"
                        infinite-scroll-disabled="disabled">
                    <li v-for="(img,i) in imgList" class="list-item" :index = "i + ''">
                        <el-card style="height: 300px;padding: 0px!important;">
                            {{img.title}}
                            <el-image :src="img.cover" style="height: 260px;width: 600px;float: left"
                                      fit="cover"></el-image>
                        </el-card>

                    </li>
                </ul>

                <el-card style="height: 60px;padding: 0px!important; text-align: center;vertical-align: middle;"
                         v-if="loading">
                    加载中。。。
                </el-card>
                <el-card
                        style="height: 60px;padding: 0px!important; text-align: center;vertical-align: middle;line-height: 26px;"
                        v-if="noMore">
                    没有更多了
                </el-card>
            </el-main>
        </el-container>

    </el-container>
</template>

<script>
    export default {
        name: 'AppIndex',
        data() {
            return {
                isCollapse: true,
                asideHeight: {
                    height: '780px',
                    width: 'auto'
                },
                imgList: [],
                count: 0,
                pageNo: 1,
                pageSize: 3,
                loading: false,
                total: 20,
                menuList: [{
                    id: '1',
                    title: '空之境界',
                    list: [{classId: '1.1', classTitle: '删减版'}, {classId: '1.2', classTitle: '删减版'}]
                }, {id: '2', 'title': '魔法使之夜', list: [{classId: '2.1', classTitle: '魔法使之夜'}]}]
            }
        },
        computed: {
            noMore() {
                return this.count >= this.total;
            },
            disabled() {
                return this.loading || this.noMore
            }
        },
        mounted() {
            var asideHeight = document.body.clientHeight;
            this.asideHeight.height = asideHeight + 'px';
            this.initList(0, 0);
        },
        methods: {
            logout() {
                sessionStorage.setItem("token", 'false');
                this.$store.commit('login', {'username': null})
                this.$router.replace({path: '/login'})
            },
            handleOpen(key, keyPath) {
            },
            handleClose(key, keyPath) {
            },
            collapseOpen() {
                this.isCollapse = false;
            },
            collapseClose() {
                this.isCollapse = true;
            },
            load() {
                this.loading = true;

            },
            initList(id, classId) {

            },
        }
    }
</script>

<style scoped>
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        height: 100%;
    }

    .el-menu-vertical-demo {
        height: 100%;
    }

    .menu-box {
        height: 100%;
    }

    .main-box {
    }

    .list {

    }

    .list .list-item {
        text-align: center;
        background-color: aquamarine;
        list-style-type: none;
        margin-bottom: 20px;
    }
</style>
