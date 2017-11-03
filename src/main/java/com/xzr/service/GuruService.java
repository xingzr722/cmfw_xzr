package com.xzr.service;

import com.xzr.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by F on 2017/10/29.
 */
public interface GuruService {
    public void save(Guru guru);
    public void update(Guru guru);
    public List<Guru> queryAll();
    public List<Guru> queryByPage(@Param("pageNow") Integer pageNow, @Param("pageNum") Integer pageNum);
}
