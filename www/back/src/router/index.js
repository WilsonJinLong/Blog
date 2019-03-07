import Vue from 'vue'
import Router from 'vue-router'
import store from '../vuex/store'
const login = ()=>import('@/components/login')
const index = ()=>import('@/components/index')
const userList = ()=>import('@/components/userList')
const home = ()=>import('@/components/home')
const passwordEdit = ()=>import('@/components/passwordEdit')
const articleEdit = ()=>import('@/components/articleEdit')
const articleList = ()=>import('@/components/articleList')
import {fetch} from '../utils/http'

Vue.use(Router)

const routes =  [
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/',
    name: 'index',
    component: index,
    children:[
      {
        path: '',
        name: 'home',
        component: home
      },
      {
        path: '/userList',
        name: 'userList',
        component: userList
      },
      {
        path: '/passwordEdit',
        name: 'passwordEdit',
        component: passwordEdit
      },
      {
        path: '/articleEdit',
        name: 'articleEdit',
        component: articleEdit
      },
      {
        path: '/articleList',
        name: 'articleList',
        component: articleList
      }
    ]
  }
];

const router = new Router({
  routes
});

router.beforeEach((to, from, next) => {
  if(store.getters.isLogin){
    var exp = store.getters.isLogin.exp;
    var expDate = new Date(exp);
    var nowDate = new Date();
    var times = expDate.getTime()-nowDate.getTime()
    console.log(times)
    if(times < 30000){
      fetch('/api/user/refreshToken')
      .then(response=>{
        console.log(response.data)
        store.commit('SAVE_USERINFO',response.data)
      })
    }
    next()
  }else{
    if(to.fullPath==='/login'){
      next();
    }else{
      next('/login')
    }
  }
})

export default router;

