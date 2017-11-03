package com.xzr.service;

import com.xzr.annotation.LogAnnotation;
import com.xzr.dao.GuruDAO;
import com.xzr.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by F on 2017/10/29.
 */
@Service("guruService")
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDAO guruDAO;

    @LogAnnotation(description = "添加上师")
    public void save(Guru guru) {
        guru.setId(UUID.randomUUID().toString().replace("-",""));
        guru.setStatus("可拜师");
        guruDAO.save(guru);
    }

    @LogAnnotation(description = "修改上师状态")
    public void update(Guru guru) {
        guruDAO.update(guru);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> queryAll() {
        return guruDAO.queryAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow = (pageNow-1)*pageNum;
        //System.out.println("this is pageNow==="+pageNow);
        //System.out.println("this is pageNum==="+pageNum);
        return guruDAO.queryByPage(pageNow,pageNum);
    }
}
