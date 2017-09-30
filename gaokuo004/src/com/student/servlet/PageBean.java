package com.student.servlet;

import java.util.List;

import com.studentclass.Student;

public class PageBean {
	Integer pageIndex;
	Integer pageSize;
	Integer totalStudents;
	Integer totalPage;
	List<Student> list;
	public PageBean(Integer pageIndex, Integer pageSize, int totalStudents, int totalPage,List<Student> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalStudents = totalStudents;
		this.totalPage = totalPage;
		this.list = list;
	}
	public List<Student> getList() {
		return list;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", totalStudents=" + totalStudents
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	public Integer getPageSize() {
		return pageSize;
	}
	
	
	public int getTotalStudents() {
		return totalStudents;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
}
