package com.fleam.serviceauth.service.impl;

import com.fleam.serviceauth.entity.Article;
import com.fleam.serviceauth.mapper.ArticleMapper;
import com.fleam.serviceauth.service.IArticleService;
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
