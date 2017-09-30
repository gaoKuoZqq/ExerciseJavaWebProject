package com.studentservice;

import java.util.List;

import com.administrator.Administrator;
import com.administrator.dao.AdministratorDaoImpl;
import com.administrator.dao.IAdministratorDao;
import com.studentclass.Student;
import com.studentdao.IStudentDao;
import com.studentdao.StudentDaoImpl;

public class StudentService {
	public boolean addStudent(Student student){
		IStudentDao studentDao = new StudentDaoImpl();
		boolean result = studentDao.addStudent(student) > 0;
		
		return result;
	}
	
	public boolean deleteStudent(int id){
		IStudentDao studentDao = new StudentDaoImpl();
		boolean result = studentDao.deleteStudent(id) > 0;
		
		return result;
	}
	
	public boolean modifyStudent(Student student){
		IStudentDao studentDao = new StudentDaoImpl();
		boolean result = studentDao.modifyStudent(student) > 0;
		
		return result;
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
	
	public boolean checkName(String name){
		IStudentDao studentDao = new StudentDaoImpl();
		boolean result = studentDao.chackName(name) > 0;
		
		return result;
	}
	
	public boolean login(Administrator administrator) {
		IAdministratorDao administratorDao = new AdministratorDaoImpl();
		
		return administratorDao.login(administrator);
	}
}
