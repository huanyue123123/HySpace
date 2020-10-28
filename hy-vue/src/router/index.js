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

export default new Router({
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
      path: '/',
      name: 'Login',
      component: Login
    }


  ]
})
