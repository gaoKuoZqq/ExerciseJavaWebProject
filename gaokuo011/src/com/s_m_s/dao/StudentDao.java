package com.s_m_s.dao;

import java.util.List;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Student;

public interface StudentDao {
	Integer addStudent(Student student);
	
	Integer deleteStudent(Integer student_id);
	
	Integer modifyStudent(Student student);
	
	List<Student> findStudents(PageBean pageBean);
	
	Integer totalStudents(PageBean pageBean);
}
