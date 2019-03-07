<template>
	<div class="index">
    <sunHeader></sunHeader>
		<el-main>
			<el-card class="box-card">
				<div slot="header" class="clearfix">
					<span>文章列表</span>
					<!--<el-button style="float: right; padding: 3px 0" type="text">添加</el-button>-->
				</div>
				<div class="text item">
          <!--<el-table :data="articleList.slice((currentPage-1)*pageSizes,currentPage*pageSizes)" style="width: 100%">-->
					<el-table :data="articleList" style="width: 100%">
						<el-table-column prop="id" label="文章ID" width="180">
						</el-table-column>
						<el-table-column prop="title" label="文章标题" width="180">
						</el-table-column>
						<el-table-column prop="tag" label="文章标签" width="180">
						</el-table-column>
						<el-table-column prop="createTime" label="发布时间">
						</el-table-column>
						<el-table-column fixed="right" label="操作" width="100">
							<template slot-scope="scope">
								<el-button @click="handleEdit(scope.row.id)" type="text" size="small">修改</el-button>
								<el-button @click="handleDel(scope.row.id)" type="text" size="small">删除</el-button>
							</template>
						</el-table-column>
					</el-table>

          <div class="block" style="margin-top:30px">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage"
              :page-sizes="[5, 10, 20, 40]"
              :page-size="pageSizes"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </div>

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
        currentPage:1,
        pageSizes:10,
        total:0,
        articleList: []
      }
    },
    components:{
      sunHeader
    },
    methods: {
      handleEdit: function (id) {
        this.$router.push({
          path:'/articleEdit',
          name:'articleEdit',
          params:{id:id}
        })
      },
      handleDel: function (id) {
        this.$fetch('/api/article/articleDel',{id},true)
        .then((res) => {
          this.handleArticleList();
        })
      },
      handleSizeChange: function (pageSizes) {
        this.pageSizes = pageSizes;
        this.handleArticleList();
      },
      handleCurrentChange: function(currentPage){
        this.currentPage = currentPage;
        this.handleArticleList();
      },
      handleArticleList() {
        this.$fetch('/api/article/articleList',{
            currentPage:this.currentPage,
            pageSize:this.pageSizes
        },false)
        .then((res) => {
          this.articleList = res.data.articleList.records;
          this.total = res.data.articleList.total;
          this.pageSizes = res.data.articleList.size;
          this.currentPage = res.data.articleList.current;
        })
      }
    },
    created:function(){
      this.handleArticleList()
    }
  }
</script>
