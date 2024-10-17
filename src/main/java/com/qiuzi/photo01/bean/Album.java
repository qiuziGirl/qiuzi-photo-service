package com.qiuzi.photo01.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Album implements Serializable {

    private Integer id;
    private Integer userId;
    private String albumName;
    private String albumDescription;
    private Integer albumAmount;
    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public Integer getAlbumAmount() {
        return albumAmount;
    }

    public void setAlbumAmount(Integer albumAmount) {
        this.albumAmount = albumAmount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", userId=" + userId +
                ", albumName='" + albumName + '\'' +
                ", albumDescription='" + albumDescription + '\'' +
                ", albumAmount=" + albumAmount +
                ", createTime=" + createTime +
                '}';
    }
}
