<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.s_m_s.*" %>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/jsp/lib/jquery/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/jsp/lib/jquery/jquery-form.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/css/bootstrap.css" />
	<script src="${pageContext.request.contextPath}/jsp/lib/js/bootstrap.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/my.css">
	<script type="text/javascript">
	$(function() {
	       $("#addStudent").click(function(){
	           var student_name = $("#studentName").val();
	           var student_age = $("#studentAge").val();
	           var student_gender = $("#studentGender").val();
	           var student_banji_id = $("#studentBanji_id").val();
	           var student_birthday = $("#studentBirthday").val();
	           $.post(
	               "${pageContext.request.contextPath}/student/add.action", //url
	               {"student_name":student_name,
	            	 "student_age":student_age,
	            	 "student_gender":student_gender,
	            	 "student_banji.banji_id":student_banji_id,
	            	 "student_birthday":student_birthday
	               }, //data
	               function(data) { //callback
	                  if(data) {
	                      alert("我觉得可以");
	                      //这里直接写reset不行,所以使用了dom的方法
	                      $("#addStudentForm")[0].reset();
	                  }else {
	                	  alert("我觉得不行");
	                  }
	               },
	               "json" //type
	           );
	       });
	    });
	
	/* $(function() {
	       $("#studentName").blur(function(){
	           var studentName = $("#studentName").val();
	           $.post(
	               "${pageContext.request.contextPath}/student?method=checkName", //url
	               {"studentName":studentName}, //data
	               function(data) { //callback
	                  if(data.isSuccess) {//用户已经存在
	                	  $("#exit").html("已存在")
	                  }else {
	                	  $("#exit").html(" ")
	                  }
	               },
	               "json" //type
	           );
	       });
	    }); */
	    function uploadPic() {
	        //定义参数
	        var options = {
	            url:"${ctx}/upload/uploadPic.action",
	            dataType:"json",
	            type:"post",
	            success: function(data) {
	                $("#imgId").attr("src","/pic/" + data.fileName);
	                $("#mainImage").val(data.fileName);
	            }
	        };
	         $("#addStudentForm").ajaxSubmit(options);
	     }

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
							<li class="active">
								<a href="${pageContext.request.contextPath}/student/find.action"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;学生管理 <span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/banji/find.action"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;班级管理 <span class="sr-only">(current)</span></a>
							</li>
							<li>
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
						<a href="${pageContext.request.contextPath}/student/find.action" class="list-group-item">学生列表</a>
						<a href="${pageContext.request.contextPath}/student/goadd.action" class="list-group-item active">
							添加学生
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
							<a href="${pageContext.request.contextPath}/student/find.action">学生列表</a>
						</li>
						<li role="presentation" class="active">
							<a href="${pageContext.request.contextPath}/student/goadd.action">添加学生</a>
						</li>
					</ul>
					<!--
                    	描述：功能区上部小导航,结束
                    -->
					<form id="addStudentForm" class="form_border" method="post">
					
					<div class="row">
							<div  class="col-sm-9">
								<div class="form-group" style="margin-top:10px;">
									<label for="exampleInputEmail1">学生姓名</label><span id="exit" style="color:red"></span>
									<input id="studentName" class="form-control"  placeholder="输入学生姓名,例: 大黄">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">学生年龄</label>
									<input id="studentAge" class="form-control" id="exampleInputPassword1" placeholder="输入二位数的年龄">
								</div>
							</div>
							<!-- 上传头像 -->
							<div  class="col-sm-3">
							      <div>
							     		<div style="width:100px; height:120px">
								       		<img alt="" id="imgId" src="" style="width:100px; height:120px">
								         </div>
								         <input type="hidden" name="mainImage" id="mainImage"/>
								         <input type="file" name="pictureFile" onchange="uploadPic();" />
								     </div>
							</div>
					</div>
						
						<label for="exampleInputPassword1">学生性别</label>
						<select  id="studentGender" class="form-control" style="margin-bottom:10px;">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
						<label for="exampleInputPassword1">学生班级</label>
						<select  id="studentBanji_id" class="form-control"style="margin-bottom:10px;">
						<c:forEach items="${banjisList}" var="banji">
		                    <option value="${banji.banji_id }">${banji.banji_name}</option>
	                    </c:forEach>
						</select>
						<div class="form-group">
							<label for="exampleInputEmail1">出生日期</label>
							<input id="studentBirthday" class="form-control"  placeholder="例: 2000-01-01">
						</div>
						<input id="addStudent" class="btn btn-success btn-lg" type="button" value="添加"/>
					</form>
				</div>
				<!--
	        	描述：右侧功能区,结束
	        -->
			</div>
			
		</div>
	</body>
</html>