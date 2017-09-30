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
	$(function() {
	       $("#addCourse").click(function(){
	           var courseName = $("#courseName").val();
	           var courseCredit = $("#credit").val();
	           $.post(
	               "${pageContext.request.contextPath}/course?method=addCourse", 
	               {"courseName":courseName,
	            	"courseCredit":courseCredit,
	               }, //data
	               function(data) { //callback
	                  if(data.isSuccess) {//用户已经存在
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
	               "${pageContext.request.contextPath}/course?method=checkName", 
	               {"courseName":courseName}, //data
	               function(data) { //callback
	                  if(data.isSuccess) {//用户已经存在
	                      $("#exit").html("已存在");
	                  }else {
	                	  $("#exit").html(" ");
	                  }
	               },
	               "json" //type
	           );
	       });
	    });
	function selectBanji(){
		var banjiId = $("#theBanji").val();
		if(banjiId != "选择班级"){
			$.post(
		           "${pageContext.request.contextPath}/banji?method=queryCourseForBanji", 
		           {"banjiId":banjiId}, //data
		           function(data) { //callback
		           $(".useDel").remove();
		           for(var p in data){//遍历json数组时，p为索引，0,1.....
		        	   //$("#hadCourses").after("<a href='javascript:delCourse("+data[p].banji_id+","+data[p].course_id+")'>"+data[p].course_name+"&nbsp;&nbsp;&nbsp;<a/>");
		           		$("#hadCourses").after("<a class='useDel' href='javascript:delCourse("+data[p].banji_id+","+data[p].course_id+")'>"+data[p].course_name+"&nbsp;&nbsp;&nbsp;<a/>");
		        	}
		           },
		           "json" //type
		       );
		}else{
			$(".useDel").remove();
		}
	}
	function delCourse(banji_id,course_id){
		var isModify = confirm("想好没？");
	       if (isModify) {
	    	   $.post(
		               "${pageContext.request.contextPath}/banji?method=delLine", 
		               {"banji_id":banji_id,
		            	"course_id":course_id}, //data
		                //callback
		            	selectBanji()
		               ,
		               "json" //type
		           );
	       }
		   
	}

	function addCourseId(){
		//隐藏的用于储存id的p标签
		var studentBanji_id = $("#studentBanji_id").val();
		var selectedCourseId = $("#selectedCoursesId").text();
		if(studentBanji_id != "请选课"){
			selectedCourseId = selectedCourseId + studentBanji_id + " ";
			$("#selectedCoursesId").text(selectedCourseId);
		}
		//用于展示已选课程的p
		var studentBanji_name = $("#studentBanji_id").find("option:selected").text();
		if(studentBanji_name != "请选课"){
			var selectedCourseName = $("#selectedCoursesName").text();
			selectedCourseName = selectedCourseName + studentBanji_name + "&nbsp;&nbsp;&nbsp;";
			$("#selectedCoursesName").html(selectedCourseName);
		}
		
	}
	
	$(function() {
	       $("#addLine").click(function(){
	           var coursesId = $("#selectedCoursesId").text();
	           var banji_id = $("#theBanji").val();
	           if(banji_id != "选择班级"){
		           $.post(
		               "${pageContext.request.contextPath}/banji?method=addLine", //url
		               {"coursesId":coursesId,
		            	"banji_id":banji_id,
		               }, //data
			             goReset()
		               ,
		               "json" //type
		           );
		       }
	       });
	    });
	
	$(document).ready(function(){
		$("#selectedCoursesId").hide();
	})
	function goReset(){
		$("#selectedCoursesId").html("");
		$("#selectedCoursesName").html("");
		selectBanji();
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
							<li>
								<a href="${pageContext.request.contextPath}/student?method=queryStudents"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;学生管理 <span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/banji?method=queryBanjis"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;班级管理 <span class="sr-only">(current)</span></a>
							</li>
							<li class="active">
								<a href="${pageContext.request.contextPath}/course?method=queryCourses"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;课程管理 <span class="sr-only">(current)</span></a>
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
						<a href="${pageContext.request.contextPath}/course?method=queryCourses" class="list-group-item">课程列表</a>
						<a href="${pageContext.request.contextPath}/gojsp?method=goAddCourse" class="list-group-item">
							添加课程
						</a>
						<a href="#" class="list-group-item active">
							班级选课
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
								<a href="${pageContext.request.contextPath}/course?method=queryCourses">课程列表</a>
							</li>
							<li role="presentation">
								<a href="${pageContext.request.contextPath}/gojsp?method=goAddCourse">添加课程</a>
							</li>
							<li role="presentation" class="active">
								<a href="#">班级选课</a>
							</li>
						</ul>
						<!--
	                    	描述：功能区上部小导航,结束
	                    	功能区,开始
	                    -->
						<div>
							<select class="form-control" onchange="selectBanji()" id="theBanji">
									<option>选择班级</option>
								<c:forEach items="${banjisList}" var="banji">
		                    		<option value="${banji.banjiId }">${banji.banjiName}</option>
	                   			</c:forEach>
							</select>
							<span id="hadCourses">已选课程(单击删除):&nbsp;</span>
						</div>
						<div>
						当前选课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(一个课程只能选择一次)
						<p id="selectedCoursesId"></p>
						<p id="selectedCoursesName"></p>
						<label for="exampleInputPassword1">班级选课</label>
						<select id="studentBanji_id" class="form-control"style="margin-bottom:10px;" onchange="addCourseId()">
							<option>请选课</option>
						<c:forEach items="${coursesList}" var="course">
		                    <option value="${course.id }">${course.courseName}&nbsp;&nbsp;学分:&nbsp;${course.credit}</option>
	                    </c:forEach>
						</select>
						<input class="btn btn-danger btn-lg" type="button" value="重置选课" onclick="goReset()"/>
						<input id="addLine" class="btn btn-success btn-lg" type="button" value="添加"/>
						</div>
						
						<!-- 功能区,结束 -->
				<!--
	        	描述：右侧功能区,结束
	        -->
	        </div><!-- row -->
			</div>
		</div>
	</body>
</html>