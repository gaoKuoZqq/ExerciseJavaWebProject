package com.s_m_s.controller;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Course;
import com.s_m_s.service.CourseService;

@Controller
@RequestMapping(value="course")
public class CourseController {
	@Resource(name="courseService")
	private CourseService courseService;
	@RequestMapping(value="find")
	public ModelAndView findCourses(Integer pageIndex, Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		PageBean pageBean = new PageBean();
		if(pageIndex == null || pageIndex == 0){
			pageIndex = 1;
		}
		if(pageSize == null || pageSize == 0){
			pageSize = 3;
		}
		pageBean.setPageIndex(pageIndex);
		pageBean.setLimitEnd(pageSize);
		pageBean = courseService.findCourse(pageBean);
		modelAndView.addObject(pageBean);
		modelAndView.setViewName("course_find");
		return modelAndView;
	}
	
	@RequestMapping(value="/add")
	public @ResponseBody boolean addBanji(String course_name, String course_credit) {
		if (course_name == null || "".equals(course_name.trim()) || !course_credit.matches("[0-9]")) {
			return false;
		}
		Course course = new Course(course_name,Integer.parseInt(course_credit));
		boolean result = courseService.addCourse(course);
		return result;
	}
	//用于跳转到添加课程界面的方法
	@RequestMapping(value="/goadd")
	public ModelAndView goAddBanji() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("course_add");
		return modelAndView;
	}
	
	@RequestMapping(value="checkName")
	public @ResponseBody boolean checkCourseName(String course_name) {
		return courseService.checkCourseName(course_name.trim());
	}
}
