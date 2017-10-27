package com.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.easyui.EasyUIDataGrideResult;
import com.crm.pojo.User;
import com.crm.responce.ServerResponse;
import com.crm.service.IUserService;

import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.util.AddAliasesVisitor;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	IUserService userService;
	
	@RequestMapping("index")
	public String index(){
		return "user";
	}
	
	@RequestMapping("find")
	@ResponseBody
	public EasyUIDataGrideResult find(Integer page, Integer rows, User user) {
		return userService.find(page,rows,user);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ServerResponse<?> delete(String ids){
		return userService.delete(ids);
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ServerResponse<?> add(User user){
		return userService.add(user);
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ServerResponse<?> update(User user){
		return userService.update(user);
	}
}
