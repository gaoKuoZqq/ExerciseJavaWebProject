package com.s_m_s.service;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Student;

public interface StudentService {
	boolean addStudent(Student student);
	
	boolean deleteStudent(Integer student_id);
	
	boolean modifyStudent(Student student);
	
	PageBean findStudents(PageBean pageBean);
}
