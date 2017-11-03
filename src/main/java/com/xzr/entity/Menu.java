package com.xzr.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by F on 2017/10/24.
 */
public class Menu implements Serializable{
    private String id;
    private String name;
    private String icon;
    private String url;
    private String parentid;

    //关系属性
    private List<Menu> children;

    public Menu() {
    }

    public Menu(String id, String name, String icon, String url, String parentid) {

        this.id = id;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.parentid = parentid;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", parentid='" + parentid + '\'' +
                '}';
    }
}
