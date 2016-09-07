package com.vsi.boot.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


 @Component
@Order(2)
public class TrackingFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("########## tracking filter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}