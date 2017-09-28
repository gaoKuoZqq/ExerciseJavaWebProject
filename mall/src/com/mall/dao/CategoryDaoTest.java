package com.mall.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mall.dto.PageBean;
import com.mall.pojo.Category;


public class CategoryDaoTest {
	@Test
	public void findCategoryTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
		//System.out.println(categoryDao.findRootCategory());
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(3);
		pageBean.setLimitStart(0);
		System.out.println(categoryDao.findCategory(pageBean));
	}
	
	@Test
	public void modifyCategoryTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
		//System.out.println(categoryDao.findRootCategory());
		Category c = new Category(100007,100001,"电视机",1,null);
		System.out.println(categoryDao.modifyCategory(c));
	}
	
	@Test
	public void addCategoryTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
		//System.out.println(categoryDao.findRootCategory());
		Category c = new Category(100001,"鸭蛋",1,1);
		System.out.println(categoryDao.addCategory(c));
	}
}
