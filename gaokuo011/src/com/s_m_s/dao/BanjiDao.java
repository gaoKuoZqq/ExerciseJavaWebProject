package com.s_m_s.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.s_m_s.pojo.Banji;

public interface BanjiDao {
	List<Banji> findAllBanjis();
	
	List<Banji> findAllBanjisCourses();
	
	Integer addBanji(Banji banji);
	
	Integer findBanji_idByBanji_name(String banji_name);
	
	void elective(@Param("banji_id") Integer banji_id,@Param("course_id") Integer course_id);
	
	Integer deleteElective (@Param("banji_id") Integer banji_id,@Param("course_id") Integer course_id);
	
	Integer checkBanjiName(String banji_name);
	
	Integer checkBanji_Course(@Param("banji_id") Integer banji_id,@Param("course_id") Integer course_id);
}
