package com.s_m_s.pojo;

public class Course {
	private Integer course_id;
	private String course_name;
	private Integer course_credit;
	public Course(Integer course_id, String course_name, Integer course_credit) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_credit = course_credit;
	}
	public Course(String course_name, Integer course_credit) {
		super();
		this.course_name = course_name;
		this.course_credit = course_credit;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_credit=" + course_credit
				+ "]";
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Integer getCourse_credit() {
		return course_credit;
	}
	public void setCourse_credit(Integer course_credit) {
		this.course_credit = course_credit;
	}
}
