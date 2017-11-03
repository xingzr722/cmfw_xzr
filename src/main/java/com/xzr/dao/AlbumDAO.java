package com.xzr.dao;

import com.xzr.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by F on 2017/10/27.
 */
public interface AlbumDAO {
    public void save(Album album);
    public void update(Album album);
    public List<Album> queryAll();
    List<Album> queryByPage(@Param("pageNow") Integer pageNow,@Param("pageNum") Integer pageNum);
}
