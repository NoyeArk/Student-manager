import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/admin/HomeViewAdmin.vue'
import Layout from "@/views/LayoutAdmin";
import LayoutStu from "@/views/LayoutStu";
import LayoutAdmin from "@/views/LayoutAdmin";

Vue.use(VueRouter)

const routes = [

  {
    path: '/login',
    name: 'Login',
    component: () => import('../../src/views/login/Login.vue')
  },
  {
    path: '/',
    name: 'LayoutStu',
    component: LayoutStu,
    redirect: '/login',
    children: [ //子路由
      {
        path: 'homeStu',
        name: 'HomeStu',
        component: () => import('../views/student/HomeViewStu.vue')
      },
      {
        path: 'stuInfo',
        name: 'StuInfo',
        component: () => import('../views/student/stuInfo.vue')
      },
      {
        path: 'editSelf',
        name: 'EditSelf',
        component: () => import('../views/student/editSelf.vue')
      },
    ]
  },
  {
    path: '/',
    name: 'LayoutAdmin',
    component: LayoutAdmin,
    redirect: '/login',
    children: [ //子路由
      {
        path: 'homeAdmin',
        name: 'HomeAdmin',
        component: () => import('../views/admin/HomeViewAdmin.vue'),
        meda: {
          title: '成功了'
        }
      },

      //——————————————————————admin————————————————————————————————
      {
        path: 'studentList',
        name: 'StudentList',
        component: () => import('../views/admin/Student.vue')
      },
      {
        path: 'addStu',
        name: 'AddUser',
        component: () => import('../views/admin/AddStu.vue')
      },
      {
        path: 'editStu',
        name: 'EditStu',
        component: () => import('../views/admin/EditStu.vue')
      },
      {
        path: 'showStu',
        name: 'ShowStu',
        component: () => import('../views/admin/showStu.vue')
      },
      {
        path: 'accountInfo',
        name: 'AccountInfo',
        component: () => import('../views/admin/accountInfo.vue')
      },
      {
        path: 'editAdmin',
        name: 'EditAdmin',
        component: () => import('../views/admin/editAdmin.vue')
      },




      // {
      //   path: 'editAdmin',
      //   name: 'EditAdmin',
      //   component: () => import('../views/admin-1/Edit.vue')
      // },
      // {
      //   path: 'showAdmin',
      //   name: 'ShowAdmin',
      //   component: () => import('../views/admin-1/show.vue')
      // },
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
