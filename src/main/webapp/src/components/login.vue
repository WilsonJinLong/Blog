<template>
  <div class="login">
		<el-form :model="loginForm" status-icon :rules="rules" ref="loginForm" label-width="100px" class="demo-ruleForm">
			<h1 class="title">
				<li class="el-icon-setting"></li>
        SunRain-登录
      </h1>
			<el-form-item label="账号" prop="username">
				<el-input type="text" v-model="loginForm.username" autocomplete="off"></el-input>
			</el-form-item>	
			<el-form-item label="密码" prop="password">
				<el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
				<el-button @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
		</el-form>
  </div>
</template>

<script>
export default {
	data() {
		return {
			loginForm: {
				username: '',
				password: '',
			},
			rules: {
				username:[
					{ required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 5, max: 18, message: '长度在 5 到 18 个字符', trigger: 'blur' }
				],
				password:[
					{ required: true, message: '请输入用户密码', trigger: 'blur' },
					{ min: 5, max: 18, message: '长度在 5 到 18 个字符', trigger: 'blur' }
				]
			}
		};
	},
	methods: {
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					let _this = this;
					this.axios.post('/api/user/login',{
							username:_this.loginForm.username,
							password:_this.loginForm.password
					})
					.then(response=>{
						console.log("接收后端响应:",response.data)
						if(response.data.code === 200){
						  console.log(response.data.data)
							_this.$store.commit('SAVE_USERINFO',response.data.data)
							_this.$message({
								message: '登录成功',
								type: 'success'
							});
							_this.$router.push('/')
						}else{
							_this.$message({
								message: '登录失败',
								type: 'warning'
							});
						}
					})
				} else {
					console.log('error submit!!');
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
	}
}
</script>

