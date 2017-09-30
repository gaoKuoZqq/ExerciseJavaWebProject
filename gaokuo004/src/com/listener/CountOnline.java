package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class CountOnline extends HttpServlet{
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		int countOnline = 0;
		servletContext.setAttribute("countOnline", countOnline);
		super.init();
	}
}
