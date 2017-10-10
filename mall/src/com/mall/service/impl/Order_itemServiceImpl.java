package com.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.Order_itemDao;
import com.mall.pojo.Order_item;
import com.mall.service.Order_itemService;
@Service("order_itemService")
public class Order_itemServiceImpl implements Order_itemService{
	@Resource(name="order_itemDao")
	Order_itemDao order_itemDao;
	@Override
	public Boolean addOrder_item(Order_item order_item) {
		return order_itemDao.addOrder_item(order_item) > 0;
	}

}
