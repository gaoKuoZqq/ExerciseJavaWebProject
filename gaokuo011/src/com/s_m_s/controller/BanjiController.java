package com.s_m_s.controller;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Course;
import com.s_m_s.pojo.Student;
import com.s_m_s.service.BanjiService;
import com.s_m_s.service.CourseService;
@Controller
@RequestMapping(value="/banji")
public class BanjiController {
	@Resource(name="banjiService")
	BanjiService banjiService;
	//添加班级用到的课程列表
	@Resource(name="courseService")
	CourseService courseService;
	
	@RequestMapping(value="/find")
	public ModelAndView findBanjis(Integer pageIndex, Integer pageSize) {
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
		pageBean = banjiService.findAllBanjisCourses(pageBean);
		modelAndView.addObject(pageBean);
		modelAndView.setViewName("banji_find");
		return modelAndView;
	}
	
	@RequestMapping(value="/add")
	public @ResponseBody boolean addBanji(String banji_name,String coursesId) {
		if (banji_name == null || "".equals(banji_name.trim())) {
			return false;
		}
		Banji banji = new Banji(banji_name);
		if(coursesId == null || "".equals(coursesId)){
			coursesId = " ";
		}
		String[] coursesIds = coursesId.split(" ");
		HashSet<String> coursesIdSet = new HashSet<String>();
		for (String courseIdString : coursesIds) {
			coursesIdSet.add(courseIdString.trim());
		}
		boolean result = banjiService.addBanji(banji,coursesIdSet);
		return result;
	}
	//用于跳转到添加班级界面的方法
	@RequestMapping(value="/goadd")
	public ModelAndView goAddBanji() {
		ModelAndView modelAndView = new ModelAndView();
		//在这里,我调用了课程service中的finaDllBanjis方法,用来获得班级列表,班级添加班级用
		List<Course> coursesList = courseService.findAllCourses();
		modelAndView.addObject("coursesList",coursesList);
		modelAndView.setViewName("banji_add");
		return modelAndView;
	}
	
	@RequestMapping(value="elective")
	public @ResponseBody boolean elective(Integer banji_id, String coursesId) {
		if (banji_id == null) {
			return false;
		}
		if(coursesId == null || "".equals(coursesId)){
			coursesId = " ";
			return false;
		}
		String[] coursesIds = coursesId.split(" ");
		HashSet<String> coursesIdSet = new HashSet<String>();
		for (String courseIdString : coursesIds) {
			coursesIdSet.add(courseIdString.trim());
		}
		banjiService.elective(banji_id, coursesIdSet);
		return true;
	}
	@RequestMapping(value="goelective")
	public ModelAndView goelective() {
		ModelAndView modelAndView = new ModelAndView();
		List<Banji> banjisList = banjiService.findAllBanjis();
		modelAndView.addObject("banjisList",banjisList);
		List<Course> coursesList = courseService.findAllCourses();
		modelAndView.addObject("coursesList", coursesList);
		modelAndView.setViewName("banji_elective");
		return modelAndView;
	}
	
	@RequestMapping(value="deleteElective")
	public @ResponseBody boolean deleteElective(Integer banji_id, Integer course_id){
		return banjiService.deleteElective(banji_id, course_id);
	}
	
	@RequestMapping(value="findCoursesByBanjiId")
	public @ResponseBody List<Course> findCoursesByBanjiId(Integer banji_id) {
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return courseService.findCoursesByBanjiId(banji_id);
	}
	
	@RequestMapping(value="checkBanjiName")
	public @ResponseBody boolean checkBanjiName(String banji_name) {
		return banjiService.checkBanjiName(banji_name);
	}
}
