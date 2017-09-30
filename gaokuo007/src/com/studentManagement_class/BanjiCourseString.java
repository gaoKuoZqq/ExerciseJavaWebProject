package com.studentManagement_class;

public class BanjiCourseString {
	private Integer banjiId;
	private String banjiName;
	private String courses;
	private Integer banjiCredit;
	public Integer getBanjiId() {
		return banjiId;
	}
	public BanjiCourseString(Integer banjiId, String banjiName, String courses, Integer banjiCredit) {
		super();
		this.banjiId = banjiId;
		this.banjiName = banjiName;
		this.courses = courses;
		this.banjiCredit = banjiCredit;
	}
	public Integer getBanjiCredit() {
		return banjiCredit;
	}
	public void setBanjiCredit(Integer banjiCredit) {
		this.banjiCredit = banjiCredit;
	}
	public void setBanjiId(Integer banjiId) {
		this.banjiId = banjiId;
	}
	public String getBanjiName() {
		return banjiName;
	}
	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "BanjiCourseString [banjiId=" + banjiId + ", banjiName=" + banjiName + ", courses=" + courses + "]";
	}
	public BanjiCourseString(Integer banjiId, String banjiName, String courses) {
		super();
		this.banjiId = banjiId;
		this.banjiName = banjiName;
		this.courses = courses;
	}
	public BanjiCourseString() {
		super();
	}
	
}
