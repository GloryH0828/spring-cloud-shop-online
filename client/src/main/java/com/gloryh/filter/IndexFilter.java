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
 * @since 2020/11/14
 **/
@WebFilter(urlPatterns = {"/index.html",},filterName = "indexFilter")
public class IndexFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        Vip vip=(Vip) session.getAttribute("viper");
        if (vip==null){
            vip=new Vip();
            vip.setVip_id(0);
            session.setAttribute("viper",vip);
        }
        response.sendRedirect("/index/all");
    }
    @Override
    public void destroy() {

    }
}
