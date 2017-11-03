package com.xzr.controller;

import com.xzr.entity.Album;
import com.xzr.service.AlbumService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by F on 2017/10/27.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile photo, Album album, HttpServletRequest request) throws IOException {
        //获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/audio");
        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
        photo.transferTo(new File(realPath,newFileName));
        album.setImgPath(newFileName);
        List<Album> albums = albumService.queryAll();
        album.setSetCount(albums.size());
        albumService.save(album);
        return "y";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Album album){
        albumService.update(album);
        return "y";
    }

    /**
     * 分页
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Album> albums = albumService.queryAll();
        int size = albums.size();
        List<Album> album = albumService.queryByPage(page, rows);
        map.put("total",size);
        map.put("rows",album);
        return map;
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/find")
    @ResponseBody
    public List<Album> find(){
        List<Album> albums = albumService.queryAll();
        //System.out.println(albums);
        return albums;
    }
}
