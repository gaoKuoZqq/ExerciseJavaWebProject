package com.studentManagement_class;

import java.util.List;

public class PageBean {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalStudents;
	private Integer totalPage;
	private List list;
	public PageBean(Integer pageIndex, Integer pageSize, int totalStudents, int totalPage,List list) {
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
