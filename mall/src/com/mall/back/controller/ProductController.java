package com.mall.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.pojo.Category;
import com.mall.pojo.Product;
import com.mall.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource(name="productService")
	ProductService productService;
	@RequestMapping("/find")
	public ModelAndView findProduct() {
		ModelAndView modelAndView = new ModelAndView();
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
}
