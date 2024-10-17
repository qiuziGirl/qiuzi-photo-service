package com.qiuzi.photo01.service.Impl;

import com.qiuzi.photo01.bean.User;
import com.qiuzi.photo01.mapper.UserMapper;
import com.qiuzi.photo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 1：登录成功； 0：登录失败
     * @param user
     * @return
     */
    @Override
    public User singnIn(User user) {
        User _user = userMapper.findUserByUserName(user.getUserName());
        if (_user != null) {
            if (user.getPassword().equals(_user.getPassword())) {
                return _user;
            }
        }
        return null;
    }

    /**
     * 1: 注册成功； 0:注册失败
     * @param user
     * @return
     */
    @Override
    public int signUp(User user) {
        User _user = userMapper.findUserByUserName(user.getUserName());
        if (_user == null) {
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            userMapper.insertUser(user);
            return 1;
        }
        return 0;
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }
}
