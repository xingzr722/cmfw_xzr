package com.xzr.service;

import com.xzr.annotation.LogAnnotation;
import com.xzr.dao.PictureDAO;
import com.xzr.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by F on 2017/10/25.
 */
@Service("pictureService")
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDAO pictureDAO;

    @LogAnnotation(description = "添加轮播图")
    public void save(Picture picture) {
        picture.setId(UUID.randomUUID().toString().replace("-",""));
        picture.setCreattime(new Date());
        pictureDAO.save(picture);
    }

    @LogAnnotation(description = "修改轮播图状态")
    public void update(Picture picture) {
        pictureDAO.update(picture);
    }

    public void delete(String id){
        pictureDAO.delete(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Picture> queryAll() {
        return pictureDAO.queryAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Picture> queryPage(Integer page, Integer rows) {
        Integer begin=(page-1)*rows;
        return pictureDAO.queryPage(begin,rows);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer count() {
        return pictureDAO.count();
    }
}
