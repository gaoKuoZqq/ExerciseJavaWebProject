package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import dto.PageBean;
import pojo.Student;
import service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao studentDao;

	public PageBean findStudentPage(PageBean pageBean) {
		Integer totalStudent = studentDao.totalStudents(pageBean);
		List<Student> studentsList = studentDao.findStudentsPage(pageBean);
		pageBean.setObjectsList(studentsList);
		pageBean.setTotalObjects(totalStudent);
		return pageBean;
	}

}
