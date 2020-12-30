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
 * @since 2020/11/18
 **/
@WebFilter(urlPatterns = {"/cart.html"},filterName = "cartFilter")
public class CartFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        Vip user =(Vip) session.getAttribute("viper");
        if (user ==null || user.getVip_id() ==0){
            response.sendRedirect("/login.html");
        }else {
            response.sendRedirect("/cart/findByVipId/"+user.getVip_id());
        }

    }

    @Override
    public void destroy() {

    }
}
