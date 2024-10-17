package com.qiuzi.photo01.service.Impl;

import com.qiuzi.photo01.bean.Album;
import com.qiuzi.photo01.mapper.AlbumMapper;
import com.qiuzi.photo01.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired(required = false)
    private AlbumMapper albumMapper;

    /**
     * 1: 创建相册成功； 0;创建相册失败
     * @param album
     * @return
     */
    @Override
    public int insertAlbum(Album album) {
        Album _album = albumMapper.findAlbumByAlbumName(album.getAlbumName());
        if (_album == null) {
            album.setCreateTime(new Timestamp(System.currentTimeMillis()));
            albumMapper.insertAlbum(album);
            return 1;
        }
        return 0;
    }

    /**
     * 删除相册
     * @param id
     */
    @Override
    public int deleteAlbum(Integer id) {
        albumMapper.deleteAlbum(id);
        return 0;
    }

    /**
     * 更新相册信息
     * @param album
     * @return
     */
    @Override
    public int updateAlbum(Album album) {
       return albumMapper.updateAlbum(album);
    }

    /**
     * 查询用户所有相册
     * @param userId
     * @return
     */
    @Override
    public List<Album> findAll(Integer userId) {
//        PageHelper.startPage(1,10);
        return albumMapper.findAll(userId);
    }

    /**
     * 根据相册名查找相册
     * @param albumName
     * @return
     */
    @Override
    public Album findAlbumByAlbumName(String albumName) {
        return albumMapper.findAlbumByAlbumName(albumName);
    }

    /**
     * 根据id获取相册信息
     * @param id
     * @return
     */
    @Override
    public Album findAlbumByAlbumId(Integer id) {
        return albumMapper.findAlbumByAlbumId(id);
    }

    /**
     * 根据相册 id 获取相片数量
     * @param albumId
     * @return
     */
    @Override
    public int countByAlbumId(Integer albumId) {
        return albumMapper.countByAlbumId(albumId);
    }


}
