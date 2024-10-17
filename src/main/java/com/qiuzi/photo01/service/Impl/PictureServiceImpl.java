package com.qiuzi.photo01.service.Impl;

import com.qiuzi.photo01.bean.Picture;
import com.qiuzi.photo01.mapper.PictureMapper;
import com.qiuzi.photo01.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired(required = false)
    private PictureMapper pictureMapper;

    /**
     * 上传照片
     * @param picture
     * @return
     */
    @Override
    public int insertPicture(Picture picture) {
        try {
            pictureMapper.insertPicture(picture);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    /**
     * 根据相册Id查找所有照片
     * @param albumId
     * @return
     */
    @Override
    public List<Picture> findAllPicture(Integer albumId) {
        return pictureMapper.findAllPicture(albumId);
    }

    /**
     * 根据照片 id 删除照片
     * @param id
     * @return
     */
    @Override
    public int deletePictureById(Integer id) {
        pictureMapper.deletePictureById(id);
        return 0;
    }

}
