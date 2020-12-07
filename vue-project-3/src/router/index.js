import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import MyHome from '@/components/Home'
import Library from '@/components/library/LibraryIndex'
import Note from '@/components/note/note'
import User from '@/components/system/user'

Vue.use(VueRouter)

const routes = [

  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }, {
    path: '/home',
    name: 'Home',
    component: MyHome,
    // home页面并不需要被访问
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: 'AppIndex',
        component: AppIndex,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/library',
        name: 'Library',
        component: Library,
        meta:{
          requireAuth:true
        }
      },
      {
        path: '/note',
        name: 'Note',
        component: Note,
        meta: {
          requireAuth: true
        }
      }, {
        path: '/user',
        name: 'User',
        component: User,
        meta: {
          requireAuth: true
        }
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/',
    name: 'Login',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requireAuth)){ // 判断该路由是否需要登录权限
    if (sessionStorage.getItem("token")) { // 判断当前的token是否存在 ； 登录存入的token
      next();
    }
    else {
      next({
        path: '/',
        query: {redirect: to.fullPath} // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  }
  else {
    next();
  }
});

