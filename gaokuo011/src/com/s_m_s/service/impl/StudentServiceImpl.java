package com.s_m_s.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.eclipse.jdt.internal.compiler.codegen.MultiCatchExceptionLabel;
import org.springframework.stereotype.Service;

import com.s_m_s.dao.StudentDao;
import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Student;
import com.s_m_s.service.StudentService;
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Resource(name="studentDao")
	private StudentDao studentDao;

	@Override
	public boolean addStudent(Student student) {
		return studentDao.addStudent(student) > 0;
	}

	@Override
	public boolean deleteStudent(Integer student_id) {
		return studentDao.deleteStudent(student_id) > 0;
	}

	@Override
	public boolean modifyStudent(Student student) {
		return studentDao.modifyStudent(student) > 0;
	}

	@Override
	public PageBean findStudents(PageBean pageBean) {
		List<Student> studentList = studentDao.findStudents(pageBean);
		Integer totalStudents = studentDao.totalStudents(pageBean);
		Integer totalPage = (int) Math.ceil(1.0*totalStudents/pageBean.getLimitEnd());
		pageBean.setobjList(studentList);
		pageBean.setTotalObj(totalStudents);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	
	
}
