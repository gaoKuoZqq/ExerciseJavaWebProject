package com.s_m_s.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Student;

public class StudentDaoTest {
	@Test
	public void addStudentTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		StudentDao studentdao = (StudentDao) applicationContext.getBean("studentDao");
		Banji banji = new Banji(2);
		Student student = new Student("九傻",20,"男",new Date(),banji);
		System.out.println(studentdao.addStudent(student));
	}
	@Test
	public void modifyStudentTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		StudentDao studentdao = (StudentDao) applicationContext.getBean("studentDao");
		Banji banji = new Banji(1);
		Student student = new Student(23,"傻傻",20,"男",new Date(),banji);
		System.out.println(studentdao.modifyStudent(student));
	}
	
	@Test
	public void deleteStudentTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		StudentDao studentdao = (StudentDao) applicationContext.getBean("studentDao");
		System.out.println(studentdao.deleteStudent(33));
	}
	
	@Test
	public void findStudentsTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		StudentDao studentdao = (StudentDao) applicationContext.getBean("studentDao");
		Banji banji = new Banji(3);
		Student student = new Student(null,null,"女",null,banji);
		PageBean pageBean = new PageBean(0,0,null);
		System.out.println(studentdao.findStudents(pageBean));
		
	}
	
	@Test
	public void wuliao(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		StudentDao studentdao = (StudentDao) applicationContext.getBean("studentDao");
		StudentDao studentdao1 = (StudentDao) applicationContext.getBean("studentDao");
		System.out.println(studentdao==studentdao1);
	}
	
	@Test
	public void totalStudentsTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		StudentDao studentdao = (StudentDao) applicationContext.getBean("studentDao");
		Banji banji = new Banji(3);
		Student student = new Student(null,null,null,null,banji);
		PageBean pageBean = new PageBean(0,0,student);
		System.out.println(studentdao.totalStudents(pageBean));
		
	}
	
	@Test
	public void findAllCoursesTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		CourseDao courseDao = (CourseDao) applicationContext.getBean("courseDao");
		System.out.println(courseDao.findAllCourses());
		
	}
}
