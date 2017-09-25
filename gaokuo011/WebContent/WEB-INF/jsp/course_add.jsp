<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.s_m_s.*" %>
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
	$(function() {
	       $("#addCourse").click(function(){
	           var courseName = $("#courseName").val();
	           var courseCredit = $("#credit").val();
	           $.post(
	               "${pageContext.request.contextPath}/course/add.action", 
	               {"course_name":courseName,
	            	"course_credit":courseCredit,
	               }, //data
	               function(data) { //callback
	                  if(data) {//用户已经存在
	                      alert("我觉得可以");
	                  }else {
	                	  alert("我觉得不行");
	                  }
	               },
	               "json" //type
	           );
	       });
	    });
	
	$(function() {
	       $("#courseName").blur(function(){
	           var courseName = $("#courseName").val();
	           $.post(
	               "${pageContext.request.contextPath}/course/checkName.action", 
	               {"course_name":courseName}, //data
	               function(data) { //callback
	                  if(data) {//用户已经存在
	                	  $("#exit").html(" ");
	                  }else {
	                	  $("#exit").html("已存在");
	                  }
	               },
	               "json" //type
	           );
	       });
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
								<a href="${pageContext.request.contextPath}/student/find.action"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;学生管理 <span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/banji/find.action"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;班级管理 <span class="sr-only">(current)</span></a>
							</li>
							<li class="active">
								<a href="${pageContext.request.contextPath}/course/find.action"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;课程管理 <span class="sr-only">(current)</span></a>
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
						<a href="${pageContext.request.contextPath}/course/find.action" class="list-group-item">课程列表</a>
						<a href="${pageContext.request.contextPath}/course/goadd.action" class="list-group-item active">
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
						<li role="presentation">
							<a href="${pageContext.request.contextPath}/course/find.action">课程列表</a>
						</li>
						<li role="presentation" class="active">
							<a href="${pageContext.request.contextPath}/course/goadd.action">添加课程</a>
						</li>
					</ul>
					<!--
                    	描述：功能区上部小导航,结束
                    	功能区,开始
                    -->
					<form id="addForm">
						<div class="form-group" style="margin-top:10px;">
							<label for="exampleInputEmail1">课程名称</label><span style="color:red" id="exit"></span>
							<input id="courseName" class="form-control" id="exampleInputEmail1" placeholder="语文">
						</div>
						<div class="form-group" style="margin-top:10px;">
							<label for="exampleInputEmail1">学分</label>
							<input id="credit" class="form-control" id="exampleInputEmail1" placeholder="5">
						</div>
						<input type="button" id="addCourse" class="btn btn-success btn-lg" value="添加"/>
					</form>
					<!-- 功能区,结束 -->
				</div>
				<!--
	        	描述：右侧功能区,结束
	        -->
			</div>
		</div>
	</body>
</html>