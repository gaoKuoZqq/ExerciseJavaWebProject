package com.s_m_s.service;

import java.util.List;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Course;

public interface CourseService {
	public  List<Course> findAllCourses();
	
	public PageBean findCourse(PageBean pageBean);
	
	public List<Course> findCoursesByBanjiId(Integer banji_id);
	
	public boolean addCourse(Course course);
	
	public boolean checkCourseName(String course_name);
}
