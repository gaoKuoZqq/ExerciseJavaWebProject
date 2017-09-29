package com.mall.dao;

import java.util.List;

import com.mall.dto.PageBean;
import com.mall.pojo.Product;;

public interface ProductDao {
	List<Product> findProduct(PageBean pageBean);
	
	Integer totalProduct(PageBean pageBean);
	
	Integer deleteProduct(Integer product_id);
	
	Integer modifyProduct(Product product);
	
	Integer addProduct(Product product);
}
