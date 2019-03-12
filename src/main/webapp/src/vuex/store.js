import Vue from 'vue';
import Vuex from 'vuex';
import getters from '../vuex/getters';

Vue.use(Vuex)

const state ={
  data:JSON.parse(localStorage.getItem('data'))
}

const mutations = {
	SAVE_USERINFO(state,data){
		localStorage.setItem('data',JSON.stringify(data))
    state.data = data
	}
}
export default new Vuex.Store({
	state,
	mutations,
  getters
})
