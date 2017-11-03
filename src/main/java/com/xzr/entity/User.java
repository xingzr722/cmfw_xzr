package com.xzr.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.text.Format;
import java.util.Date;

/**
 * Created by F on 2017/10/30.
 */
public class User {
    private String id;
    private String password;
    private String farmington;//法名
    private String nickname;//昵称
    private String gender;//性别
    private String photo;//头像
    private String location;//所在地
    private String province;//省市
    private String city;//地区
    private String description;//个人签名
    private String phone;//手机号
    private String status;//用户状态;
    @JSONField(format = "yyyy-MM-dd")
    private Date creattime;
    private Guru guru;

    public User() {
    }

    public User(String id, String password, String farmington, String nickname, String gender, String photo, String location, String province, String city, String description, String phone, String status, Date creattime) {

        this.id = id;
        this.password = password;
        this.farmington = farmington;
        this.nickname = nickname;
        this.gender = gender;
        this.photo = photo;
        this.location = location;
        this.province = province;
        this.city = city;
        this.description = description;
        this.phone = phone;
        this.status = status;
        this.creattime = creattime;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFarmington() {
        return farmington;
    }

    public void setFarmington(String farmington) {
        this.farmington = farmington;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", farmington='" + farmington + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", creattime=" + creattime +
                ", guru=" + guru +
                '}';
    }
}
