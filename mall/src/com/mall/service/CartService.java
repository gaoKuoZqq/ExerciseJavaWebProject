package com.mall.service;

import java.util.List;

import com.mall.pojo.Cart;

public interface CartService {
	
	Boolean addCart(Cart cart);
	
	Boolean deleteCart(Integer cart_id);
	
	Boolean modifyCart(Cart cart);
	
	List<Cart> findCart(Integer user_id);
	
	//注销时将勾选状态变为未勾选
	void modifyCartChecked(Integer user_id);
}
