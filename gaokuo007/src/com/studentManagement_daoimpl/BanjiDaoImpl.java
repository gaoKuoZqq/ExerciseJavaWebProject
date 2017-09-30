package com.studentManagement_daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.studentManagement_class.Banji;
import com.studentManagement_class.BanjiCourse;
import com.studentManagement_class.Course;
import com.studentManagement_dao.IBanjiDao;
import com.util.JdbcUtil;

public class BanjiDaoImpl implements IBanjiDao{

	@Override
	public List<Banji> queryBanjis() {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List<Banji> banjisList = new ArrayList<Banji>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from banji";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int banjiId = resultSet.getInt("id");
				String banjiName = resultSet.getString("name");
				Banji banji = new Banji(banjiId,banjiName);
				banjisList.add(banji);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return banjisList;
	}

	@Override
	public List<Course> queryCourses() {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List<Course> coursesList = new ArrayList<Course>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from course";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String courseName = resultSet.getString("name");
				int credit = resultSet.getInt("credit");
				Course course = new Course(id,courseName, credit);
				coursesList.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return coursesList;
	}

	@Override
	public List<BanjiCourse> queryBanjiCourses() {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List<BanjiCourse> banjiCoursesList = new ArrayList<BanjiCourse>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT b.id, b.name AS 'banjiname',c.name AS 'coursename',c.credit "
					+ "FROM banji AS b INNER JOIN banji_course bc "
					+ "ON b.id=bc.banji_id INNER JOIN course AS c "
					+ "ON bc.course_id=c.id ORDER BY b.name;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String banjiName = resultSet.getString("banjiname");
				String courseName = resultSet.getString("coursename");
				int credit = resultSet.getInt("credit");
				Banji banji = new Banji(id,banjiName);
				BanjiCourse banjiCourse = new BanjiCourse(banji,courseName,credit);
				
				banjiCoursesList.add(banjiCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return banjiCoursesList;
	}

	@Override
	public int addBanji(String banjiName,HashSet<String> coursesIdSet) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		int result = 0;
		if (checkName(banjiName)) {
			return result;
		}
		try {
			connection = JdbcUtil.getConnection();
			String sql = "INSERT INTO banji(NAME) VALUES('" + banjiName + "');";
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		if (result > 0) {
			addCourseForBanji(banjiName, coursesIdSet);
		}
		return result;
	}
	
	private void addCourseForBanji(String banjiName, HashSet<String> coursesIdSet) {

		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from banji where name='"+banjiName+"';";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			Integer banjiId = null;
			if (resultSet.next()) {
				banjiId = resultSet.getInt("id");
			}
			sql = "INSERT INTO banji_course(banji_id,course_id) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			for (String courseId : coursesIdSet) {
				preparedStatement.setInt(1, banjiId);
				preparedStatement.setInt(2, Integer.parseInt(courseId));
		        preparedStatement.addBatch();
			}
		    preparedStatement.executeBatch();
		    preparedStatement.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
	}
	
	public void addLine(String banjiId, HashSet<String> coursesIdSet) {

		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "INSERT INTO banji_course(banji_id,course_id) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			for (String courseId : coursesIdSet) {
				preparedStatement.setString(1, banjiId);
				preparedStatement.setInt(2, Integer.parseInt(courseId));
		        preparedStatement.addBatch();
			}
		    preparedStatement.executeBatch();
		    preparedStatement.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
	}
	
	public boolean checkName(String banjiName) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from banji where name='"+banjiName+"';";
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

	@Override
	public List<Map<String,Object>> queryCourseForBanji(Integer banjiId) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> CoursesForBanjiList = new ArrayList<Map<String, Object>>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT banji.id AS banji_id, banji.name AS banji_name, "
					+ "course.id as course_id, course.name as course_name, course.credit as course_credit "
					+ "FROM banji RIGHT JOIN banji_course "
					+ "ON banji.id=banji_course.banji_id RIGHT JOIN course "
					+ "ON banji_course.course_id=course.id WHERE banji.id="+banjiId+";";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
	         ResultSetMetaData md = resultSet.getMetaData();// 结果集(rs)的结构信息，比如字段数、字段名等。
	         int columnCount = md.getColumnCount();// 取得查询出来的字段个数
	         while (resultSet.next()) {// 迭代rs
	            // 新建一个map集合 将查询出内容按照字段名：值 的键值对形式存储在map集合中
	        	 HashMap<String, Object> rowData = new HashMap<String, Object>();
	            for (int i = 1; i <= columnCount; i++) {// 循环所有查询出字段
	               rowData.put(md.getColumnLabel(i), resultSet.getObject(i));
	               // getColumnName(i) 获取第i个列名
	               // getObject(i) 获取第i个对象的值
	            }
	            CoursesForBanjiList.add((Map<String, Object>) rowData);// 将map放入list集合中

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}
		return CoursesForBanjiList;
	}

	@Override
	public void delLine(Integer banji_id, Integer course_id) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "DELETE FROM banji_course WHERE banji_id="+banji_id+" AND course_id="+course_id+";";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(connection, preparedStatement);
		}
	
	}
}
