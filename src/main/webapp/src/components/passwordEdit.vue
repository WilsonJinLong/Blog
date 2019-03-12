<template>
	<div class="index">
    <sunHeader></sunHeader>
		<el-main>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>修改密码</span>
        </div>
        <el-radio-group v-model="labelPosition" size="small">
          <el-radio-button label="left">左对齐</el-radio-button>
          <el-radio-button label="right">右对齐</el-radio-button>
          <el-radio-button label="top">顶部对齐</el-radio-button>
        </el-radio-group>
        <div style="margin: 20px;"></div>
        <el-form :label-position="labelPosition" label-width="80px" :model="form" style="border:0">
          <el-form-item label="原始密码">
            <el-input v-model="form.oldPassword"></el-input>
          </el-form-item>
          <el-form-item label="新密码">
            <el-input v-model="form.newPassword"></el-input>
          </el-form-item>
          <el-form-item label="重复密码">
            <el-input v-model="form.rePassword"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <el-button @click="cancel">取消</el-button>
          </el-form-item>
        </el-form>
      </el-card>
		</el-main>
	</div>
</template>
<script>
  import { mapState } from 'vuex'
  import sunHeader from './common/sunHeader'
  export default {
    data() {
      return {
        labelPosition: 'left',
        form: {
          oldPassword: '',
          newPassword: '',
          rePassword: ''
        }
      };
    },
    computed: {
      ...mapState({
        data: state => state.data
      })
    },
    components:{
      sunHeader
    },
    methods: {
      onSubmit: function () {
        this.form.id = this.data.user.id;
        this.$post('/api/user/passwordEdit',this.form,true)
        .then((res) => {
        })
      },
      cancel : function () {
        this.form.oldPassword = "";
        this.form.newPassword = "";
        this.form.rePassword = "";
      }
    }
  }
</script>
