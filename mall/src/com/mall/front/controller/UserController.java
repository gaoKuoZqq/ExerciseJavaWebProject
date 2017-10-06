package com.mall.front.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.pojo.User;
import com.mall.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping("adduser")
	@ResponseBody
	public Boolean addUser(User user) {
		if (user == null || user.getUsername() == null || user.getUsername().trim().equals("")
				|| user.getPassword() == null || user.getPassword().trim().equals("")
				|| user.getEmail() == null || user.getEmail().trim().equals("") 
				|| user.getQuestion() == null || user.getQuestion().trim().equals("") 
				|| user.getAnswer() == null || user.getAnswer().trim().equals("") ) {
			return false;
		}
		if (user.getRole() == null || user.getRole() != 0) {
			user.setRole(1);
		}
		return userService.addUser(user);
	}
	
	@RequestMapping("modifyuser")
	@ResponseBody
	public Boolean modifyUser(User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("checkname")
	@ResponseBody
	public Boolean checkName(String username) {
		return userService.checkName(username);
	}
	
	public Boolean checkLogin(User user) {
		return userService.checkLogin(user);
	}
	
	public Boolean checkRole(String username) {
		return userService.checkRole(username);
	}
}
