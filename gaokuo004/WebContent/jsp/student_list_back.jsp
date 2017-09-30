<%@page import=" com.student.servlet.PageBean"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=" com.student.servlet.PageBean"%>
<%@ page import="com.studentclass.Student" %>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/jsp/lib/jquery/jquery-3.2.1.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath}/jsp/lib/js/bootstrap.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/my.css">
</head>
<body>
	<div class="container" style="width:70%">
		<% 
			PageBean pageBean = (PageBean)request.getAttribute("pageBean");
			List<Student> list = pageBean.getList();
		%>
		<form action="${pageContext.request.contextPath}/student?method=searchByCondition" method="post">
			姓名：<input type="text" name="name"/>
			年龄:<input type="text" name="age"/>
			性别：<select name="gender">
					<option value="">不限</option>
					<option value="男">男</option>
					<option value="女">女</option>
			    </select>
			<input type="submit" value="搜索"/>
		</form>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/html/add_student.html">添加</a>
		<table style="width: 700px;" class="align-center table table-striped table-bordered table-hover table-condensed">
			<tr>  
				<td>id</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
			<%
				for(Student stu : list) {
			%>
					<tr>
						<td><%=stu.getId()%></td>
						<td><%=stu.getName()%></td>
						<td><%=stu.getAge()%></td>
						<td><%=stu.getGender()%></td>
						<td><%=stu.getBirthday()%></td>
						<td><a href="<%=request.getContextPath()%>/student?method=deletById&id=<%=stu.getId()%>">删除</a></td>
						<td><a href="<%=request.getContextPath()%>/student?toUpdateStudent&id=<%=stu.getId()%>">修改</a></td>
					</tr>
			<%
				}
			%>
			
		</table>
		
		<!-- 分页开始 -->
		<nav aria-label="Page navigation">
		  <ul class="pagination">
		  	<!-- 上一页 开始-->
		  	<c:if test="${pageBean.pageIndex==1}">
		  		<li class="disabled">
			      <a href="javascript:void(0);" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
		    	</li>
		  	</c:if>
		  	<c:if test="${pageBean.pageIndex!=1}">
		  		<li>
			      <a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${pageBean.pageIndex-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
		    	</li>
		  	</c:if>
		    
		  	<!-- 上一页 结束-->
		  
		  	<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
		  		<c:if test="${pageBean.pageIndex!=page}">
			        <li><a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page}">${page}</a></li>
		  		</c:if>
		  		<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
		  		<c:if test="${pageBean.pageIndex==page}">
			        <li class="active"><a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page}">${page}</a></li>
		  		</c:if>
		  	</c:forEach>
		  
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
 		  </ul>
		</nav>
		<!-- 分页结束 -->
	</div>
</body>
</html>