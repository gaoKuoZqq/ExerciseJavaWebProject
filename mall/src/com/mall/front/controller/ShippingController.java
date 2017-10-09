package com.mall.front.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.pojo.Shipping;
import com.mall.service.ShippingService;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
	@Resource(name="shippingService")
	ShippingService shippingService;
	
	@RequestMapping("add")
	@ResponseBody
	public Boolean addShipping(Shipping shipping){
		if (shipping == null || 
				shipping.getReceiver_name() == null || shipping.getReceiver_name().trim().equals("") || 
				shipping.getReceiver_mobile() == null || shipping.getReceiver_mobile().trim().equals("") || 
				shipping.getReceiver_address() == null || shipping.getReceiver_address().trim().equals("")) {
			return false;
		}
		return shippingService.addShipping(shipping);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public Boolean deleteShipping(Integer shipping_id){
		return shippingService.deleteShipping(shipping_id);
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public Boolean modifyShipping(Shipping shipping){
		if (shipping == null || 
				shipping.getReceiver_name() == null || shipping.getReceiver_name().trim().equals("") || 
				shipping.getReceiver_mobile() == null || shipping.getReceiver_mobile().trim().equals("") || 
				shipping.getReceiver_address() == null || shipping.getReceiver_address().trim().equals("")) {
			return false;
		}
		return shippingService.modifyShipping(shipping);
	}
	
}
