package com.mall.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mall.dto.PageBean;
import com.mall.pojo.Product;
import com.mall.pojo.User;

public class UserDaoTest {
	@Test
	public void findProductTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		//System.out.println(categoryDao.findRootCategory());
		System.out.println(userDao.checkLogin(new User()));
	}
}
