package com.qiuzi.photo01.service;

import com.qiuzi.photo01.bean.Picture;

import java.util.List;

public interface PictureService {

    /**
     * 上传照片
     * @param picture
     * @return
     */
    int insertPicture(Picture picture);

    /**
     * 根据相册Id查找所有照片
     * @param albumId
     * @return
     */
    List<Picture> findAllPicture(Integer albumId);

    /**
     * 根据照片 id 删除照片
     * @param id
     * @return
     */
    int deletePictureById(Integer id);
}
