package com.administrator.dao;

import java.util.List;

import com.administrator.Administrator;

public interface IAdministratorDao {
	
	int register(Administrator administrator);
	
	int modifyPassWord(Administrator administrator);
	
	List<Administrator> queryAllAdministrator();
	
	boolean login(Administrator administrator);
}
