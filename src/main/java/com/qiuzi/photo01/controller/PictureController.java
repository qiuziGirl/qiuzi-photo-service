package com.qiuzi.photo01.controller;

import com.qiuzi.photo01.bean.Picture;
import com.qiuzi.photo01.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureController.class);

    /**
     * 上传照片
     * @param file
     * @return
     */
    @PostMapping("/uploadPicture")
    @ResponseBody
    public int uploadPicture(@RequestParam("file")MultipartFile file, @RequestParam("select") String id) {

        if (file.isEmpty()) {
            return 0;
        }
        
        Picture picture = new Picture();

        // 生成图片时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf01 = new SimpleDateFormat("hh-MM-ss");
        String res = sdf.format(new Date());
        String res01 = sdf01.format(new Date());
        // 获取文件原始名称
        String originalFileName = file.getOriginalFilename();
        // 获取文件后缀名
        String suffixName = originalFileName.substring(originalFileName.lastIndexOf("."));
        // 更改文件名， 格式： yyyy-MM-dd + UUID + 文件后缀名
//        String newFileName = res + "_" + UUID.randomUUID() + suffixName;
        String newFileName = res + "_" + res01 + suffixName;
        // 上传的位置
        String filePath = "E://IDEA//photo01//src//main//resources//static//img/";
        File dest = new File(filePath + newFileName);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }

        picture.setPictureName(newFileName);
        picture.setAlbumId(parseInt(id));
        picture.setCreateTime(new Timestamp(System.currentTimeMillis()));
        picture.setStoragePath(filePath);

        if (pictureService.insertPicture(picture) == 1) {
            LOGGER.info("上传成功");
            return 1;
        }
        return 0;
    }

    /**
     * 根据相册id查找照片
     * @param albumId
     * @return
     */
    @PostMapping("/findAllPicture")
    @ResponseBody
    public List<Picture> findAllPicture(Integer albumId) {
        return pictureService.findAllPicture(albumId);
    }

    /**
     * 根据照片 id 删除照片
     * @param id
     * @return
     */
    @RequestMapping("/deletePictureById")
    @ResponseBody
    public int deletePictureById(Integer id) {
        return pictureService.deletePictureById(id);
    }

}
