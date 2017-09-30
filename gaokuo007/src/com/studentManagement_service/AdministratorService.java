package com.studentManagement_service;

import com.studentManagement_class.Administrator;
import com.studentManagement_dao.IAdministratorDao;
import com.studentManagement_daoimpl.AdministratorDaoImpl;

public class AdministratorService {
	public boolean login(Administrator administrator) {
		IAdministratorDao administratorDao = new AdministratorDaoImpl();
		
		return administratorDao.login(administrator);
	}
}
