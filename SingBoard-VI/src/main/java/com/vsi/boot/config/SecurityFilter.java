package com.vsi.boot.config;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class SecurityFilter implements Filter{
	private FilterConfig config = null;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println("** Sing Board SecurityFilter");
    	config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("###### security filter ");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    	this.config = null;
    }
}