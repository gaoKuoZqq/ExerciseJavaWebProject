package dao;

import java.util.List;

import dto.PageBean;
import pojo.Student;

public interface StudentDao {
	
	List<Student> findStudentsPage(PageBean pageBean);
	
	Integer totalStudents(PageBean pageBean);
}
