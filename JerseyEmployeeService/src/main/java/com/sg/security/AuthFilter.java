package com.sg.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		String authUsernamePass = req.getHeader("Authorization");
		
		AuthenticationService as = new AuthenticationService();
		boolean isAuthenticated = as.isAuthenticate(authUsernamePass);
		
		if(isAuthenticated) {
			chain.doFilter(request, response);
		}
		else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}	
	}
	
	public void init(FilterConfig fconfig) throws ServletException {}

}
