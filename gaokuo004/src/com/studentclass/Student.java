package com.studentclass;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private Integer age = 0;
	private String gender;
	private Date birthday;
	public String getName() {
		return name;
	}
	public Student() {
		super();
	}
	public Student(String name, Integer age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	
	public int getId() {
		return id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Student(String name, int age, String gender ,Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", birthday=" + birthday
				+ "]";
	}
	public Student(int id, String name, int age, String gender, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
	}
	
}
