package com.springboot.Interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springboot.exception.InvalidHeaderFieldException;

@Component
public class RequestHeaderInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	  if(StringUtils.isEmpty(request.getHeader("student-auth-key"))) {
		 // throw new InvalidHeaderFieldException("Invalid Request");
	  }
		return super.preHandle(request, response, handler);
	}
}
