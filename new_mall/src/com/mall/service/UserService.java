package com.mall.service;

import com.mall.pojo.User;

public interface UserService {
	
	boolean addUser(User user);
	
	boolean modifyUser(User user);
	
	//用于注册验证用户名
	boolean checkName(String username);
		
	//登陆时用于验证用户名和密码
	boolean checkLogin(User user);
		
}
