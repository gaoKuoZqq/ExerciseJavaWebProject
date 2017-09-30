package com.studentManagement_servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentManagement_class.BanjiCourseString;
import com.studentManagement_class.PageBean;
import com.studentManagement_service.BanjiService;
import com.util.ListMapToJson;

public class BanjiServlet extends BaseServlet{
	private void queryBanjis(HttpServletRequest req, HttpServletResponse resp){
		

		Integer pageIndex = 1;
		Integer pageSize = 3;
		
		ServletContext servletContext = getServletContext();
		
		//获取分页信息
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		if (pageIndexStr != null && !"".equals(pageIndexStr)) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}

		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		//获得结果列表
		List<BanjiCourseString> list = (List<BanjiCourseString>) req.getAttribute("banjiCourseStringList");
		Integer end = (pageIndex-1)*pageSize+pageSize;
		if (end >= list.size()) {
			end = list.size();
		}
		List<BanjiCourseString> pageList = list.subList((pageIndex-1)*pageSize, end);
		//获得结果总数
		int totalStudents = list.size();
		//计算页数
		int totalPage = (int) Math.ceil(1.0*totalStudents/pageSize);
		//封装pageBean
		PageBean pageBean = new PageBean(pageIndex, pageSize, totalStudents, totalPage, pageList);
		req.setAttribute("pageBean", pageBean);
		
		try {
			req.getRequestDispatcher("/jsp/banji_findall_test.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	private void addBanji(HttpServletRequest req, HttpServletResponse resp) {
		BanjiService banjiService = new BanjiService();
		String coursesIdString = req.getParameter("coursesId");
		String banjiName = req.getParameter("banjiName");
		String  regex = " ";
		String[] coursesIds = coursesIdString.split(regex);
		HashSet<String> coursesIdSet = new HashSet<String>();
		for (String string : coursesIds) {
			coursesIdSet.add(string);
		}
		
		boolean isSuccess = banjiService.addBanji(banjiName, coursesIdSet);
		resp.setContentType("charset=utf-8");
	    try {
			resp.getWriter().write("{\"isSuccess\":" + isSuccess + "}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void electiveCourses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/course_elective_test.jsp").forward(req, resp);
	}
	
	private void queryCourseForBanji(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException {
		Thread.sleep(500);//这里休眠避免添加或者删除课程后列表未更新就去查询了"等等那帮小伙子"
		BanjiService banjiService = new BanjiService();
		Integer banjiId = Integer.parseInt(req.getParameter("banjiId"));
		resp.setContentType("text/html;charset=utf-8");
		List<Map<String,Object>> list = banjiService.queryCourseForBanji(banjiId);
		String result = ListMapToJson.toJson(list);
		resp.getWriter().write(result);
	}
	
	private void checkName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BanjiService banjiService = new BanjiService();
		String banjiName = req.getParameter("banjiName");
		resp.setContentType("charset=utf-8");
		boolean isExit = banjiService.checkName(banjiName);
		resp.getWriter().write("{\"isSuccess\":" + isExit + "}");
	}
	
	private void delLine(HttpServletRequest req, HttpServletResponse resp) {
		BanjiService banjiService = new BanjiService();
		String banjiIdStr = req.getParameter("banji_id");
		String courseIdStr = req.getParameter("course_id");
		Integer banji_id = Integer.parseInt(banjiIdStr);
		Integer course_id = Integer.parseInt(courseIdStr);
		banjiService.delLine(banji_id, course_id);
	}
	
	private void addLine(HttpServletRequest req, HttpServletResponse resp) {
		BanjiService banjiService = new BanjiService();
		String coursesIdStr = req.getParameter("coursesId");
		String banjiIdStr = req.getParameter("banji_id");
		String  regex = " ";
		String[] coursesIds = coursesIdStr.split(regex);
		HashSet<String> coursesIdSet = new HashSet<String>();
		for (String string : coursesIds) {
			coursesIdSet.add(string);
		}
		banjiService.addLine(banjiIdStr, coursesIdSet);
	}
	
}
