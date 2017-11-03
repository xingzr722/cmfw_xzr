package com.xzr.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by F on 2017/10/25.
 */
public class Picture implements Serializable {
    private String id;
    private String name;
    private String describe;
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    private Date creattime;

    public Picture() {
    }

    public Picture(String id, String name, String describe, String status, Date creattime) {

        this.id = id;
        this.name = name;
        this.describe = describe;
        this.status = status;
        this.creattime = creattime;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", status='" + status + '\'' +
                ", creattime=" + creattime +
                '}';
    }
}
