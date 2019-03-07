<template>
	<div class="index">
		<el-container style="height: 500px; border: 1px solid #eee">

			<!--左侧导航-->
			<el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-card class="box-card" style="background: #333;color:white;border:0px">
            <span> <li class="el-icon-setting" style="font-size:20px;margin-right: 10px"></li></span>
            SunRain
        </el-card>
				<el-menu  router background-color="#545c64" text-color="#fff">
					<el-submenu index="1">
						<template slot="title"><i class="el-icon-message"></i>账号管理</template>
						<el-menu-item index="userList">账号列表</el-menu-item>
						<el-menu-item index="passwordEdit">修改密码</el-menu-item>
					</el-submenu>
					<el-submenu index="2">
						<template slot="title"><i class="el-icon-menu"></i>文章管理</template>
						<el-menu-item index="articleEdit">添加文章</el-menu-item>
            <el-menu-item index="articleList">文章列表</el-menu-item>
					</el-submenu>
				</el-menu>
			</el-aside>

			<!--右侧内容-->
			<el-container>
				<router-view></router-view>
			</el-container>

		</el-container>
	</div>
</template>
