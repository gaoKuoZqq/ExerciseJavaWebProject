

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
		                <a href="${pageContext.request.contextPath}/student?method=getSearchPage" class="list-group-item  active">学生搜索</a>
		                <a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item">添加学生</a>
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li>
		                    <a href="${pageContext.request.contextPath}/student?method=pageList">学生列表</a>
		                </li>
		                <li  class="active">
		                    <a href="${pageContext.request.contextPath}/student?method=getSearchPage">学生搜索</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/student?method=getAddPage">添加学生</a>
		                </li>
		            </ul>
		            <form action="${pageContext.request.contextPath}/student?method=searchByCondition" method="post" class="form_border">
		                <div class="alert alert-info" role="alert">
		                    <strong>技巧提示：</strong>
		                    	支持模糊搜索和匹配搜索，匹配搜索使用*代替！
		                </div>
		                <div class="form-group">
		                    <label for="name">用户名</label>
		                    <input type="texte" id="name" name="name" class="form-control" placeholder="请输入用户名">
		                </div>
		                <div class="form-group">
		                    <label for="uid">UID</label>
		                    <input type="text" id="uid" class="form-control" placeholder="输入用户UID">
		                </div>
		                <div class="form-group">
		                    <label for="yonghuzu">选择用户组</label>
		                    <select id="yonghuzu" class="form-control">
		                        <option>限制会员</option>
		                        <option>新手上路</option>
		                        <option>组册会员</option>
		                        <option>中级会员</option>
		                        <option>高级会员</option>
		                    </select>
                		</div>
                		<button type="submit" class="btn btn-default">提交</button>
            		</form>
            		
            		<!-- 遍历输出搜索结果 begin -->
            		<table class="table">
		                <thead>
		                    <tr>
		                        <th>id</th>
								<th>姓名</th>
								<th>年龄</th>
								<th>性别</th>
								<th>地址</th>
								<th>出生日期</th>
								<!-- <th>删除</th>
								<th>修改</th> -->
		                    </tr>
		                </thead>
		                <tbody>
						<c:forEach items="${list}" var="student">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.age}</td>
								<td>${student.gender}</td>
								<td>${student.address}</td>
								<td>${student.birthday}</td>
								<%-- <td><a href="${pageContext.request.contextPath}/student?method=deletById&id=${student.id}">删除</a></td>
								<td><a href="${pageContext.request.contextPath}/student?toUpdateStudent&id=${student.id}">修改</a></td> --%>
							</tr>
						</c:forEach>
						</tbody>
					</table>
            		<!-- 遍历输出搜索结果 end -->
            		
		        </div>
		    </div>
		</div>
	</body>
</html>
