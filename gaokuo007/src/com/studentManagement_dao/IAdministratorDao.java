package com.studentManagement_dao;

import java.util.List;

import com.studentManagement_class.Administrator;

public interface IAdministratorDao {
	
	int register(Administrator administrator);
	
	int modifyPassWord(Administrator administrator);
	
	List<Administrator> queryAllAdministrator();
	
	boolean login(Administrator administrator);
}
