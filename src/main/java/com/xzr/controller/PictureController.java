package com.xzr.controller;

import com.xzr.entity.PageTable;
import com.xzr.entity.Picture;
import com.xzr.service.PictureService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by F on 2017/10/25.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 添加图片
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile name, HttpSession session,String status,String describe) throws IOException {
        String realPath = session.getServletContext().getRealPath("/imgs");
        //获取文件的原始名称
        String oldname = name.getOriginalFilename();
        //获取文件的后缀
        String suffix = FilenameUtils.getExtension(oldname);
        //修改文件名称
        String newname = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
        //上传操作
        name.transferTo(new File(realPath,oldname));

        Picture picture=new Picture();
        picture.setName(oldname);
        picture.setDescribe(describe);
        picture.setStatus(status);
        pictureService.save(picture);
        return "y";
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Picture picture){
        pictureService.update(picture);
        return "y";
    }


    /**
     *查询所有
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public PageTable<Picture> queryAllPicture(){
        List<Picture> list = pictureService.queryAll();
        Integer count = pictureService.count();
        PageTable<Picture> pageTable=new PageTable<Picture>(count,list);
        return pageTable;
    }

    /**
     * 分页
     */
    @RequestMapping("/fenye")
    @ResponseBody
    public PageTable<Picture> fenye(Integer page,Integer rows) throws IllegalArgumentException, IllegalAccessException, FileNotFoundException, IOException{
        //System.out.println(page+"======="+rows);
        List<Picture> list = pictureService.queryPage(page, rows);
        //System.out.println(list);
        Integer count = pictureService.count();
        PageTable<Picture> pagess=new PageTable<Picture>(count,list);
        return pagess;
    }
}