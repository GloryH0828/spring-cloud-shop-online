package com.gloryh.filter;

import com.gloryh.entity.Vip;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO
 *
 * @author 黄光辉
 * @since 2020/11/13
 **/
@WebFilter(urlPatterns = {"/order/*","/product/*"},filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断session中是否有对应的用户信息，没有则返回登录页面
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Vip user =(Vip) session.getAttribute("viper");
        if(user ==null || user.getVip_id() ==0){
            //用户信息为null，重定向到登录页面
            response.sendRedirect("/login.html");
        }else{
            //user不为null，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
