package com.xzr.controller;

import com.xzr.entity.Province;
import com.xzr.entity.User;
import com.xzr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by F on 2017/10/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        userService.update(user);
        return "y";
    }

    /**
     * 分页
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<User> users = userService.queryAll();
        int size = users.size();
        List<User> user = userService.queryByPage(page, rows);
        map.put("total",size);
        map.put("rows",user);
        //System.out.println("===="+map);
        return map;
    }

    /**
     * 查询所有
     */
    @RequestMapping("/find")
    @ResponseBody
    public List<User> find(){
        List<User> users = userService.queryAll();

        return users;
    }

    /**
     * 查询用户分布地区
     */
    @RequestMapping("/province")
    @ResponseBody
    public List<Province> province(){
        List<Province> provinces = userService.queryByProvince();
        return provinces;
    }

    /**
     * 查询一周内，两周内，三周内，注册的用户
     */
    @RequestMapping("/usernum")
    @ResponseBody
    public List<Integer> usernum(){
        Integer one = userService.queryByUserNum(7);
        Integer two = userService.queryByUserNum(14);
        Integer three = userService.queryByUserNum(21);
        /*HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("第一周",one);
        map.put("第二周",two);
        map.put("第三周",three);*/
        List<Integer> list = new ArrayList<Integer>();
        list.add(one);
        list.add(two);
        list.add(three);
        return list;
    }
}
