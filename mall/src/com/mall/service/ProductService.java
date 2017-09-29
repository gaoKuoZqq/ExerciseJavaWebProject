package com.mall.service;

import com.mall.dto.PageBean;
import com.mall.pojo.Product;

public interface ProductService {
	public PageBean findProduct(PageBean pageBean);
	
	public boolean deleteProduct(Integer product_id);
	
	public boolean modifyProduct(Product product);
	
	public boolean addProduct(Product product);
}
