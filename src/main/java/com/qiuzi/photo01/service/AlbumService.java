package com.qiuzi.photo01.service;

import com.qiuzi.photo01.bean.Album;

import java.util.List;

public interface AlbumService {

    /**
     * 创建相册
     * @param album
     * @return
     */
    int insertAlbum(Album album);

    /**
     * 删除相册
     * @param id
     */
    int deleteAlbum(Integer id);

    /**
     * 更新相册信息
     * @param album
     * @return
     */
    int updateAlbum(Album album);

    /**
     * 查询用户所有相册
     * @return
     */
    List<Album> findAll(Integer userId);

    /**
     * 根据相册名查找相册
     * @param albumName
     * @return
     */
    Album findAlbumByAlbumName(String albumName);

    /**
     * 根据id获取相册信息
     * @param id
     * @return
     */
    Album findAlbumByAlbumId(Integer id);

    /**
     * 根据相册 id 获取相片数量
     * @param albumId
     * @return
     */
    int countByAlbumId(Integer albumId);

}
