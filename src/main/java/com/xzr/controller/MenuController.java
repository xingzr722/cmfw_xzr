package com.xzr.controller;

import com.xzr.entity.Menu;
import com.xzr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by F on 2017/10/24.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(){
       // System.out.println("进入方法···");
        List<Menu> menus = menuService.queryAll();
        //System.out.println("========="+menus);
        return menus;
    }
}
