<template>
	<div class="index">
    <sunHeader></sunHeader>
		<el-main>
			<el-card class="box-card">
				<div slot="header" class="clearfix">
					<span>用户账号列表</span>
					<!--<el-button style="float: right; padding: 3px 0" type="text">添加</el-button>-->
				</div>
				<div class="text item">
					<el-table :data="tableData" style="width: 100%">
						<el-table-column prop="username" label="账号" width="180">
						</el-table-column>
						<el-table-column prop="realname" label="实名" width="180">
						</el-table-column>
						<el-table-column prop="age" label="年龄" width="180">
						</el-table-column>
						<el-table-column prop="idCode" label="证件号">
						</el-table-column>
						<!--<el-table-column fixed="right" label="操作" width="100">-->
							<!--<template slot-scope="scope">-->
								<!--<el-button @click="handleEdit(scope.row.id)" type="text" size="small">修改</el-button>-->
								<!--<el-button @click="handleDel(scope.row.id)" type="text" size="small">删除</el-button>-->
							<!--</template>-->
						<!--</el-table-column>-->
					</el-table>
				</div>
			</el-card>
		</el-main>
	</div>
</template>

<script>
  import sunHeader from './common/sunHeader'
  export default {
    data () {
      return {
        tableData: [],
      }
    },
    components:{
      sunHeader
    },
    created:function(){
      this.$fetch('/api/user/userList',{},false)
      .then((res) => {
        this.tableData = res.data.userList
      })
    }
  }
</script>
