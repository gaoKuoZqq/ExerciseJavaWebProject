package com.s_m_s.controller;

import javax.annotation.Resource;

import org.junit.Test;

import com.s_m_s.service.StudentService;

public class StudentControllerTest {
	/*@Resource(name="studentController")
	StudentController studentController;*/
	@Resource(name="studentService")
	 StudentService studentService;
	@Test
	public void findAllTest() {
	      // 得到IOC容器对象
		/*ClassPathXmlApplicationContext applicationContext =
	               new ClassPathXmlApplicationContext("applicationContext.xml");
	       // 从容器中获取bean
	       StudentController studentController = (StudentController) applicationContext.getBean("studentController");
	       studentController.findAll();*/
		/*StudentControllerTest studentControllerTest = new StudentControllerTest();
		System.out.println(studentControllerTest.studentService == null);*/
		System.out.println(this.studentService == null);
	}
}
