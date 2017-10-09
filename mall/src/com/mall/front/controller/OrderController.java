package com.mall.front.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mall.pojo.Cart;
import com.mall.pojo.Location;
import com.mall.service.CartService;
import com.mall.service.LocationService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Resource(name="cartService")
	CartService cartService;
	@Resource(name="locationService")
	LocationService locationService;
	
	@RequestMapping("goadd")
	public ModelAndView goAddOrder(String cart_ids){
		ModelAndView modelAndView = new ModelAndView();
		if (cart_ids == null || cart_ids.trim().equals("")) {
			modelAndView.setViewName("redirect:/home/gohome.shtml");
			return modelAndView;
		}
		modelAndView.setViewName("order");
		String[] idsList = cart_ids.split(" ");
		Set<Integer> cart_idsSet = new HashSet<Integer>();
		for (String idStr : idsList) {
			cart_idsSet.add(Integer.parseInt(idStr));
		}
		//添加已被勾选的cart,这里还要考虑一下再service使用循环是否合理
		List<Cart> cartsList = cartService.findCartByCartIdSet(cart_idsSet);
		modelAndView.addObject("cartsList",cartsList);
		//在这里添加省份表,用以添加收货地址,也可以在点击添加时ajax,但是数据量较小,直接传过去了
		List<Location> locationslist = locationService.findProvince();
		modelAndView.addObject("locationslist",locationslist);
		
		return modelAndView;
	}
}
