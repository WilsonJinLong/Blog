import router from '../router'
import store from '../vuex/store'

export default class myUtils {

  /**
   * 退出登陆
   */
  static loginOut() {
    store.commit('SAVE_USERINFO',null)
    router.push('/login')
  }

  /**
   * 判断字符串是否为空
   * @param str
   * @returns {boolean}
   */
  static isNull(str) {
    return str == null || str.length === 0 || str === '';
  }

  /**
   *
   * @desc  判断是否为身份证号
   * @param  {String|Number} str
   * @return {Boolean}
   */
  static isIdCard(str) {
    return /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/.test(str)
  }

  /**
   *
   * @desc   判断是否为手机号
   * @param  {String|Number} str
   * @return {Boolean}
   */
  static isPhoneNum(str) {
    return /^(0|86|17951)?(1[3-9][0-9])[0-9]{8}$/.test(str)
  }



}
