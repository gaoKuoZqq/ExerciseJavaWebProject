package com.studentManagement_dao;

import java.util.List;

import com.studentManagement_class.Student;
import com.studentManagement_service.StudentService;

public interface IStudentDao {
	int addStudent(Student student);
	
	int deleteStudent(int id);
	
	int modifyStudent(Student student);
	
	List<Student> queryStudents(Student student,int pageIndex,int pageSize);
	
	int totalStudents(Student student);
	
	int checkName(String name);
	
}
