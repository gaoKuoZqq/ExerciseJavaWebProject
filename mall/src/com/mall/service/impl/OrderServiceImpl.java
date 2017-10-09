package com.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.OrderDao;
import com.mall.pojo.Order;
@Service("orderService")
public class OrderServiceImpl implements com.mall.service.OrderService{
	@Resource(name="orderDao")
	OrderDao orderDao;
	@Override
	public Boolean addOrder(Order order) {
		return orderDao.addOrder(order) > 0;
	}

}
