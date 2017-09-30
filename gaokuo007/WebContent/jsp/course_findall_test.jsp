<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.studentManagement_class.*" %>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/jsp/lib/jquery/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/css/bootstrap.css" />
	<script src="${pageContext.request.contextPath}/jsp/lib/js/bootstrap.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/my.css">
	<script type="text/javascript">
		function goPage(pageIndex){
			$("#pageIndex").val(pageIndex);
			$("#pageIndexForm").submit();
		}
		$(function(){
		       $("#selectGender option[value='${stu.gender}']").prop("selected", true);
		});
		$(function(){
		       $("#selectBanji option[value='${stu.banji.banjiId}']").prop("selected", true);
		});
	</script>
</head>
<body>
		<!--
        	描述：头部导航开始
        -->
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
						<a class="navbar-brand" href="#">学生管理系统</a>
					</div>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li>
								<a href="${pageContext.request.contextPath}/student?method=queryStudents"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;学生管理 <span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/banji?method=queryBanjis"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;班级管理 <span class="sr-only">(current)</span></a>
							</li>
							<li class="active">
								<a href="#"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;课程管理 <span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="#"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;教务管理 <span class="sr-only">(current)</span></a>
							</li>
						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">admin <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">Action</a>
									</li>
									<li>
										<a href="#">Another action</a>
									</li>
									<li>
										<a href="#">Something else here</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">Separated link</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#"><span class="glyphicon glyphicon-remove-sign"></span>&nbsp;&nbsp;退出</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
		<!--
        	描述：头部导航结束
        -->
		<!--
        	描述：左侧可切换的竖向列表组,占2格,开始
        -->
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="list-group">
						<a href="#" class="list-group-item active">课程列表</a>
						<a href="${pageContext.request.contextPath}/gojsp?method=goAddCourse" class="list-group-item">
							添加课程
						</a>
					</div>
				</div>
				<!--
	        	描述：左侧竖向列表结束
	        	右侧功能区占10格,开始
	        -->
				<div class="col-sm-10">
					<!--
                    	描述：功能区上部小导航,开始
                    -->
					<ul class="nav nav-tabs">
						<li role="presentation" class="active">
							<a href="#">课程列表</a>
						</li>
						<li role="presentation">
							<a href="${pageContext.request.contextPath}/gojsp?method=goAddCourse">添加课程</a>
						</li>
					</ul>
					<!--
                    	描述：功能区上部小导航,结束
                    -->
					<!-- 展示列表,开始 -->
					<table class="table">
						<tr>
							<td>id</td>
							<td>name</td>
							<td>credit</td>
						</tr>
						<c:forEach items="${pageBean.list }" var="course">
							<tr>
							<td>${course.id }</td>
							<td>${course.courseName }</td>
							<td>${course.credit }</td>
						</tr>
						</c:forEach>
					</table>
					<!-- 展示列表,结束 -->
					<!-- 分页开始 -->
		       		<nav aria-label="Page navigation">
						<ul class="pagination" >
							<!-- 上一页开始 -->
							<c:if test="${pageBean.pageIndex==1 }">
								<li class="disabled">
					    			<a href="javascript:void(0);" aria-label="Previous">
					   				<span aria-hidden="true">&laquo;</span>
					   				</a>
			 					</li>
							</c:if>
							<c:if test="${pageBean.pageIndex>1 }">
								<li>
					    			<a href="javascript:goPage('${pageBean.pageIndex-1 }');" aria-label="Previous">
					   					<span aria-hidden="true">&laquo;</span>
					   				</a>
				  				</li>
							</c:if>
							<!-- 上一页结束 -->
							<c:forEach begin='1' end="${pageBean.totalPage }" var="page">
							<c:if test="${pageBean.pageIndex!=page}">
					 	       <li><a href="javascript:goPage('${page }');">${page}</a></li>
				  			</c:if>
				  			<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
				  			<c:if test="${pageBean.pageIndex==page}">
						        <li class="active"><a href="javascript:goPage('${page }');">${page}</a></li>
				  			</c:if>
							</c:forEach>
							<!-- 下一页开始 -->
							<c:if test="${pageBean.pageIndex==pageBean.totalPage }">
								<li class="disabled">
						    		<a href="javascript:void(0);" aria-label="Next"/>
					   				<span aria-hidden="true">&raquo;</span>
				 				</li>
							</c:if>
							<c:if test="${pageBean.pageIndex<pageBean.totalPage }">
								<li>
					    			<a href="javascript:goPage(${pageBean.pageIndex+1 });" aria-label="Next"/>
					   				<span aria-hidden="true">&raquo;</span>
					   			</li>
							</c:if>
							<!-- 下一页结束 -->
						</ul>
					</nav>
					<!-- 分页结束 -->
					<!--隐藏的用于分页的表单 -->
					<form id="pageIndexForm" action="${pageContext.request.contextPath}/course?method=queryCourses" method="post">
						<input type="hidden" id="pageIndex" name="pageIndex"/>
					</form>
				</div>
				<!--
	        	描述：右侧功能区,结束
	        -->
			</div>
		</div>
	</body>
</html>