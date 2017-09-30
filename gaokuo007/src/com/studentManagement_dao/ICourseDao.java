package com.studentManagement_dao;

import com.studentManagement_class.Course;

public interface ICourseDao {
	int addCourse(Course course);
	
	boolean checkName(String courseName);
}
