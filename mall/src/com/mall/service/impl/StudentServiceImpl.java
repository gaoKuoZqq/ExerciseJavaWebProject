package com.mall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.StudentDao;
import com.mall.service.StudentService;
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Resource(name="studentDao")
	StudentDao studentDao;
	@Override
	public Integer test() {
		return studentDao.test();
	}
	
}
