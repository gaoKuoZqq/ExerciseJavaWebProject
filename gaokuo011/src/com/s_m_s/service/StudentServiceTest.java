package com.s_m_s.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.s_m_s.dao.StudentDao;
import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Student;

public class StudentServiceTest {
	@Test
	public void findStudentsTest(){
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
				StudentService studentService = (StudentService) applicationContext.getBean("studentService");
				Banji banji = new Banji(3);
				Student student = new Student(null,null,null,null,banji);
				PageBean pageBean = new PageBean(0,3,null);
				System.out.println(studentService.findStudents(pageBean));
	}
	
	@Test
	public void findAllBanjisCoursesTest(){
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
				BanjiService banjiService = (BanjiService) applicationContext.getBean("banjiService");
				
				System.out.println();
				
	}
	
	@Test
	public void addBanjiTest(){
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
				BanjiService banjiService = (BanjiService) applicationContext.getBean("banjiService");
				Set< String> asd = new HashSet<>();
				asd.add("1");
				asd.add("2");
				Banji banji = new Banji();
				banji.setBanji_name("中班");
				System.out.println(banjiService.addBanji(banji,asd));
				
	}
}
