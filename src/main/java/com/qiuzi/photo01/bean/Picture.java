package com.qiuzi.photo01.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Picture implements Serializable {

    private Integer id;
    private Integer albumId;
    private String pictureName;
    private String storagePath;
    private Timestamp createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", pictureName='" + pictureName + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
