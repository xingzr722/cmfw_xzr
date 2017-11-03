package com.xzr.dao;

import com.xzr.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by F on 2017/10/25.
 */
public interface PictureDAO {
    public void save(Picture picture);
    public void delete(String id);
    public void update(Picture picture);
    public List<Picture> queryAll();

    public List<Picture> queryPage(@Param ("begin")Integer begin,@Param ("end") Integer end);
    public Integer count();
}
