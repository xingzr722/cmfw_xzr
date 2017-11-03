package com.xzr.service;

import com.xzr.annotation.LogAnnotation;
import com.xzr.dao.ChapterDAO;
import com.xzr.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by F on 2017/10/27.
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;

    @LogAnnotation(description = "添加音频")
    public void save(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString().replace("-",""));
        chapterDAO.save(chapter);
    }

    @LogAnnotation(description = "修改音频状态")
    public void update(Chapter chapter) {
        chapterDAO.update(chapter);
    }

    public List<Chapter> queryAll() {
        return chapterDAO.queryAll();
    }

    public List<Chapter> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow=(pageNow-1)*pageNum;
        return chapterDAO.queryByPage(pageNow,pageNum);
    }
}
