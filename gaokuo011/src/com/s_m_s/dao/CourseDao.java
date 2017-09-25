package com.s_m_s.dao;

import java.util.List;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Course;

public interface CourseDao {
	List<Course> findAllCourses();
	
	List<Course> findCourses(PageBean pageBean);
	
	Integer addCourse(Course course);
	
	Integer checkCourseName(String course_name);
	
	List<Course> findCoursesByBanjiId(Integer banji_id);
}
