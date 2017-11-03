package com.xzr.service;

import com.xzr.entity.Adm;

/**
 * Created by F on 2017/10/25.
 */
public interface AdmService {
    public Adm queryOne(String username);
    public void update(Adm adm);
}
