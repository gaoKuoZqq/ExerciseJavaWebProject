package com.s_m_s.service;

import java.util.List;
import java.util.Set;

import com.s_m_s.dto.PageBean;
import com.s_m_s.pojo.Banji;
import com.s_m_s.pojo.Student;

public interface BanjiService {
	
	List<Banji> findAllBanjis();
	
	PageBean findAllBanjisCourses(PageBean pageBean);
	
	boolean addBanji(Banji banji,Set<String> coursesIdSet);
	
	void elective(Integer banji_id, Set<String> coursesIdSet);
	
	boolean deleteElective(Integer banji_id, Integer course_id);
	
	boolean checkBanjiName(String banji_name);
}
