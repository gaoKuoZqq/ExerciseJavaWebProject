package com.s_m_s.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.s_m_s.dao.CourseDao;
import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Course;
import com.s_m_s.service.CourseService;
@Service("courseService")
public class CourseServiceImpl implements CourseService{
	@Resource(name="courseDao")
	CourseDao courseDao;
	@Override
	public List<Course> findAllCourses() {
		return courseDao.findAllCourses();
	}
	@Override
	public PageBean findCourse(PageBean pageBean) {
		pageBean.setLimitStar((pageBean.getPageIndex()-1)*pageBean.getLimitEnd());
		List<Course> coursesList = courseDao.findCourses(pageBean);
		pageBean.setTotalObj(findAllCourses().size());//调用上面的方法获取总数
		pageBean.setTotalPage((int)Math.ceil(pageBean.getTotalObj()*1.0/pageBean.getLimitEnd()));
		List<Course> coursesListPage = new ArrayList<Course>();
		for(int i = (pageBean.getPageIndex()-1)*pageBean.getLimitEnd(); i < (pageBean.getPageIndex())*pageBean.getLimitEnd() && i < coursesList.size(); i++) {
			coursesListPage.add(coursesList.get(i));
		}
		pageBean.setobjList(coursesListPage);
		return pageBean;
	}
	@Override
	public boolean addCourse(Course course) {
		if (courseDao.checkCourseName(course.getCourse_name()) > 0) {
			return false;
		}
		return courseDao.addCourse(course) > 0;
	}
	@Override
	public boolean checkCourseName(String course_name) {
		return courseDao.checkCourseName(course_name) == 0;
	}
	@Override
	public List<Course> findCoursesByBanjiId(Integer banji_id) {
		return courseDao.findCoursesByBanjiId(banji_id);
	}

}
