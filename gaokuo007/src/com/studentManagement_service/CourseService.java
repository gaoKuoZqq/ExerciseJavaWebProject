package com.studentManagement_service;

import com.studentManagement_class.Course;
import com.studentManagement_dao.ICourseDao;
import com.studentManagement_daoimpl.CourseDaoImpl;

public class CourseService {
	public boolean addCourse(Course course) {
		ICourseDao courseDao = new CourseDaoImpl();
		return courseDao.addCourse(course) > 0;
	}
	
	public boolean checkName(String courseName) {
		ICourseDao courseDao = new CourseDaoImpl();
		return courseDao.checkName(courseName);
	}
}
