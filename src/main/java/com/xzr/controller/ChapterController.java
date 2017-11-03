package com.xzr.controller;

/**
 * Created by F on 2017/10/27.
 */
import com.xzr.entity.Album;
import com.xzr.entity.Chapter;
import com.xzr.service.AlbumService;
import com.xzr.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/27.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(String albumid,MultipartFile singer,String name, HttpServletRequest request) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        String realPath = request.getSession().getServletContext().getRealPath("/audio");
        String extension = FilenameUtils.getExtension(singer.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+
                "."+extension;
        File dest = new File(realPath, newFileName);
        singer.transferTo(dest);

        System.out.println("1");
        //创建一个章节对象
        Chapter chapter = new Chapter();
        //给章节对象赋值name
        chapter.setName(name);
        //给章节对象赋值路径
        chapter.setDownload(newFileName);
        //获取章节大小
        double size =singer.getSize();
        //创建一个专辑对象
        Album album = new Album();
        //给专辑对象赋值id
        album.setId(albumid);
        //给章节对象赋值大小
        chapter.setSize(size);
        chapter.setStatus("播放");
        System.out.println("2");

        /*Clip clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream(dest);
        clip.open(ais);
        String duration = clip.getMicrosecondLength() / 1000000D + " s";
        System.out.println(duration);*/

        chapter.setDuration("999s");
        chapter.setAlbum(album);
        System.out.println("===="+chapter);
        chapterService.save(chapter);
        return "y";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Chapter chapter){
        chapterService.update(chapter);
        return "y";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Chapter> chapters = chapterService.queryAll();
        int size = chapters.size();
        List<Chapter> chapter = chapterService.queryByPage(page, rows);
        map.put("total",size);
        map.put("rows",chapter);
        return map;
    }

    @RequestMapping("/downMusic")
    @ResponseBody
    public String down(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
         /*获取绝对路径*/
        String realPath = request.getRealPath("/audio");
    /*获取输入流*/
        FileInputStream fileInputStream = new FileInputStream(new File(realPath, name));
    /*设置相应头*/
        response.setHeader("Content-Disposition","attchement;filename="+name);

    /*获取文件的mime类型*/
        String contentType = new MimetypesFileTypeMap().getContentType(name);
        //System.out.println(contentType);
    /*设置文件的MIME类型*/
        response.setContentType("text/plain");
    /*获得响应输出流*/
        ServletOutputStream outputStream = response.getOutputStream();
    /*对拷流*/
        IOUtils.copy(fileInputStream, outputStream);
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);

        return "y";
    }
}