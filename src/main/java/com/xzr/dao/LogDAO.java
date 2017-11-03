package com.xzr.dao;

import com.xzr.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by F on 2017/10/30.
 */
public interface LogDAO {
    public void save(Log log);
    public void update(Log log);
    public List<Log> queryAll();
    public List<Log> queryByPage(@Param("pageNow") Integer pageNow, @Param("pageNum") Integer pageNum);
}
