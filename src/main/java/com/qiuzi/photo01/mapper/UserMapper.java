package com.qiuzi.photo01.mapper;

import com.qiuzi.photo01.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 增加用户
     * @param user
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(user_name, password, email, is_admin, create_time, update_time) values (#{userName}, #{password}, #{email}, #{isAdmin}, #{createTime}, #{updateTime})")
    int insertUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Delete("delete * from user where id = #{id}")
    int deleteUserById(Integer id);

    /**
     * 根据id更新用户名字
     * @param user
     * @return
     */
    @Update("update user set user_name = #{userName} where id = #{id}")
    int updateUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    /**
     * 根据名字查询用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name = #{userName}")
    User findUserByUserName(String userName);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
