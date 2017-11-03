package com.xzr.service;

import com.aliyuncs.exceptions.ClientException;
import com.xzr.entity.Album;
import com.xzr.entity.Article;
import com.xzr.entity.Picture;
import com.xzr.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by F on 2017/11/02.
 */
public interface MainService {
    public List<Picture> queryAllPicture();

    public List<Album> queryAllAlbum();

    public List<Article> queryAllArticle();

    public User queryByPhone(String phone);

    public void sendMessage(String phoneNum) throws ClientException;

    public Map<String,String> save(String phoneNum, String code);
}
