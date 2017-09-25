package com.s_m_s.pojo;

import java.util.Date;

public class Student {
	private Integer student_id;
	private String student_name;
	private Integer student_age;
	private String student_gender;
	private Date student_birthday;
	private Banji student_banji;
	public Integer getStudent_id() {
		return student_id;
	}
	public Student(String student_name, Banji student_banji) {
		super();
		this.student_name = student_name;
		this.student_banji = student_banji;
	}
	public Student(Integer student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Student(Banji student_banji) {
		super();
		this.student_banji = student_banji;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getStudent_age() {
		return student_age;
	}
	public void setStudent_age(Integer student_age) {
		this.student_age = student_age;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public Student(String student_name, Integer student_age, String student_gender, Banji student_banji) {
		super();
		this.student_name = student_name;
		this.student_age = student_age;
		this.student_gender = student_gender;
		this.student_banji = student_banji;
	}
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	//我在这里吧util的date转为了sql的
	public java.sql.Date getStudent_birthday() {
		return new java.sql.Date(student_birthday.getTime());
	}
	public void setStudent_birthday(Date student_birthday) {
		this.student_birthday = student_birthday;
	}
	
	public Date getStudent_birthday_javaUtil() {
		return student_birthday;
	}
	public Banji getStudent_banji() {
		return student_banji;
	}
	public void setStudent_banji(Banji student_banji) {
		this.student_banji = student_banji;
	}
	public Student(Integer student_id, String student_name, Integer student_age, String student_gender,
			Date student_birthday, Banji student_banji) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_age = student_age;
		this.student_gender = student_gender;
		this.student_birthday = student_birthday;
		this.student_banji = student_banji;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_age=" + student_age
				+ ", student_gender=" + student_gender + ", student_birthday=" + student_birthday + ", student_banji="
				+ student_banji + "]";
	}
	public Student(String student_name, Integer student_age, String student_gender, Date student_birthday,
			Banji student_banji) {
		super();
		this.student_name = student_name;
		this.student_age = student_age;
		this.student_gender = student_gender;
		this.student_birthday = student_birthday;
		this.student_banji = student_banji;
	}
	
}
