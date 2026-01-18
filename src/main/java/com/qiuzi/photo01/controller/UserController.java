package com.qiuzi.photo01.controller;

import com.qiuzi.photo01.bean.User;
import com.qiuzi.photo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/mine/{userId}")
    public String getMine(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("user", userService.findUserById(userId));
        return "mine";
    }

    /**
     * 没有权限访问主页
     * 跳转回登录页面
     * @param session
     * @return
     */
    @RequestMapping("/quit")
    public String signOut(HttpSession session) {
        session.setAttribute("loginUser", null);
        return "redirect:/login";
    }

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/signIn")
    @ResponseBody
    public int signIn(User user, HttpSession session) {
        User _user = userService.singnIn(user);
        if (_user != null) {
            // 保存登录状态
            session.setAttribute("loginUser", _user.getId());
            return _user.getId();
        } else {
            return 0;
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/signUp")
    @ResponseBody
    public int signUp(User user) {
        return userService.signUp(user);
    }

}
