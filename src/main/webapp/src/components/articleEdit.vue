<template>
	<div class="index">
    <sunHeader></sunHeader>
		<el-main>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>添加文章</span>
        </div>
        <el-radio-group v-model="labelPosition" size="small">
          <el-radio-button label="left">左对齐</el-radio-button>
          <el-radio-button label="right">右对齐</el-radio-button>
          <el-radio-button label="top">顶部对齐</el-radio-button>
        </el-radio-group>
        <div style="margin: 20px;"></div>
        <el-form :label-position="labelPosition" label-width="80px" :model="form" style="border:0">
          <el-form-item label="文章标题">
            <el-input v-model="form.title"></el-input>
          </el-form-item>
          <el-form-item label="文章标签">
            <el-input v-model="form.tag"></el-input>
          </el-form-item>
          <el-form-item label="文章正文">
            <mavon-editor v-model="form.context" :toolbars="toolbars" @keydown="" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">提交</el-button>
            <!--<el-button @click="cancel">取消</el-button>-->
          </el-form-item>
        </el-form>
      </el-card>
		</el-main>
	</div>
</template>
<script>
  import sunHeader from './common/sunHeader'
  export default {
    data() {
      return {
        labelPosition: 'left',
        form:{
          id:null,
          context: '',
          tag: '',
          title: ''
        },
        toolbars: {
          bold: true, // 粗体
          italic: true, // 斜体
          header: true, // 标题
          underline: true, // 下划线
          mark: true, // 标记
          superscript: true, // 上角标
          quote: true, // 引用
          ol: true, // 有序列表
          link: true, // 链接
          imagelink: true, // 图片链接
          help: true, // 帮助
          code: true, // code
          subfield: true, // 是否需要分栏
          fullscreen: true, // 全屏编辑
          readmodel: true, // 沉浸式阅读
          /* 1.3.5 */
          undo: true, // 上一步
          trash: true, // 清空
          save: true, // 保存（触发events中的save事件）
          /* 1.4.2 */
          navigation: true // 导航目录
        }
      };
    },
    created(){
      this.getParams()
    },
    components:{
      sunHeader
    },
    methods: {
      onSubmit: function () {
        this.$post('/api/article/articleEdit',this.form,true)
        .then((res) => {
        })
      },
      // cancel : function () {
      //   this.form = null;
      // },
      getParams () {
        var routerParams = this.$route.params.id
        if(routerParams != null){
          this.$fetch('/api/article/articleInfo',{id:routerParams},false)
          .then((res) => {
            console.log(res.data.articleInfo)
            if(res.data != null){
              this.form = res.data.articleInfo
            }
          })
        }
      }
    },
    watch: {
      '$route': 'getParams'
    }
  }
</script>
