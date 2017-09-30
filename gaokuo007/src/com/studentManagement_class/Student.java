package com.studentManagement_class;

import java.util.Date;

public class Student {
	private int id;
	public Student(int id, String name, Integer age, String gender, Date birthday, Banji banji) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.banji = banji;
	}
	private String name;
	private Integer age = 0;
	private String gender;
	private Date birthday;
	private Banji banji;
	public int getId() {
		return id;
	}
	public Banji getBanji() {
		return banji;
	}
	public void setBanji(Banji banji) {
		this.banji = banji;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public Student() {
		super();
	}
	public Student(String name, Integer age, String gender, Banji banji) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.banji = banji;
	}
	public Student(String name, Integer age, String gender, Date birthday, Banji banji) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.banji = banji;
	}
	public String getGender() {
		return gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Banji getbanji() {
		return banji;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", birthday=" + birthday
				+ ", banji=" + banji + "]";
	}
	
	
	
	
}
