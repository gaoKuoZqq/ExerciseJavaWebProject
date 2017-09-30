package com.student.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements javax.servlet.Filter{    public void init(FilterConfig filterConfig) throws ServletException {
       
    }
    

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      HttpServletRequest httpServletRequest = (HttpServletRequest) request;
      String method = httpServletRequest.getMethod();
      if (method.equalsIgnoreCase("get")) {
         EnhancedRequest enhancedRequest = new EnhancedRequest(httpServletRequest);
         chain.doFilter(enhancedRequest, response);
      } else {
         request.setCharacterEncoding("utf-8");
         chain.doFilter(request, response);
      }
   }

    public void destroy() {
    }


	public boolean test(int node) {
		// TODO 自动生成的方法存根
		return false;
	}
}

