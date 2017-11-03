package com.xzr.service;

import com.xzr.entity.Province;
import com.xzr.entity.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by F on 2017/10/30.
 */
public interface UserService {
    public void update(User user);
    public List<User> queryAll();
    public List<User> queryByPage(@Param("pageNow")Integer pageNow,@Param("pageNum")Integer pageNum);

    public List<Province> queryByProvince();
    public Integer queryByUserNum(Integer num);
}
