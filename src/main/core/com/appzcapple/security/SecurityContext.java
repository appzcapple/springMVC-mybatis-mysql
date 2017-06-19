package com.appzcapple.security;

import java.security.Principal;

public interface SecurityContext {
	
	Principal getPrincipal();
	
	String getContextPath();
	
	boolean login() ;
	
	void logout() ;
	
	void addInterceptUrl(String pattern, boolean interceptable);
	
	boolean intercept();
	
}
