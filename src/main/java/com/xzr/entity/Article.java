package com.xzr.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by F on 2017/10/29.
 */
public class Article {
    private String id;
    private String title;
    @JSONField(format = "yyyy-MM-dd")
    private Date creattime;
    private String link;
    private String ext;
    private String text;
    private String illustration;
    private Guru guru;

    public Article() {
    }

    public Article(String id, String title, Date creattime, String link, String ext, String text, String illustration) {

        this.id = id;
        this.title = title;
        this.creattime = creattime;
        this.link = link;
        this.ext = ext;
        this.text = text;
        this.illustration = illustration;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", creattime=" + creattime +
                ", link='" + link + '\'' +
                ", ext='" + ext + '\'' +
                ", text='" + text + '\'' +
                ", illustration='" + illustration + '\'' +
                ", guru=" + guru +
                '}';
    }
}
