package com.xzr.controller;

import com.xzr.entity.Log;
import com.xzr.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by F on 2017/10/30.
 */
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Log log) {
        logService.save(log);
        return "y";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String, Object> findAll(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Log> logs = logService.queryAll();
        int size = logs.size();
        List<Log> log = logService.queryByPage(page, rows);
        map.put("total", size);
        map.put("rows", log);
        return map;
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<Log> find(){
        List<Log> logs = logService.queryAll();
        //System.out.println(albums);
        return logs;
    }
}