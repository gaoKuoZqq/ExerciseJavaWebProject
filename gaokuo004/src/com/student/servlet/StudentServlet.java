package com.student.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.administrator.Administrator;
import com.studentclass.Student;
import com.studentservice.StudentService;

@SuppressWarnings("serial")
public class StudentServlet extends BaseServlet{
	
	
	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		ServletContext servletContext = getServletContext();
		StudentService studentService = new StudentService();
		
		String name = req.getParameter("studentName");
		String age = req.getParameter("studentAge");
		String gender = req.getParameter("studentGender");
		String birthday = req.getParameter("studentBirthday");
		
		String  regexAge = "\\d{0,2}";
		if (age != null && "".equals(age) && !age.matches(regexAge)) {
			req.getRequestDispatcher(servletContext.getContextPath()+"/student?method=queryStudents").forward(req, resp);
		}
		
		Date date = new Date();
		String  regex = "[0-9]{4}+[-]+[0-9]{2}+[-]+[0-9]{2}";
		if (birthday.matches(regex)) {
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = simpleDateFormat.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//输入为空,判定无法添加
		if (name != null && age != null && gender != null
				&& !"".equals(name) && !"".equals(age) && !"".equals(gender)) {
			Student student = new Student(name, Integer.parseInt(age), gender, date);
			studentService.addStudent(student);
		}
		
		
		try {
			req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		StudentService studentService = new StudentService();
		ServletContext servletContext = getServletContext();
		
		String id = req.getParameter("id");
		studentService.deleteStudent(Integer.parseInt(id));
		req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
	}
	
	private void modifyStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		StudentService studentService = new StudentService();
		ServletContext servletContext = getServletContext();
		
		int ID = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("studentName");
		String age = req.getParameter("studentAge");
		String gender = req.getParameter("studentGender");
		String birthday = req.getParameter("studentBirthday");
		
		Date date = new Date();
		String  regex = "[0-9]{4}+[-]+[0-9]{2}+[-]+[0-9]{2}";
		if (birthday.matches(regex)) {
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = simpleDateFormat.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		Student student = new Student(ID, name, Integer.parseInt(age), gender, date);
		studentService.modifyStudent(student);
		req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
	}
	
	private void queryStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer pageIndex = 1;
		Integer pageSize = 5;
		
		StudentService studentService = new StudentService();
		ServletContext servletContext = getServletContext();
		HttpSession session = req.getSession(false);

		
		System.out.println(servletContext.getAttribute("countOnline"));
		
		//获取分页信息
		String pageIndexStr = (String) req.getParameter("pageIndex");
		String pageSizeStr = (String) req.getParameter("pageSize");
		if (pageIndexStr != null && !"".equals(pageIndexStr)) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}

		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		//获取查询条件
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String  regexAge = "\\d{0,2}";
		if (age != null && !age.matches(regexAge)) {
			req.setAttribute("age", null);
			req.getRequestDispatcher(servletContext.getContextPath()+"/student?method=queryStudents").forward(req, resp);
			return;
		}
		
		if (age == null || "".equals(age)) {
			age = "0";
		}
		Student student = null;
		if ((name == null || "".equals(name)) && (age == null || "".equals(age)) && (gender == null || "".equals(gender))) {
			student = new Student();
		}else {
			student = new Student(name, Integer.parseInt(age), gender);
		}
		req.setAttribute("stu", student);			//获得结果列表
		List<Student> studentsList = studentService.queryStudents(student, pageIndex, pageSize);
		//获得结果总数
		int totalStudents = studentService.totalStudents(student);			//计算页数
		int totalPage = (int) Math.ceil(1.0*totalStudents/pageSize);
		//封装pageBean
		PageBean pageBean = new PageBean(pageIndex, pageSize, totalStudents, totalPage, studentsList);			req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
		
	}
	
	
	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		StudentService studentService = new StudentService();
		String name = req.getParameter("name");
		boolean isExit = studentService.checkName(name);
		resp.setContentType("charset=utf-8");
	    resp.getWriter().write("{\"isExit\":" + isExit + "}");
	}
	
	private void log(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(false);
		ServletContext servletContext = getServletContext();
		Administrator userName = (Administrator) session.getAttribute("userName");
		HashSet<String> administratorsSet = (HashSet<String>) servletContext.getAttribute("users");
		administratorsSet.remove(userName.getUserName());
		Integer online = (Integer) servletContext.getAttribute("online");
		online = online - 1;
		servletContext.setAttribute("online", online);
		session.invalidate();
		System.out.println("StudentServlet.log()");
		resp.sendRedirect(servletContext.getContextPath()+"/jsp/login.jsp");
	}
	
	private void test(HttpServletRequest req, HttpServletResponse resp){
		System.out.println(req.getParameter("idList"));
		
		
		
	}
}
