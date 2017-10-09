package com.mall.front.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mall.pojo.Cart;
import com.mall.service.CartService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource(name="cartService")
	CartService cartService;
	@RequestMapping("goadd")
	public ModelAndView goAddOrder(String ids){
		String[] idsList = ids.split(" ");
		Set<Integer> cart_idsSet = new HashSet<Integer>();
		for (String idStr : idsList) {
			cart_idsSet.add(Integer.parseInt(idStr));
		}
		List<Cart> cartsList = cartService.findCartByCartIdSet(cart_idsSet);
		ModelAndView modelAndView = new ModelAndView("");
		modelAndView.addObject("cartsList",cartsList);
		return modelAndView;
	}
}
