package com.appzcapple.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public class SecurityFilter implements Filter {
	
	private FilterConfig config;
	
	@Override
	public void destroy() {


	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		
		final ApplicationContext appContext = ContextLoader.getCurrentWebApplicationContext();
		
		System.out.println("filter : before chain");
		
//		if (!request.getParameter("user").equals("appzc")) {
//			response.setStatus(403);
//			response.getWriter().write("auth failed");
//			return;
//		}
		
		chain.doFilter(req, res);
		
		System.out.println("filter : after chain");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
