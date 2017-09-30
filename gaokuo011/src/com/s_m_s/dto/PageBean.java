package com.s_m_s.dto;

import java.util.List;

import com.s_m_s.pojo.Student;

public class PageBean {
	private Integer pageIndex;
	private Integer limitStar;
	private Integer limitEnd;
	private Integer totalObj;
	private Integer totalPage;
	private List objList;
	private Student student;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public PageBean(Student student) {
		super();
		this.student = student;
	}
	public PageBean(Integer limitStar, Integer limitEnd, Student student) {
		super();
		this.limitStar = limitStar;
		this.limitEnd = limitEnd;
		this.student = student;
	}
	public PageBean(Integer limitStar, Integer limitEnd, Integer totalObj, Integer totalPage, List objList,
			Student student) {
		super();
		this.limitStar = limitStar;
		this.limitEnd = limitEnd;
		this.totalObj = totalObj;
		this.totalPage = totalPage;
		this.objList = objList;
		this.student = student;
	}
	@Override
	public String toString() {
		return "PageBean [limitStar=" + limitStar + ", limitEnd=" + limitEnd + ", totalObj=" + totalObj + ", totalPage="
				+ totalPage + ", objList=" + objList + ", student=" + student + "]";
	}
	public PageBean(Integer limitStar, Integer limitEnd) {
		super();
		this.limitStar = limitStar;
		this.limitEnd = limitEnd;
	}
	public PageBean() {
		super();
	}
	public Integer getLimitStar() {
		return limitStar;
	}
	public void setLimitStar(Integer limitStar) {
		this.limitStar = limitStar;
	}
	public Integer getLimitEnd() {
		return limitEnd;
	}
	public void setLimitEnd(Integer limitEnd) {
		this.limitEnd = limitEnd;
	}
	public Integer getTotalObj() {
		return totalObj;
	}
	public void setTotalObj(Integer totalObj) {
		this.totalObj = totalObj;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<Object> getobjList() {
		return objList;
	}
	public void setobjList(List objList) {
		this.objList = objList;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
