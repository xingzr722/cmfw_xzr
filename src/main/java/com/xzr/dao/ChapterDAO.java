package com.xzr.dao;

import com.xzr.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by F on 2017/10/27.
 */
public interface ChapterDAO {
    public void save(Chapter chapter);
    public void update(Chapter chapter);
    public List<Chapter> queryAll();
    List<Chapter> queryByPage(@Param("pageNow") Integer pageNow,@Param("pageNum") Integer pageNum);
}
