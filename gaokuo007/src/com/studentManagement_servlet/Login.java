package com.studentManagement_servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentManagement_class.Administrator;
import com.studentManagement_service.AdministratorService;
public class Login extends BaseServlet{
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		ServletContext servletContext = getServletContext();
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		Administrator administrator = new Administrator(userName, passWord);
		AdministratorService administratorService = new AdministratorService();
		if (administratorService.login(administrator)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userName", administrator);
			if (servletContext.getAttribute("users") == null) {
				HashSet<String> administratorsSet = new HashSet<String>();
				administratorsSet.add(administrator.getUserName());
				servletContext.setAttribute("users", administratorsSet);
				servletContext.setAttribute("online", administratorsSet.size());
			}else {
				HashSet<String> administratorsSet = (HashSet<String>) servletContext.getAttribute("users");
				administratorsSet.add(administrator.getUserName());
				servletContext.setAttribute("online", administratorsSet.size());
			}
			
			resp.sendRedirect(servletContext.getContextPath()+"/student?method=queryStudents");
		}else{
			req.setAttribute("user", "false");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		}

	}
}
