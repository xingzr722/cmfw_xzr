package com.xzr.dao;

import com.xzr.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by F on 2017/10/29.
 */
public interface ArticleDAO {
    public void save(Article article);
    public void update(Article article);
    public List<Article> queryAll();
    public List<Article> queryByPage(@Param("pageNow") Integer pageNow,@Param("pageNum") Integer pageNum);

}
