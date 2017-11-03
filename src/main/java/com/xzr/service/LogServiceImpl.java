package com.xzr.service;

import com.xzr.dao.LogDAO;
import com.xzr.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by F on 2017/10/30.
 */
@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;

    public void save(Log log) {
        log.setId(UUID.randomUUID().toString().replace("-",""));
        logDAO.save(log);
    }

    public void update(Log log) {

    }

    public List<Log> queryAll() {
        return logDAO.queryAll();
    }

    public List<Log> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow = (pageNow-1)*pageNum;
        return logDAO.queryByPage(pageNow,pageNum);
    }
}
