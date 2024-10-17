package com.qiuzi.photo01.controller;

import com.qiuzi.photo01.bean.Album;
import com.qiuzi.photo01.service.AlbumService;
import com.qiuzi.photo01.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PictureService pictureService;

    /**
     * 跳转相册详情页面
     * @param model
     * @return
     */
    @RequestMapping("album_detail/{albumId}")
    public String album_detail(@PathVariable("albumId") Integer albumId, Model model) {
        model.addAttribute("pictures", pictureService.findAllPicture(albumId));
        model.addAttribute("albumId", albumId);
        return "album_detail";
    }

    /**
     * 创建相册
     *
     * @param album
     * @return
     */
    @RequestMapping("/createAlbum")
    @ResponseBody
    public int createAlbum(Album album) {
        return albumService.insertAlbum(album);
    }

    /**
     * 删除相册
     *
     * @param id
     */
    @RequestMapping("/deleteAlbum")
    @ResponseBody
    public int deleteAlbum(Integer id) {
        return albumService.deleteAlbum(id);
    }

    /**
     * 更新相册信息
     *
     * @param album
     * @return
     */
    @RequestMapping("/updateAlbum")
    @ResponseBody
    public int updateAlbum(Album album) {
        return albumService.updateAlbum(album);
    }

    /**
     * 根据用户id查询用户所有相册
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Album> findAll(int userId) {
        List<Album> albums = albumService.findAll(userId);
        return albums;
    }

    /**
     * 根据相册名查找相册
     *
     * @param albumName
     * @return
     */
    @RequestMapping("/findAlbumByAlbumName")
    @ResponseBody
    public Album findAlbumByAlbumName(String albumName) {
        Album album = albumService.findAlbumByAlbumName(albumName);
        return album;
    }

    /**
     * 根据id获取相册信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findAlbumByAlbumId")
    @ResponseBody
    public Album findAlbumByAlbumId(Integer id) {
        Album album = albumService.findAlbumByAlbumId(id);
        return album;
    }

    /**
     * 根据相册 id 获取相片数量
     * @param id
     * @return
     */
    @RequestMapping("/countByAlbumId")
    @ResponseBody
    public int countByAlbumId(Integer id) {
        return albumService.countByAlbumId(id);
    }

}
