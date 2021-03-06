package com.mall.service;

import com.mall.dto.PageBean;
import com.mall.pojo.Order;

public interface OrderService {

	Boolean addOrder(Order order);
	
	public PageBean findOrder(PageBean pageBean);
	
	public double queryPaymentByCart_idsList(String[] cart_ids);
}
