package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DoSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession httpSession= se.getSession();
		ServletContext servletContext = httpSession.getServletContext();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession httpSession= se.getSession();
		ServletContext servletContext = httpSession.getServletContext();
	}

}
