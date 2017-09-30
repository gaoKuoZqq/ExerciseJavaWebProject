package com.studentManagement_filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.studentManagement_class.Banji;
import com.studentManagement_class.BanjiCourseString;
import com.studentManagement_class.Course;
import com.studentManagement_service.BanjiService;

/**
 * Servlet Filter implementation class BanjiListFilter
 */
@WebFilter("/BanjiListFilter")
public class BanjiListFilter implements Filter {

    public BanjiListFilter() {
    }

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		BanjiService banjiService = new BanjiService();
		
		System.out.println("BanjiListFilter.doFilter()");
		//班级列表,省事,全部拦截了以后改
		List<Banji> banjisList = banjiService.queryBanjis();
		request.setAttribute("banjisList", banjisList);
		//课程列表
		List<Course> coursesList = banjiService.queryCourses();
		request.setAttribute("coursesList", coursesList);
		//班级,课程以及学分表
		List<BanjiCourseString> banjiCourseStringList = banjiService.queryBanjiCourse();
		request.setAttribute("banjiCourseStringList", banjiCourseStringList);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
