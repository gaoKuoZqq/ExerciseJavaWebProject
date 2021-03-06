package com.s_m_s.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.s_m_s.dao.BanjiDao;
import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Course;
import com.s_m_s.service.BanjiService;

@Service
public class BanjiServiceImpl implements BanjiService{
	@Resource(name="banjiDao")
	BanjiDao banjiDao;

	@Override
	public List<Banji> findAllBanjis() {
		return banjiDao.findAllBanjis();
	}

	@Override
	public PageBean findAllBanjisCourses(PageBean pageBean) {
		List<Banji>banjiCoursesListMessy = banjiDao.findAllBanjisCourses();
		List<Banji> banjiCoursesList =  changeBanjiCourseListToDisplay(banjiCoursesListMessy);
		List<Banji> banjiCoursesListPage = new ArrayList<Banji>();
		pageBean.setTotalPage((int)Math.ceil(1.0*banjiCoursesList.size()/pageBean.getLimitEnd()));
		for(int i = (pageBean.getPageIndex()-1)*pageBean.getLimitEnd(); i < (pageBean.getPageIndex())*pageBean.getLimitEnd() && i < banjiCoursesList.size(); i++) {
			banjiCoursesListPage.add(banjiCoursesList.get(i));
		}
		pageBean.setobjList(banjiCoursesListPage);
		return pageBean;
	}

	private List<Banji> changeBanjiCourseListToDisplay(List<Banji> banjiCoursesListMessy) {
		List<Banji> banjiCoursesList = new ArrayList<Banji>();
		List<Course> banji_courseList = null;
		Set<Integer> banji_idSet = new HashSet<Integer>();
		//挑选班级id作为唯一标识
		for (Banji banji : banjiCoursesListMessy) {
			banji_idSet.add(banji.getBanji_id());
		}
		for (Integer banjiId : banji_idSet) {
			Banji banjiDisplay = new Banji();
			banjiDisplay.setBanji_courses_name("");//避免下面出现空指针
			banjiDisplay.setBanji_totalCredits(0);//同上
			for (Banji banji : banjiCoursesListMessy) {
				if (banjiId == banji.getBanji_id()) {
					banjiDisplay.setBanji_id(banjiId);
					banjiDisplay.setBanji_name(banji.getBanji_name());
					banji_courseList = banji.getBanji_courseList();
					for (Course course : banji_courseList) {
						//这里不会出现空指针,因为我在前面给它赋值了
						banjiDisplay.setBanji_courses_name(banjiDisplay.getBanji_courses_name() + course.getCourse_name() + " ");
						banjiDisplay.setBanji_totalCredits(banjiDisplay.getBanji_totalCredits() + course.getCourse_credit());
					}
				}
			}
			banjiCoursesList.add(banjiDisplay);
		}
		return banjiCoursesList;
	}

	@Override
	public boolean addBanji(Banji banji, Set<String> coursesIdSet) {
		if (checkBanjiName(banji.getBanji_name())) {
			return false;
		}
		boolean result = banjiDao.addBanji(banji) > 0;
		Integer banji_id = banjiDao.findBanji_idByBanji_name(banji.getBanji_name());
		for (String courseId : coursesIdSet) {
			elective(banji_id,Integer.parseInt(courseId));
		}
		return result;
		
	}
	
	public void elective(Integer banji_id, Integer course_id){
		banjiDao.elective(banji_id, course_id);
	}
	
	public boolean checkBanjiName(String banji_name){
		return banjiDao.checkBanjiName(banji_name)  > 0;
	}

	@Override
	public void elective(Integer banji_id, Set<String> coursesIdSet) {
		for (String course_id : coursesIdSet) {
			if (banjiDao.checkBanji_Course(banji_id, Integer.parseInt(course_id)) == 0) {
				elective(banji_id,Integer.parseInt(course_id));
			}
		}
	}

	@Override
	public boolean deleteElective(Integer banji_id, Integer course_id) {
		return banjiDao.deleteElective(banji_id, course_id) > 0;
	}
	
}
