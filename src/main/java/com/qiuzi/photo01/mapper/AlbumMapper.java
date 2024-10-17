package com.qiuzi.photo01.mapper;

import com.qiuzi.photo01.bean.Album;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AlbumMapper {

    /**
     * 增加相册
     * @param album
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into album(user_id, album_name, album_description, create_time) values (#{userId}, #{albumName}, #{albumDescription},  #{createTime})")
    int insertAlbum(Album album);

    /**
     * 根据相册id删除相册
     * @param id
     */
    @Delete("delete from album where id = #{id}")
    int deleteAlbum(Integer id);

    /**
     * 根据相册id更改相册名字、描述
     * @param album
     * @return
     */
    @Update("update album set album_name=#{albumName}, album_description=#{albumDescription} where id = #{id}")
    int updateAlbum(Album album);

    /**
     * 根据相册名查找相册
     * @param albumName
     * @return
     */
    @Select("select * from album where album_name = #{albumName}")
    Album findAlbumByAlbumName(String albumName);

    /**
     * 根据id获取相册信息
     * @param id
     * @return
     */
    @Select("select * from album where id = #{id}")
    Album findAlbumByAlbumId(Integer id);

    /**
     * 根据用户id查询其所有相册
     * @param userId
     * @return
     */
    @Select("select * from album where user_id = #{userId}")
    List<Album> findAll(Integer userId);

    /**
     * 根据相册 id 获取相片数量
     * @param albumId
     * @return
     */
    @Select("select count(id) from picture where album_id = #{albumId} ")
    int countByAlbumId(Integer albumId);

}
