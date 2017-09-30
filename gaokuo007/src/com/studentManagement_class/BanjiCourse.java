package com.studentManagement_class;

public class BanjiCourse {
	private Banji banji;
	private String courseName;
	private Integer credit;
	public Banji getBanji() {
		return banji;
	}
	public void setBanji(Banji banji) {
		this.banji = banji;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "BanjiCourse [banji=" + banji + ", courseName=" + courseName + ", credit=" + credit + "]";
	}
	public BanjiCourse(Banji banji, String courseName, Integer credit) {
		super();
		this.banji = banji;
		this.courseName = courseName;
		this.credit = credit;
	}
	public BanjiCourse() {
		super();
	}
	
}
