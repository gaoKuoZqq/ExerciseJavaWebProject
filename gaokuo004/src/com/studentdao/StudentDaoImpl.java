package com.studentdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.studentclass.Student;
import com.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public int addStudent(Student student) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into student(name,age,gender,birthday) values(?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setDate(4, new java.sql.Date(student.getBirthday().getTime()));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return result;
	}

	@Override
	public int deleteStudent(int id) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from student where id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return result;
	}

	@Override
	public int modifyStudent(Student student) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "update student set name=?,age=?,gender=?,birthday=? where id=?;";
			preparedStatement =  connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setDate(4, new java.sql.Date(student.getBirthday().getTime()));
			preparedStatement.setInt(5, student.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return result;
	}

	@Override
	public List<Student> queryStudents(Student student, int pageIndex, int pageSize) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT * FROM student WHERE 1=1";
			List<String> list = new ArrayList<String>();
			
			if (student.getName() != null && !"".equals(student.getName())) {
				sql = sql + " and name like ?";
				list.add("%"+student.getName()+"%");
			}
			
			if (student.getAge() != 0) {
				sql = sql + " and age=?";
				list.add(String.valueOf(student.getAge()));
			}
			
			if (student.getGender() != null && !"".equals(student.getGender())) {
				sql = sql + " and gender=?";
				list.add(student.getGender());
			}
			sql = sql+" limit ?,?";
			preparedStatement =  connection.prepareStatement(sql);
			int i = 1;
			for (; i <= list.size(); i++) {
				preparedStatement.setString(i, list.get(i-1));
			}
			preparedStatement.setInt(i, (pageIndex-1)*pageSize);
			i = i+1;
			preparedStatement.setInt(i, pageSize);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				Date birthday = resultSet.getDate("birthday");
				Student stu = new Student(id,name,age,gender,birthday);
				studentList.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection, preparedStatement);	
		}
		
		return studentList;
	}

	
	public int totalStudents(Student student) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT count(*) FROM student WHERE 1=1";
			
			List<String> list = new ArrayList<String>();
			
			if (student.getName() != null && !"".equals(student.getName())) {
				sql = sql + " and name like ?";
				list.add("%"+student.getName()+"%");
			}
			
			if (String.valueOf(student.getAge()) != null && student.getAge() != 0) {
				sql = sql + " and age=?";
				list.add(String.valueOf(student.getAge()));
			}
			
			if (student.getGender() != null && !"".equals(student.getGender())) {
				sql = sql + " and gender=?";
				list.add(student.getGender());
			}
			
			preparedStatement =  connection.prepareStatement(sql);
			
			for (int i = 1; i <= list.size(); i++) {
				preparedStatement.setString(i, list.get(i-1));
			}
							
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				result = resultSet.getInt("count(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection, preparedStatement);	
		}
		
		return result;
	}

	@Override
	public int chackName(String name) {
		java.sql.PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		int result = 0;
		
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select count(*) from student where name=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				result = resultSet.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}
		
		return result;
	}

}
