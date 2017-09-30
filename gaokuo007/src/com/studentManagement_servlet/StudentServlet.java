package com.studentManagement_servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentManagement_class.Banji;
import com.studentManagement_class.PageBean;
import com.studentManagement_class.Student;
import com.studentManagement_service.BanjiService;
import com.studentManagement_service.StudentService;

public class StudentServlet extends BaseServlet{
	private void addStudent(HttpServletRequest req, HttpServletResponse resp){
		
		ServletContext servletContext = getServletContext();
		StudentService studentService = new StudentService();
		String name = req.getParameter("studentName");
		String age = req.getParameter("studentAge");
		String gender = req.getParameter("studentGender");
		String birthday = req.getParameter("studentBirthday");
		String banji_id = req.getParameter("studentBanji_id");
		Banji banji = new Banji(Integer.parseInt(banji_id));
		String  regexAge = "\\d{0,2}";
		if (age != null && "".equals(age) && !age.matches(regexAge)) {
			return;
		}
		
		Date date = new Date();
		String  regex = "[0-9]{4}+[-]+[0-9]{2}+[-]+[0-9]{2}";
		if (birthday != null && birthday.matches(regex)) {
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
			Student student = new Student(name, Integer.parseInt(age), gender, date,banji);
			
			boolean isSuccess = studentService.addStudent(student);
			resp.setContentType("charset=utf-8");
		    try {
				resp.getWriter().write("{\"isSuccess\":" + isSuccess + "}");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	private void queryStudents(HttpServletRequest req, HttpServletResponse resp){
		Integer pageIndex = 1;
		Integer pageSize = 5;
		
		StudentService studentService = new StudentService();
		ServletContext servletContext = getServletContext();
		HttpSession session = req.getSession(false);
		
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
		String banji_id = req.getParameter("studentBanji_id");
		String  regexAge = "\\d{0,2}";
		if (age != null && !age.matches(regexAge)) {
			req.setAttribute("age", null);
			try {
				req.getRequestDispatcher(servletContext.getContextPath()+"/student?method=queryStudents").forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		if ("".equals(banji_id)) {
			banji_id = "0";
		}
		if (age == null || "".equals(age)) {
			age = "0";
		}
		Student student = null;
		Banji banji = null;
		if ((name == null || "".equals(name)) && (age == null || "0".equals(age)) && (gender == null || "".equals(gender)) && (banji_id == null || "".equals(banji_id))) {
			student = new Student(); 
			banji = new Banji();
		}else {
			banji = new Banji(Integer.parseInt(banji_id));
			student = new Student(name, Integer.parseInt(age), gender,banji);
		}
		req.setAttribute("stu", student);
		if (student.getAge().equals("0")) {
			
		}
		//获得结果列表
		List<Student> studentsList = studentService.queryStudents(student, pageIndex, pageSize);
		//获得结果总数
		int totalStudents = studentService.totalStudents(student);
		//计算页数
		int totalPage = (int) Math.ceil(1.0*totalStudents/pageSize);
		//封装pageBean
		PageBean pageBean = new PageBean(pageIndex, pageSize, totalStudents, totalPage, studentsList);
		req.setAttribute("pageBean", pageBean);
		try {
			req.getRequestDispatcher("/gojsp?method=queryStudents").forward(req, resp);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void modifyStudentInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService studentService = new StudentService();
		req.setAttribute("isModifySuccess", false);
		String id = req.getParameter("studentId");
		String name = req.getParameter("studentName");
		String age = req.getParameter("studentAge");
		String gender = req.getParameter("studentGender");
		String birthday = req.getParameter("studentBirthday");
		String banjiId = req.getParameter("studentBanjiId");
		Banji banji = new Banji(Integer.parseInt(banjiId));
		String  regexAge = "\\d{0,2}";
		if (age != null && "".equals(age) && !age.matches(regexAge)) {
			req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
			return;
		}
		if (name.length() > 4) {
			req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
			return;
		}
		
		Date date = new Date();
		String  regex = "[0-9]{4}+[-]+[0-9]{2}+[-]+[0-9]{2}";
		if (birthday != null && birthday.matches(regex)) {
			SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = simpleDateFormat.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (name == null || "".equals(name) || age == null || "".equals(age)) {
			return;
		}
		Student student = new Student(Integer.parseInt(id),name, Integer.parseInt(age), gender, date,banji);
		req.setAttribute("isModifySuccess", studentService.modifyStudent(student));
		req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
	}
	
	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		StudentService studentService = new StudentService();
		ServletContext servletContext = getServletContext();
		
		String id = req.getParameter("studentId");
		studentService.deleteStudent(Integer.parseInt(id));
		req.getRequestDispatcher("/student?method=queryStudents").forward(req, resp);
	}
	
	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		StudentService studentService = new StudentService();
		String studentName = req.getParameter("studentName");
		resp.setContentType("charset=utf-8");
		boolean isExit = studentService.checkName(studentName);
		resp.getWriter().write("{\"isSuccess\":" + isExit + "}");
	
	}
}
