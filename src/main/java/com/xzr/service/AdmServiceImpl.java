package com.xzr.service;

import com.xzr.annotation.LogAnnotation;
import com.xzr.dao.AdmDAO;
import com.xzr.entity.Adm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by F on 2017/10/25.
 */
@Service("admService")
@Transactional
public class AdmServiceImpl implements AdmService {

    @Autowired
    private AdmDAO admDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Adm queryOne(String username) {
        return admDAO.queryOne(username);
    }

    @LogAnnotation(description = "修改管理员密码")
    public void update(Adm adm){
        admDAO.update(adm);
    }

}
