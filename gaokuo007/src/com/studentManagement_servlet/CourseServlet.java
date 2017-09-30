package com.studentManagement_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentManagement_class.BanjiCourseString;
import com.studentManagement_class.Course;
import com.studentManagement_class.PageBean;
import com.studentManagement_service.CourseService;

public class CourseServlet extends BaseServlet{

	private void queryCourses(HttpServletRequest req, HttpServletResponse resp){
		

		Integer pageIndex = 1;
		Integer pageSize = 5;
		
		ServletContext servletContext = getServletContext();
		
		//获取分页信息
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		if (pageIndexStr != null && !"".equals(pageIndexStr)) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}

		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		//获得结果列表
		List<Course> list = (List<Course>) req.getAttribute("coursesList");
		Integer end = (pageIndex-1)*pageSize+pageSize;
		if (end >= list.size()) {
			end = list.size();
		}
		List<Course> pageList = list.subList((pageIndex-1)*pageSize, end);
		//获得结果总数
		int totalStudents = list.size();
		//计算页数
		int totalPage = (int) Math.ceil(1.0*totalStudents/pageSize);
		//封装pageBean
		PageBean pageBean = new PageBean(pageIndex, pageSize, totalStudents, totalPage, pageList);
		req.setAttribute("pageBean", pageBean);
		
		try {
			req.getRequestDispatcher("/jsp/course_findall_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	private void addCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		CourseService courseService = new CourseService();
		String courseName = req.getParameter("courseName");
		String credit = req.getParameter("courseCredit");
		String  regex = "[1-9]";
		resp.setContentType("charset=utf-8");
		
		if (!credit.matches(regex) || courseName.length() < 2 || courseName.length() > 15) {
			resp.getWriter().write("{\"isSuccess\":" + false + "}");
			return;
		}
		Course course = new Course(courseName, Integer.parseInt(credit));
		boolean isSuccess = courseService.addCourse(course);
		
		resp.getWriter().write("{\"isSuccess\":" + isSuccess + "}");
	}
	
	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		CourseService courseService = new CourseService();
		String courseName = req.getParameter("courseName");
		resp.setContentType("charset=utf-8");
		boolean isExit = courseService.checkName(courseName);
		resp.getWriter().write("{\"isSuccess\":" + isExit + "}");
	}
}
