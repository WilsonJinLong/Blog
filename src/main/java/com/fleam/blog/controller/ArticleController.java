package com.fleam.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fleam.base.annotation.CheckToken;
import com.fleam.base.util.ResponseData;
import com.fleam.blog.entity.Article;
import com.fleam.blog.service.IArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章列表 前端控制器
 * </p>
 *
 * @author wzd
 * @since 2018-12-26
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    //修改文章
    @CheckToken
    @ResponseBody
    @PostMapping("/articleEdit")
    public ResponseData articleEdit(@RequestBody Article article) {
        articleService.saveOrUpdate(article);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("msg","编辑成功");
        return responseData;
    }

    //文章列表
    @ResponseBody
    @GetMapping("/articleList")
    public ResponseData articleList(@RequestParam("currentPage") Integer currentPage,
                                    @RequestParam("pageSize") Integer pageSize,
                                    Article article
                                    ) {
        Page<Article> page = new Page<Article>(currentPage,pageSize);
        IPage<Article> articleList = articleService.page(page);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("articleList",articleList);
        return responseData;
    }

    //删除文章
    @CheckToken
    @ResponseBody
    @GetMapping("/articleDel")
    public ResponseData articleDel(@Param("id") Integer id) {
        articleService.removeById(id);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("msg","删除成功");
        return responseData;
    }

    //文章详情
//    @CheckToken
    @ResponseBody
    @GetMapping("/articleInfo")
    public ResponseData articleInfo(@Param("id") Integer id) {
        Article article = articleService.getById(id);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("articleInfo",article);
        return responseData;
    }

}
