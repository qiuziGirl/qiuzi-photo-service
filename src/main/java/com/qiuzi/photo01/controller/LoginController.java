package com.qiuzi.photo01.controller;

import com.qiuzi.photo01.service.AlbumService;
import com.qiuzi.photo01.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private AlbumService albumService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping({"/", "/login"})
    public String login(Model model) {
        model.addAttribute("username", "张三");
        model.addAttribute("password", 123456);
        return "login";
    }

    /**
     * 跳转首页界面
     * @return
     */
    @RequestMapping("/index/{userId}")
    public String index(@PathVariable("userId") Integer userId, Model model) {
        model.addAttribute("albums", albumService.findAll(userId));
        return "index";
    }


    //--------------------------------------------------待测试删除-------------------------------------------------------

    /**
     * 文件上传测试
     * @return
     */
    @RequestMapping("/index/upload")
    public String upload() {
        return "upload";
    }
}
