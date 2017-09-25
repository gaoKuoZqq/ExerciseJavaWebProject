package com.s_m_s.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Student;
import com.s_m_s.service.BanjiService;
import com.s_m_s.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Resource(name="studentService")
	private StudentService studentService;
	
	@Resource(name="banjiService")
	private BanjiService banjiService;
	
	@RequestMapping(value="/find")
	public ModelAndView findAll(Integer pageIndex, Integer pageSize,Student student){
		ModelAndView modelAndView = new ModelAndView();
		if(pageIndex == null || pageIndex == 0){
			pageIndex = 1;
		}
		if(pageSize == null || pageSize == 0){
			pageSize = 5;
		}
		PageBean pageBean = new PageBean((pageIndex-1)*pageSize,pageSize,student);
		pageBean = studentService.findStudents(pageBean);
		pageBean.setPageIndex(pageIndex);
		modelAndView.addObject(pageBean);
		//在这里,我调用了班级service中的finaDllBanjis方法,用来获得班级列表,学生更换班级用
		List<Banji> banjisList = banjiService.findAllBanjis();
		modelAndView.addObject("banjisList",banjisList);
		modelAndView.setViewName("student_find");
		return modelAndView;
	}
	
	@RequestMapping(value="/add")
	public @ResponseBody boolean addStudent(Student student) {
		boolean result = studentService.addStudent(student);
		return result;
	}
	//用于跳转到添加学生界面的方法
	@RequestMapping(value="/goadd")
	public ModelAndView goAddStudent() {
		ModelAndView modelAndView = new ModelAndView();
		//在这里,我调用了班级service中的finaDllBanjis方法,用来获得班级列表,学生添加班级用
		List<Banji> banjisList = banjiService.findAllBanjis();
		modelAndView.addObject("banjisList",banjisList);
		modelAndView.setViewName("student_add");
		return modelAndView;
	}
	
	@RequestMapping(value="/modify")
	public void modifyStudent(HttpServletRequest req, HttpServletResponse resp, Student student,Integer pageIndex) {
		System.out.println("student修改" + student);
		System.out.println("pageIndex" + pageIndex);
		System.out.println("req:" + req.getParameter("student_name"));
		studentService.modifyStudent(student);
		req.setAttribute("pageIndex", pageIndex);
		req.setAttribute("Student", student);
		try {
			req.getRequestDispatcher("/student/find.action").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody boolean deleteStudent(String student_id) {
		boolean result = studentService.deleteStudent(Integer.parseInt(student_id));
		return result;
	}
}
