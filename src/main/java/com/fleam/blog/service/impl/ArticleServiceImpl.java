package com.fleam.blog.service.impl;

import com.fleam.blog.entity.Article;
import com.fleam.blog.mapper.ArticleMapper;
import com.fleam.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章列表 服务实现类
 * </p>
 *
 * @author wzd
 * @since 2018-12-26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
