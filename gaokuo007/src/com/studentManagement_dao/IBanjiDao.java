package com.studentManagement_dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.studentManagement_class.Banji;
import com.studentManagement_class.BanjiCourse;
import com.studentManagement_class.Course;

public interface IBanjiDao {
	List<Banji> queryBanjis();
	
	List<Course> queryCourses();
	
	List<BanjiCourse> queryBanjiCourses();
	
	int addBanji (String banjiName,HashSet<String> coursesIdSet);
	
	boolean checkName(String banjiName);
	
	public List<Map<String,Object>> queryCourseForBanji(Integer banjiId);
	
	void delLine(Integer banji_id, Integer course_id);
	
	void addLine(String banjiId, HashSet<String> coursesIdSet);
}
