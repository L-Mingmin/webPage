import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Home from '../components/Home'
import AppIndex from '../components/index/AppIndex'
import CityIndex from '../components/projects/CityIndex'
import ProvinceIndex from '../components/projects/ProvinceIndex'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      redirect: '/index',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'index',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/city',
          name: 'cityProjects',
          component: CityIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/province',
          name: 'provinceProjects',
          component: ProvinceIndex,
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
    }
  ]
})
