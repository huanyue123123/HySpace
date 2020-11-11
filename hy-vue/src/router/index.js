import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Library from '@/components/library/LibraryIndex'
import Note from '@/components/note/note'
import User from '@/components/System/user'
// eslint-disable-next-line no-unused-vars
import SideMenu from '../components/library/SideMenu'

Vue.use(Router)

const router =  new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
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
});

export default router;

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) { // 判断该路由是否需要登录权限
    if (sessionStorage.getItem("token")&&sessionStorage.getItem("token") == 'true') { // 判断本地是否存在token
          next();
    } else {
      // 未登录,跳转到登陆页面
      next({
        path: '/login'
      })
    }
  } else {
    if(sessionStorage.getItem("token")&&sessionStorage.getItem("token") == 'true'){
      next('/index');
    }else{
      next();
    }
  }
});
