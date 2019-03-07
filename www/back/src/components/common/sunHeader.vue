<template>
  <el-header style="text-align: right;">
    <el-dropdown>
      <i class="el-icon-menu" style="margin-right: 15px; font-size: 20px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click.native="userInfo">个人信息</el-dropdown-item>
        <el-dropdown-item @click.native="loginOut">退出系统</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
    <span>
    {{data.user.username}}
  </span>
  </el-header>
</template>

<script>
  import { mapState } from 'vuex'
  export default {
    name:"sunHeader",
    computed: {
      ...mapState({
        data: state => state.data
      })
    },
    methods: {
      userInfo: function () {
        this.$router.push('/')
      },
      loginOut: function () {
        this.myUtils.loginOut()
      }
    }
  }
</script>
