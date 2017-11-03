package com.xzr.service;

import com.xzr.dao.MenuDAO;
import com.xzr.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by F on 2017/10/24.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDAO menuDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAll() {
        return menuDAO.queryAll();
    }
}
