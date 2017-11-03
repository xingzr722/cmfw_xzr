package com.xzr.controller;

import com.xzr.entity.Guru;
import com.xzr.service.GuruService;
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
 * Created by F on 2017/10/29.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    /**
     * 上传
     * @param photo
     * @param name
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile photo,String name,HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/imgs");
        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
        photo.transferTo(new File(realPath,newFileName));
        Guru guru = new Guru();
        guru.setHeadpic(newFileName);
        guru.setName(name);
        guruService.save(guru);
        return "y";
    }

    /**
     * 分页
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Guru> gurus = guruService.queryAll();
        int size = gurus.size();
        List<Guru> guru = guruService.queryByPage(page, rows);
        map.put("total",size);
        map.put("rows",guru);
        return map;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Guru guru){
        //System.out.println("进入action");
        guruService.update(guru);
        return "y";
    }

    /**
     * 查询所有
     */
    @RequestMapping("/find")
    @ResponseBody
    public List<Guru> find(){
        List<Guru> gurus = guruService.queryAll();
        return gurus;
    }
}
