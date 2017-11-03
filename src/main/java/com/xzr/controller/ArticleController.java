package com.xzr.controller;

import com.xzr.entity.Article;
import com.xzr.entity.Guru;
import com.xzr.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by F on 2017/10/29.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile image,String guruid,String title, String text, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/imgs");
        String extension = FilenameUtils.getExtension(image.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
        image.transferTo(new File(realPath,newFileName));
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        article.setIllustration(newFileName);
        article.setLink("66666");
        article.setExt("sssss");
        Guru guru = new Guru();
        guru.setId(guruid);
        article.setGuru(guru);
        articleService.save(article);
        return "y";
    }

    /**
     * 分页
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Article> articles = articleService.queryAll();
        int size = articles.size();
        List<Article> article = articleService.queryByPage(page, rows);
        map.put("total",size);
        map.put("rows",article);
        //System.out.println("====="+map);
        return map;
    }

    /**
     * 查询所有
     */
    @RequestMapping("/find")
    @ResponseBody
    public List<Article> find(){
        List<Article> articles = articleService.queryAll();
        return articles;
    }
}
