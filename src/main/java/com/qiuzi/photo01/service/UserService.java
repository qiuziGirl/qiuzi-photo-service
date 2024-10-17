package com.qiuzi.photo01.service;

import com.qiuzi.photo01.bean.User;

public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    User singnIn(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    int signUp(User user);

    /**
     * 根据 id 查询用户信息
     * @param id
     * @return
     */
    User findUserById(Integer id);
}
