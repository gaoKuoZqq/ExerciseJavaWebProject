package com.mall.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.dto.PageBean;
import com.mall.pojo.Category;
import com.mall.pojo.Product;
import com.mall.service.CategoryService;
import com.mall.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource(name="productService")
	ProductService productService;
	//还是要用到
	@Resource(name="categoryService")
	CategoryService categoryService;
	@RequestMapping("/find")
	public ModelAndView findProduct(PageBean pageBean) {
		if (pageBean.getPageIndex() == null || pageBean.getPageIndex() == 0) {
			pageBean.setPageIndex(1);
		}
		if (pageBean.getPageSize() == null || pageBean.getPageSize() == 0) {
			pageBean.setPageSize(3);
		}
		
		Integer pageIndex = pageBean.getPageIndex();
		Integer pageSize  = pageBean.getPageSize();
		pageBean.setLimitStart((pageIndex - 1) * pageSize);
		ModelAndView modelAndView = new ModelAndView();
		pageBean= productService.findProduct(pageBean);
		List<Category> rootCategoriesList = categoryService.findRootCategory();
		modelAndView.addObject("rootCategoriesList", rootCategoriesList);
		modelAndView.addObject(pageBean);
		modelAndView.setViewName("product_find");
		return modelAndView;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public boolean addCategory(Product product) {
		if ((product.getName() == null || "".equals(product.getName().trim()) || product.getName().length()>40) || 
				(product.getPrice() <= 0)) {
			return false;
		}
		return productService.addProduct(product);
	}
	@RequestMapping("/goadd")
	public ModelAndView goAddCategory() {
		ModelAndView modelAndView = new ModelAndView();
		//List<Category> rootCategoriesList = productService.findRootCategory();
		//modelAndView.addObject("rootCategoriesList", rootCategoriesList);
		//modelAndView.setViewName("category_add");
		return modelAndView;
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public boolean deleteProduct(Integer id) {
		return productService.deleteProduct(id);
	}
}
