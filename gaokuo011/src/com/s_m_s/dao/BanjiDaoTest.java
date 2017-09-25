package com.s_m_s.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BanjiDaoTest {
	@Test
	public void findAllBanjisTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		BanjiDao banjiDao = (BanjiDao) applicationContext.getBean("banjiDao");
		System.out.println(banjiDao.findAllBanjis());
	}
	
	@Test
	public void findAllBanjisCoursesTest(){
		ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		BanjiDao banjiDao = (BanjiDao) applicationContext.getBean("banjiDao");
		System.out.println(banjiDao.findAllBanjisCourses());
	}
}
