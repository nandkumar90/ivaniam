package com.arial.ivanium.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.arial.ivanium.delegate.DatabaseDelegate;
import com.arial.ivanium.dto.User;



public class AuthenticationFilter implements Filter {

	

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		/*
		 * Header is in format
		 * Base64 encoding of Username:token
		 */
		String authHeader = httpRequest
				.getHeader(AuthenticationConstants.AUTHENTICATION_HEADER);
		String decodedHeaderValue[] = new String(Base64.getDecoder().decode(authHeader.getBytes())).split(":");
		String userId = decodedHeaderValue[0];
		String token = decodedHeaderValue[1];
		
	}
	
	
	
	

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
