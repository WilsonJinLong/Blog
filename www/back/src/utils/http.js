import axios from 'axios';
import { Message } from 'element-ui';
import store from '../vuex/store'
import { Notification } from 'element-ui';
import myUtils from './common'

axios.defaults.timeout = 5000;
axios.defaults.baseURL ='';

//http request 拦截器
axios.interceptors.request.use(
  config => {
    // const token = getCookie('名称');注意使用的时候需要引入cookie方法，推荐js-cookie
    config.data = JSON.stringify(config.data);
    if("/api/user/login" != config.url){
      config.headers = {
        'Content-Type':'application/json',
        'token':store.getters.isLogin.token
      }
    }else{
      config.headers = {
        'Content-Type':'application/json'
      }
    }
    // if(token){
    //   config.params = {'token':token}
    // }
    return config;
  },
  error => {
    return Promise.reject(err);
  }
);

//http response 拦截器
axios.interceptors.response.use(
  response => {
    // console.log(response.data.code);
    if(response.data.code ==400){
      myUtils.loginOut()
    }
    return response;
  },
  error => {
    return Promise.reject(error)
  }
)

/**
 * 提示
 */
function message(response,notify){
  // console.log(response);
  // console.log(response.data.code);
  // console.log(response.data.data.msg);
  if(notify){
    if(response.data.code === 400){
      Notification.error({
        title: '错误',
        message: response.data.data.msg,
        type: 'warning'
      });
    }
    if(response.data.code === 200){
      Notification({
        title: '成功',
        message: response.data.data.msg,
        type: 'success'
      });
    }
  }
}


/**
 * 封装get方法
 * @param url
 * @param data
 * @returns {Promise}
 */
export function fetch(url,params={},notify){
  return new Promise((resolve,reject) => {
    axios.get(url,{
      params:params
    })
      .then(response => {
        message(response,notify);
        resolve(response.data);
      })
      .catch(err => {
        reject(err)
      })
  })
}

/**
 * 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */
export function post(url,data = {},notify){
  return new Promise((resolve,reject) => {
    axios.post(url,data)
      .then(response => {
        message(response,notify);
        resolve(response.data);
      },err => {
        reject(err)
      })
  })
}

/**
 * 封装patch请求
 * @param url
 * @param data
 * @returns {Promise}
 */
export function patch(url,data = {},notify){
  return new Promise((resolve,reject) => {
    axios.patch(url,data)
      .then(response => {
        message(response,notify);
        resolve(response.data);
      },err => {
        reject(err)
      })
  })
}

/**
 * 封装put请求
 * @param url
 * @param data
 * @returns {Promise}
 */
export function put(url,data = {},notify){
  return new Promise((resolve,reject) => {
    axios.put(url,data)
      .then(response => {
        message(response,notify);
        resolve(response.data);
      },err => {
        reject(err)
      })
  })
}
