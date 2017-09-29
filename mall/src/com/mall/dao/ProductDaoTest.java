package com.mall.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mall.dto.PageBean;
import com.mall.pojo.Category;
import com.mall.pojo.Product;

public class ProductDaoTest {
	@Test
	public void findProductTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		ProductDao productDao = (ProductDao) applicationContext.getBean("productDao");
		//System.out.println(categoryDao.findRootCategory());
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(3);
		pageBean.setLimitStart(0);
		Product product = new Product();
		product.setCategory_id(100002);
		pageBean.setProduct(product);
		System.out.println(productDao.findProduct(pageBean));
		System.out.println(productDao.totalProduct(pageBean));
	}
	@Test
	public void modifyProductTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		ProductDao productDao = (ProductDao) applicationContext.getBean("productDao");
		Product product = new Product();
		product.setCategory_id(100002);
		product.setId(26);
		product.setPrice(1);
		product.setStock(1);
		product.setStatus(1);
		System.out.println(productDao.modifyProduct(product));
	}
	
	@Test
	public void addProductTest() {
		ClassPathXmlApplicationContext applicationContext =
		        new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取bean
		ProductDao productDao = (ProductDao) applicationContext.getBean("productDao");
		Product product = new Product();
		product.setCategory_id(100002);
		product.setName("1");
		product.setPrice(1);
		product.setMain_image("00ee5c77e37747c68e218bc35d6bfe71");
		product.setStock(1);
		product.setStatus(1);
		System.out.println(productDao.addProduct(product));
	}
}
