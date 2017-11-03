package com.xzr.service;

import com.xzr.annotation.LogAnnotation;
import com.xzr.dao.UserDAO;
import com.xzr.entity.Province;
import com.xzr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by F on 2017/10/30.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @LogAnnotation(description = "修改用户状态")
    public void update(User user) {
        userDAO.update(user);
    }

    public List<User> queryAll() {
        return userDAO.queryAll();
    }

    public List<User> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow = (pageNow-1)*pageNum;
        //System.out.println("this is pageNow==="+pageNow);
        //System.out.println("this is pageNum==="+pageNum);
        return userDAO.queryByPage(pageNow,pageNum);
    }

    public List<Province> queryByProvince() {
        return userDAO.queryByProvince();
    }

    public Integer queryByUserNum(Integer num) {
        return userDAO.queryByUserNum(num);
    }
}
