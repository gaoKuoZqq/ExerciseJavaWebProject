package com.studentManagement_class;

public class Course {
	private int id;
	private String courseName;
	private Integer credit;
	public Course(int id, String courseName, Integer credit) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.credit = credit;
	}
	public Course(String courseName, Integer credit) {
		super();
		this.courseName = courseName;
		this.credit = credit;
	}
	public int getId() {
		return id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public Integer getCredit() {
		return credit;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", credit=" + credit + "]";
	}
	
}
