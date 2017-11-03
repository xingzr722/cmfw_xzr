package com.xzr.controller;

import com.aliyuncs.exceptions.ClientException;
import com.xzr.entity.*;
import com.xzr.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by F on 2017/11/02.
 */
@Controller
@RequestMapping("/interface")
public class InterfaceController {

    @Autowired
    private MainService mainService;

    @RequestMapping("/pictures")
    @ResponseBody
    public Object prictures(String type){
        if(type.equals("all")){
            List<Picture> pictures = mainService.queryAllPicture();
            List<Album> albums = mainService.queryAllAlbum();
            List<Article> articles = mainService.queryAllArticle();
            HashMap<String, Object> map = new HashMap<String, Object>();
            List pircturesList = new ArrayList();
            List<Body> list = new ArrayList<Body>();
            for (Picture picture : pictures) {
                Map<String,Object> lunbotu = new HashMap<String,Object>();
                lunbotu.put("thumbnail",picture.getName());
                lunbotu.put("desc",picture.getDescribe());
                lunbotu.put("id",picture.getId());
                pircturesList.add(lunbotu);
            }
            for (Album album : albums) {
                Body b1 = new Body(album.getImgPath(),album.getName(),album.getAuthor(),"0",album.getSetCount(),album.getCreateTime());
                list.add(b1);
            }
            for (Article article : articles) {
                Body b2 = new Body(article.getIllustration(),article.getTitle(),article.getGuru().getName(),"1",null,article.getCreattime());
                list.add(b2);
            }
            map.put("header",pircturesList);
            map.put("body",list);
            return map;
        }else if (type.equals("0")){
            List<Album> albums = mainService.queryAllAlbum();
            HashMap<String, Object> map = new HashMap<String, Object>();
            List<Body> list = new ArrayList<Body>();
            for (Album album : albums) {
                Body b1 = new Body(album.getImgPath(),album.getName(),album.getAuthor(),"0",album.getSetCount(),album.getCreateTime());
                list.add(b1);
            }
            map.put("body",list);
            /*List<Album> albums = mainService.queryAllAlbum();
            HashMap<String, Object> map = new HashMap<String, Object>();
            List albumList = new ArrayList();
            for (Album album : albums) {
                Map<String,Object> zhuanji = new HashMap<String,Object>();
                zhuanji.put("thumbnail",album.getImgPath());
                zhuanji.put("title",album.getName());
                zhuanji.put("author",album.getAuthor());
                zhuanji.put("type",type);
                zhuanji.put("set_count",album.getSetCount());
                zhuanji.put("create_date",album.getCreateTime());
                albumList.add(zhuanji);
            }
            map.put("body",albumList);*/
            return map;
        }else if(type.equals("1")){
            List<Article> articles = mainService.queryAllArticle();
            HashMap<String, Object> map = new HashMap<String, Object>();
            List<Body> list = new ArrayList<Body>();
            for (Article article : articles) {
                Body b2 = new Body(article.getIllustration(),article.getTitle(),article.getGuru().getName(),"1",null,article.getCreattime());
                list.add(b2);
            }
            map.put("body",list);
            /*List<Article> articles = mainService.queryAllArticle();
            HashMap<String,Object> map = new HashMap<String,Object>();
            List articleList = new ArrayList();
            for (Article article : articles) {
                Map<String,Object> wenzhang = new HashMap<String, Object>();
                wenzhang.put("thumbnail",article.getIllustration());
                wenzhang.put("title",article.getTitle());
                wenzhang.put("author",article.getGuru().getName());
                wenzhang.put("type",type);
                wenzhang.put("set_count","");
                wenzhang.put("create_date",article.getCreattime());
                articleList.add(wenzhang);
            }
            map.put("body",articleList);*/
            return map;
        }
        return null;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String phone,String password){
        User user = mainService.queryByPhone(phone);
        if(user.getPhone()!=null && user.getPhone()!=""){
            if(user.getPassword().equals(password)){
                return "";
            }
        }
        return null;
    }

    @RequestMapping("/message")
    @ResponseBody
    public void sendmessage(String phoneNum) throws ClientException {
        System.out.println("进入方法");
        mainService.sendMessage(phoneNum);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,String> save(String phoneNum,String code){
        Map<String, String> save = mainService.save(phoneNum, code);
        return save;
    }
}
