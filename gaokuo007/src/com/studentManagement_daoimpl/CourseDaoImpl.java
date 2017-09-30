package com.studentManagement_daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.studentManagement_class.Banji;
import com.studentManagement_class.Course;
import com.studentManagement_dao.ICourseDao;
import com.sun.javafx.collections.MappingChange.Map;
import com.util.JdbcUtil;

public class CourseDaoImpl implements ICourseDao{

	@Override
	public int addCourse(Course course) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		int result = 0;
		if(checkName(course.getCourseName())) {
			return result;
		}
		try {
			connection = JdbcUtil.getConnection();
			String sql = "INSERT INTO course(NAME,credit) VALUES('" + course.getCourseName() + "','"+ course.getCredit() +"');";
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}
	
	public boolean checkName(String courseName) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from Course where name='"+courseName+"';";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer count = resultSet.getInt("count(*)");
				if (count >= 1) {
					return true;
				}else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return true;
	}
	

}
