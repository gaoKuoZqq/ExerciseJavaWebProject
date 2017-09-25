package com.s_m_s.pojo;

import java.util.List;

public class Banji {
	private Integer banji_id;
	private String banji_name;
	private List<Course> banji_courseList;
	private String banji_courses_name;//已字符串的形式储存,班级列表页面显示用的
	private Integer banji_totalCredits;//班级列表展示用
	private Integer banji_totalStudents;//班级列表展示用
	public Banji(String banji_name, List<Course> banji_courseList, String banji_courses_name,
			Integer banji_totalCredits, Integer banji_totalStudents) {
		super();
		this.banji_name = banji_name;
		this.banji_courseList = banji_courseList;
		this.banji_courses_name = banji_courses_name;
		this.banji_totalCredits = banji_totalCredits;
		this.banji_totalStudents = banji_totalStudents;
	}
	public Banji(String banji_name) {
		super();
		this.banji_name = banji_name;
	}
	public Banji(Integer banji_id, String banji_name, List<Course> banji_courseList, String banji_courses_name,
			Integer banji_totalCredits, Integer banji_totalStudents) {
		super();
		this.banji_id = banji_id;
		this.banji_name = banji_name;
		this.banji_courseList = banji_courseList;
		this.banji_courses_name = banji_courses_name;
		this.banji_totalCredits = banji_totalCredits;
		this.banji_totalStudents = banji_totalStudents;
	}
	public Integer getBanji_totalCredits() {
		return banji_totalCredits;
	}
	public void setBanji_totalCredits(Integer banji_totalCredits) {
		this.banji_totalCredits = banji_totalCredits;
	}
	public Integer getBanji_totalStudents() {
		return banji_totalStudents;
	}
	public void setBanji_totalStudents(Integer banji_totalStudents) {
		this.banji_totalStudents = banji_totalStudents;
	}
	public Banji(Integer banji_id, String banji_name, String banji_courses_name) {
		super();
		this.banji_id = banji_id;
		this.banji_name = banji_name;
		this.banji_courses_name = banji_courses_name;
	}
	public String getBanji_courses_name() {
		return banji_courses_name;
	}
	public void setBanji_courses_name(String banji_courses_name) {
		this.banji_courses_name = banji_courses_name;
	}
	@Override
	public String toString() {
		return "Banji [banji_id=" + banji_id + ", banji_name=" + banji_name + ", banji_courseList=" + banji_courseList
				+ ", banji_courses_name=" + banji_courses_name + ", banji_totalCredits=" + banji_totalCredits
				+ ", banji_totalStudents=" + banji_totalStudents + "]";
	}
	public Banji(Integer banji_id, String banji_name, List<Course> banji_courseList) {
		super();
		this.banji_id = banji_id;
		this.banji_name = banji_name;
		this.banji_courseList = banji_courseList;
	}
	public Integer getBanji_id() {
		return banji_id;
	}
	public List<Course> getBanji_courseList() {
		return banji_courseList;
	}
	public void setBanji_courseList(List<Course> banji_courseList) {
		this.banji_courseList = banji_courseList;
	}
	public void setBanji_id(Integer banji_id) {
		this.banji_id = banji_id;
	}
	public String getBanji_name() {
		return banji_name;
	}
	public void setBanji_name(String banji_name) {
		this.banji_name = banji_name;
	}
	public Banji(Integer banji_id, String banji_name) {
		super();
		this.banji_id = banji_id;
		this.banji_name = banji_name;
	}
	public Banji() {
		super();
	}
	public Banji(Integer banji_id) {
		super();
		this.banji_id = banji_id;
	}
	
}
