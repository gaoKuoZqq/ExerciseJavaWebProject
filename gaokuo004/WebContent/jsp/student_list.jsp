<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.studentclass.Student" %>
<%@page import="java.util.*"%>
<%@page import="com.student.servlet.PageBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
		<title></title>
		<script src="${pageContext.request.contextPath}/jsp/lib/jquery/jquery-3.2.1.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath}/jsp/lib/js/bootstrap.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/my.css">
	</head>
	<body>
		<%@include file="lib/header.jsp"%>
		<div class="container">
		    <div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/student?method=pageList" class="list-group-item active">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student?method=getSearchPage" class="list-group-item">学生搜索</a>
		                <a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表</a>
		                </li>
		                <li>
		                    <a href="${pageContext.request.contextPath}/student?method=getSearchPage">学生搜索</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/student?method=getAddPage">添加学生</a>
		                </li>
		            </ul>
		            <% 
						PageBean pageBean = (PageBean)request.getAttribute("pageBean");
						List<Student> list = pageBean.getList();
					%>
		            <table class="table">
		                <thead>
		                    <tr>
		                        <th>id</th>
								<th>姓名</th>
								<th>年龄</th>
								<th>性别</th>
								<th>出生日期</th>
								<th>删除</th>
								<th>修改</th>
		                    </tr>
		                </thead>
		                <tbody>
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
		                </tbody>
		            </table>
		            <!-- 分页开始 -->
				<nav aria-label="Page navigation" class="pull-right">
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
		    </div>
		</div>
		
		
	</body>
</html>
