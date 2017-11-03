package com.xzr.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by F on 2017/10/30.
 */
public class Log {
    private String id;
    private String username;
    private String doSomething;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String status;

    public Log() {
    }

    public Log(String id, String username, String doSomething, Date date, String status) {

        this.id = id;
        this.username = username;
        this.doSomething = doSomething;
        this.date = date;
        this.status = status;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoSomething() {
        return doSomething;
    }

    public void setDoSomething(String doSomething) {
        this.doSomething = doSomething;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", doSomething='" + doSomething + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
