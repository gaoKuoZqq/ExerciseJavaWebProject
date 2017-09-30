package com.gojsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentManagement_class.Banji;
import com.studentManagement_class.PageBean;
import com.studentManagement_class.Student;
import com.studentManagement_servlet.BaseServlet;

public class GoJsp extends BaseServlet{
	
	public void goStudentAdd(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/jsp/student_add_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void goQueryStudent(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/jsp/student_query_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void goQueryStudentBusy(HttpServletRequest req,HttpServletResponse resp) {
		PageBean pageBean = (PageBean) req.getAttribute("pageBean");
		changeBanji(pageBean.getList(), req);
		try {
			req.getRequestDispatcher("/jsp/student_query_busy.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void queryStudents(HttpServletRequest req,HttpServletResponse resp) {
		PageBean pageBean = (PageBean) req.getAttribute("pageBean");
		changeBanji(pageBean.getList(), req);
		try {
			req.getRequestDispatcher("/jsp/student_findall_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	private void changeBanji(List<Student> list,HttpServletRequest req) {
		List<Banji> banjisList = (List<Banji>) req.getAttribute("banjisList");
		for (Student student : list) {
			
			for (Banji banji : banjisList) {
				if (student.getBanji().getBanjiId() == banji.getBanjiId()) {
					student.setBanji(banji);
					break;
				}
				
			}
		}
	}
	
	private void goBanjiAdd(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/jsp/banji_add_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void goBanjisList(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/jsp/banji_findall_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void goCoursesList(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/jsp/course_findall_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void goAddCourse(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/jsp/course_add_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
