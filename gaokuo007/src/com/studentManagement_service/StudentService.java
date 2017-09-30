package com.studentManagement_service;

import java.util.List;

import com.studentManagement_class.Student;
import com.studentManagement_dao.IStudentDao;
import com.studentManagement_daoimpl.StudentDaoImpl;

public class StudentService {
	public boolean addStudent(Student student){
		if (student.getName().length() >= 10) {
			return false;
		}
		IStudentDao iStudentDao = new StudentDaoImpl();
		return iStudentDao.addStudent(student) > 0;
	}
	
	public List<Student> queryStudents(Student student,int pageIndex,int pageSize){
		IStudentDao studentDao = new StudentDaoImpl();
		List<Student> studentsList = studentDao.queryStudents(student, pageIndex, pageSize);
		
		return studentsList;
	}
	
	public int totalStudents(Student student){
		IStudentDao studentDao = new StudentDaoImpl();
		int result = studentDao.totalStudents(student);
		
		return result;
	}
	
	public boolean modifyStudent(Student student) {
		IStudentDao studentDao = new StudentDaoImpl();
		return studentDao.modifyStudent(student) > 0;
	}
	
	public boolean deleteStudent(int id){
		IStudentDao studentDao = new StudentDaoImpl();
		boolean result = studentDao.deleteStudent(id) > 0;
		
		return result;
	}
	
	public boolean checkName(String studentName) {
		IStudentDao studentDao = new StudentDaoImpl();
		return studentDao.checkName(studentName) > 0;
	}
}
