package com.mall.front.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.pojo.User;
import com.mall.service.CartService;
import com.mall.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	UserService userService;
	@Resource(name="cartService")
	CartService cartService;
	@RequestMapping("gologin")
	public ModelAndView goLogin(){
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	                            
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
	
	@RequestMapping("login")
	@ResponseBody
	public Boolean checkLogin(User user,HttpServletRequest request) {
		Boolean isSuccess = userService.checkLogin(user);
		if(isSuccess){
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user.getUsername());
		}
		return isSuccess;
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public Boolean logout(String username,HttpServletRequest request){
		HttpSession session = request.getSession(true);
		session.setAttribute("username", null);
		Integer user_id = userService.queryUser_idByUsername(username);
		cartService.modifyCartChecked(user_id);
		return true;
	}
	
	public Boolean checkRole(String username) {
		return userService.checkRole(username);
	}
}
