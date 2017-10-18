package com.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.CategoryDao;
import com.mall.pojo.Category;
import com.mall.service.CategoryService;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource(name="categoryDao")
	CategoryDao categoryDao;
	@Override
	public List<Category> findRootCategory() {
		return categoryDao.findRootCategory();
	}
	
	@Override
	public List<Category> findCategoryByParent_id(Integer parent_id) {
		return categoryDao.findCategoryByParent_id(parent_id);
	}
}
