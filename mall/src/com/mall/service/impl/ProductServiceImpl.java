package com.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.ProductDao;
import com.mall.dto.PageBean;
import com.mall.pojo.Category;
import com.mall.pojo.Product;
import com.mall.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Resource(name="productDao")
	ProductDao productDao;
	@Override
	public PageBean findProduct(PageBean pageBean) {
		
		Integer totalProduct = productDao.totalProduct(pageBean);
		Integer totalPage = (int) Math.ceil(1.0*totalProduct/pageBean.getPageSize());
		//避免出现页码超范围
		if (totalPage < pageBean.getPageIndex()) {
			pageBean.setPageIndex(totalPage);
			pageBean.setLimitStart((totalPage - 1) * pageBean.getPageSize());
		}
		List<Product> productsList = productDao.findProduct(pageBean);
		
		pageBean.setObjList(productsList);
		pageBean.setTotalObj(totalProduct);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public boolean deleteProduct(Integer product_id) {
		return productDao.deleteProduct(product_id) > 0;
		}

	@Override
	public boolean modifyProduct(Product product) {
		return productDao.modifyProduct(product) > 0;
	}

	@Override
	public boolean addProduct(Product product) {
		return productDao.addProduct(product) > 0;
	}

}
