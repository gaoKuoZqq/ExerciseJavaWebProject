package com.mall.front.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.pojo.Cart;
import com.mall.pojo.Product;
import com.mall.service.CartService;
import com.mall.service.ProductService;
import com.mall.service.UserService;

import jdk.nashorn.internal.ir.BlockLexicalContext;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource(name="cartService")
	CartService cartService;
	@Resource(name="productService")
	ProductService productService;
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping("gocart")
	public ModelAndView goCart(String username) {
		Integer user_id = userService.queryUser_idByUsername(username);
		ModelAndView modelAndView = new ModelAndView("cart");
		List<Cart> cartsList = cartService.findCart(user_id);
		//因为展示需要,往里面塞了个product,但是同时塞了很多没用的东西,因为懒
		for (Cart cart : cartsList) {
			Product product = productService.findProductById(cart.getProduct_id());
			cart.setProduct(product);
		}
		modelAndView.addObject("cartsList",cartsList);
		return modelAndView;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Boolean addCart(Cart cart,String username){
		Integer user_id = userService.queryUser_idByUsername(username);
		cart.setUser_id(user_id);
		cart.setChecked(1);
		Boolean isSuccess = cartService.addCart(cart);
		System.out.println(isSuccess);
		return isSuccess;
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public Boolean modifyCart(Cart cart){
		return cartService.modifyCart(cart);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public Boolean deleteCart(String ids){
		String[] idsList = ids.split(" ");
		for (String idStr : idsList) {
			cartService.deleteCart(Integer.parseInt(idStr.trim()));
		}
		return true;
	}
}
