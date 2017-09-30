package com.studentManagement_service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.studentManagement_class.Banji;
import com.studentManagement_class.BanjiCourse;
import com.studentManagement_class.BanjiCourseString;
import com.studentManagement_class.Course;
import com.studentManagement_dao.IBanjiDao;
import com.studentManagement_daoimpl.BanjiDaoImpl;

public class BanjiService {
	public List<Banji> queryBanjis(){
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		return iBanjiDao.queryBanjis();
	}
	
	public List<Course> queryCourses(){
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		return iBanjiDao.queryCourses();
	}
	
	public List<BanjiCourseString> queryBanjiCourse() {
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		List<BanjiCourseString> list = changeBanjiCourse(iBanjiDao.queryBanjiCourses());
		return list;
	}
	
	public List<Map<String,Object>> queryCourseForBanji(Integer banjiId) {
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		return iBanjiDao.queryCourseForBanji(banjiId);
	}
	
	public List<BanjiCourseString> changeBanjiCourse(List<BanjiCourse> list){
		HashSet<Integer> banjiIdSet = new HashSet<Integer>();
		for (BanjiCourse banjiCourse : list) {
			Integer banjiId = banjiCourse.getBanji().getBanjiId();
			banjiIdSet.add(banjiId);
			}
		
		List<BanjiCourseString> banjiCourseStringsList = new ArrayList<BanjiCourseString>();
		
		for (Integer banjiId : banjiIdSet) {
			String banjiName = null;
			Integer credit = 0;
			for (BanjiCourse banjiCourse : list) {
				if (banjiCourse.getBanji().getBanjiId() == banjiId) {
					banjiName = banjiCourse.getBanji().getBanjiName();
					credit = credit + banjiCourse.getCredit();
				}
			}
			
			String course = "";
			for (BanjiCourse banjiCourse : list) {
				if (banjiCourse.getBanji().getBanjiId() == banjiId) {
					course = course + banjiCourse.getCourseName()+" ";
				}
			}
			BanjiCourseString banjiCourseString = new BanjiCourseString(banjiId,banjiName,course,credit);
			banjiCourseStringsList.add(banjiCourseString);
		}
		return banjiCourseStringsList;
	}
	
	public boolean addBanji(String banjiName,HashSet<String> coursesIdSet) {
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		if (banjiName.length() < 2 || banjiName.length() > 10) {
			return false;
		}
		return iBanjiDao.addBanji(banjiName, coursesIdSet) > 0;
	}
	
	public boolean checkName(String banjiName) {
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		return iBanjiDao.checkName(banjiName);
	}
	
	public void delLine(Integer banji_id, Integer course_id) {
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		iBanjiDao.delLine(banji_id, course_id);
	}
	
	public void addLine(String banjiId, HashSet<String> coursesIdSet) {
		IBanjiDao iBanjiDao = new BanjiDaoImpl();
		iBanjiDao.addLine(banjiId, coursesIdSet);
	}
}
