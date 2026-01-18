package com.qiuzi.photo01.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 登录检测
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hanler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            // 未登录，返回登录页面
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {

    }
}
