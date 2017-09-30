package com.studentManagement_daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentManagement_class.Administrator;
import com.studentManagement_dao.IAdministratorDao;
import com.util.JdbcUtil;

public class AdministratorDaoImpl implements IAdministratorDao{


	@Override
	public int register(Administrator administrator) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into administrator(userName,passWord) values(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, administrator.getUserName());
			preparedStatement.setString(2, administrator.getPassWord());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return result;
	}

	public int modifyPassWord(Administrator administrator) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update administrator set passWord=? where userName=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, administrator.getPassWord());
			preparedStatement.setString(2, administrator.getUserName());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return result;
	}

	@SuppressWarnings("finally")
	@Override
	public List<Administrator> queryAllAdministrator() {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List<Administrator> administratorsList = new <Administrator>ArrayList();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT  * FROM administrator;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String userName = resultSet.getString("userName");
				String passWord = resultSet.getString("passWord");
				Administrator administrator = new Administrator(userName,passWord);
				administratorsList.add(administrator);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection, preparedStatement);
			return administratorsList;
		}
		
	}

	@Override
	public boolean login(Administrator administrator) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT  * FROM administrator where userName=? and password=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, administrator.getUserName());
			preparedStatement.setString(2, administrator.getPassWord());
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return false;
	}


}
