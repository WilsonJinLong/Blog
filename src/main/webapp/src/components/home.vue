<template>
	<div class="index">
    <sunHeader></sunHeader>
		<el-main>
			<el-card class="box-card">
				<div slot="header" class="clearfix">
					<span>用户信息卡</span>
				</div>
				<div class="text item">
					<p>用户账号：{{data.user.username}}</p>
					<p>用户实名：{{data.user.realname}}</p>
					<p>用户密码：{{data.user.password}}</p>
					<p>证件号码：{{data.user.idCode}}</p>
				</div>
			</el-card>
		</el-main>
	</div>
</template>

<script>
	import { mapState } from 'vuex'
  import sunHeader from './common/sunHeader'
	export default {
		data() {
			return {}
		},
		computed: {
			...mapState({
				data: state => state.data
			})
		},
    components:{
      sunHeader
    }
	}
</script>
