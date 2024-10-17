package com.qiuzi.photo01.mapper;

import com.qiuzi.photo01.bean.Picture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PictureMapper {

    /**
     * 上传照片
     * @param picture
     * @return
     */
    @Insert("insert into picture(picture_name, album_id, create_time, storage_path) values (#{pictureName}, #{albumId}, #{createTime}, #{storagePath})")
    int insertPicture(Picture picture);

    /**
     * 根据相册Id查找所有照片
     * @param albumId
     * @return
     */
    @Select("select * from picture where album_id = #{albumId}")
    List<Picture> findAllPicture(Integer albumId);

    /**
     * 根据照片 id 删除照片
     * @param id
     * @return
     */
    @Delete("delete from picture where id = #{id}")
    int deletePictureById(Integer id);
}
