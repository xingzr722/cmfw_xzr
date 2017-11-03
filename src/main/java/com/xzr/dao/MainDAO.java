package com.xzr.dao;

import com.xzr.entity.Album;
import com.xzr.entity.Article;
import com.xzr.entity.Picture;
import com.xzr.entity.User;

import java.util.List;

/**
 * Created by F on 2017/11/02.
 */
public interface MainDAO {

    public List<Picture> queryAllPicture();

    public List<Album> queryAllAlbum();

    public List<Article> queryAllArticle();

    public User queryByPhone(String phone);


}
