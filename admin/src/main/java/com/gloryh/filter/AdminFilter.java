package com.gloryh.filter;

import com.gloryh.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员登录过滤器
 *
 * @author 黄光辉
 * @since 2020/11/5
 **/
@WebFilter(urlPatterns = {"/index.html","/login/*","/main.html","/left.html","/product/*","/addProduct.html","/order/*","/category/*","/productList.html","/addCategory.html","/categoryList.html","/orderList.html"},filterName = "adminFilter")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断session中是否有对应的用户信息，没有则返回登录页面
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Admin user =(Admin)session.getAttribute("admin");
        if(user ==null){
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
