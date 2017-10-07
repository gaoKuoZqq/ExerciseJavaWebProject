package com.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.CartDao;
import com.mall.pojo.Cart;
import com.mall.service.CartService;
@Service("cartService")
public class CartServiceImpl implements CartService{
	@Resource(name="cartDao")
	CartDao cartDao;

	@Override
	public Boolean addCart(Cart cart) {
		return cartDao.addCart(cart) > 0;
	}

	@Override
	public Boolean deleteCart(Integer cart_id) {
		return cartDao.deleteCart(cart_id) > 0;
	}

	@Override
	public Boolean modifyCart(Cart cart) {
		return cartDao.modifyCart(cart) > 0;
	}

	@Override
	public List<Cart> findCart(Integer user_id) {
		return cartDao.findCart(user_id);
	}

	@Override
	public void modifyCartChecked(Integer user_id) {
		cartDao.modifyCartChecked(user_id);
	}

}
