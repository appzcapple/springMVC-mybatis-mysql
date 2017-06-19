package com.appzcapple.security;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletSecurityContext implements SecurityContext {
	
	private Principal principal;
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private Map<String, Boolean> interceptUrls;
	
	public HttpServletSecurityContext(HttpServletRequest req,
										HttpServletResponse res
										) {
		this.request = req;
		this.response = res;
		this.interceptUrls = new LinkedHashMap<String, Boolean>();
	}
	
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	@Override
	public Principal getPrincipal() {
		return this.principal;
	}

	@Override
	public String getContextPath() {
		return this.request.getContextPath();
	}

	@Override
	public boolean login() {
		final String usernameString = request.getParameter("username");
		final String password = request.getParameter("password");
		
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInterceptUrl(String pattern, boolean interceptable) {
		this.interceptUrls.put(pattern, interceptable);		
	}

	@Override
	public boolean intercept() {
		String contextPath = request.getContextPath();
		if("/".equals(contextPath)){
			contextPath = "";
		}
		
		String path = this.request.getRequestURI();
		path = path.substring(contextPath.length());
		
		for (Map.Entry<String, Boolean> entry : this.interceptUrls.entrySet()) {
			if (path.startsWith(entry.getKey())) {
				return entry.getValue();
			}
		}
		
		return true;
	}

}
