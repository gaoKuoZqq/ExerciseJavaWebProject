<%@page import=" com.student.servlet.PageBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.studentclass.Student" %>
<%@page import="java.util.*"%>
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
		                <a href="${pageContext.request.contextPath}/student?method=pageList" class="list-group-item">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student?method=getSearchPage" class="list-group-item">学生搜索</a>
		                <a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item  active">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li>
		                    <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表</a>
		                </li>
		                <li>
		                    <a href="${pageContext.request.contextPath}/student?method=getSearchPage">学生搜索</a>
		                </li>
		                <li  class="active">
		                	<a href="${pageContext.request.contextPath}/student?method=getAddPage">添加学生</a>
		                </li>
		            </ul>
		            
		            <!-- 学生添加表单  begin -->
		            <form action="#" class="form_border">
	                    <div class="form-group">
	                        <label for="addname">用户名</label>
	                        <input type="text" id="addname" class="form-control" placeholder="用户名">
	                    </div>
	                    <div class="form-group">
	                        <label for="addpassword">用户密码</label>
	                        <input type="text" id="addpassword" class="form-control" placeholder="请输入用户密码">
	                    </div>
	                    <div class="form-group">
	                        <label for="addpassword1">确认用户密码</label>
	                        <input type="text" id="addpassword1" class="form-control" placeholder="请确认输入用户密码">
	                    </div>
	                    <div class="form-group">
	                        <label for="addemail">请输入用户邮箱</label>
	                        <input type="email" id="addemail" class="form-control" placeholder="请输入用户邮箱">
	                    </div>
	                    <div class="form-group">
	                        <label for="addyonghuzu">所属用户组</label>
	                        <select id="addyonghuzu" class="form-control">
	                        	<c:forEach items="${list}" var="banji">
		                            <option>${banji}</option>
	                        	</c:forEach>
	                           
	                        </select>
	                    </div>
	                    <input class="btn btn-success btn-lg" type="submit" value="添加"/>
                	</form>
		            <!-- 学生添加表单  end -->
		            
		        </div>
		    </div>
		</div>
		
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/my.css">
	</body>
</html>
