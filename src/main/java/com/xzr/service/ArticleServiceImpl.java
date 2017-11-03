package com.xzr.service;

import com.xzr.annotation.LogAnnotation;
import com.xzr.dao.ArticleDAO;
import com.xzr.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by F on 2017/10/29.
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    @LogAnnotation(description = "添加文章")
    public void save(Article article) {
            article.setId(UUID.randomUUID().toString().replace("-",""));
            article.setCreattime(new Date());
            articleDAO.save(article);
    }

    @LogAnnotation(description = "修改文章状态")
    public void update(Article article) {
        articleDAO.update(article);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> queryAll() {
        return articleDAO.queryAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow = (pageNow-1)*pageNum;
        //System.out.println("this is pageNow==="+pageNow);
        //System.out.println("this is pageNum==="+pageNum);
        return articleDAO.queryByPage(pageNow,pageNum);
    }
}
