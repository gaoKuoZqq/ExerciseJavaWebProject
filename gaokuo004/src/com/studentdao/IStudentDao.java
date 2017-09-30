package com.studentdao;

import java.util.List;

import com.studentclass.Student;

public interface IStudentDao {
	int addStudent(Student student);
	
	int deleteStudent(int id);
	
	int modifyStudent(Student student);
	
	List<Student> queryStudents(Student student,int pageIndex,int pageSize);
	
	int totalStudents(Student student);
	
	int chackName(String name);
}
