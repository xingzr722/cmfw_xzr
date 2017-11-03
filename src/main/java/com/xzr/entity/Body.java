package com.xzr.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by F on 2017/11/02.
 */
public class Body {
    private String thumbnail;
    private String title;
    private String author;
    private String type;
    private Integer set_count;
    @JSONField(format = "yyyy-MM-dd")
    private Date create_date;

    public Body() {
    }

    public Body(String thumbnail, String title, String author, String type, Integer set_count, Date create_date) {

        this.thumbnail = thumbnail;
        this.title = title;
        this.author = author;
        this.type = type;
        this.set_count = set_count;
        this.create_date = create_date;
    }

    public String getThumbnail() {

        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSet_count() {
        return set_count;
    }

    public void setSet_count(Integer set_count) {
        this.set_count = set_count;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Body{" +
                "thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", set_count=" + set_count +
                ", create_date=" + create_date +
                '}';
    }
}
