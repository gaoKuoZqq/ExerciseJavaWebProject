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
		function goPage(pageIndex){
			$("#pageIndex").val(pageIndex);
			$("#queryHiddenForm").submit();
		}
		
		$(function(){
		       $("#selectGender option[value='${pageBean.student.student_gender}']").prop("selected", true);
		});
		
		$(function(){
		       $("#selectBanji option[value='${pageBean.student.student_banji.banji_id}']").prop("selected", true);
		});
		
		function modifyInfo(id){
		    	  // $("#modifyStudentInfoForm"+id).submit();
		           var params = $("#modifyStudentInfoForm"+id).serializeArray();  
		           var values = {};  
		           for( x in params ){  
		              values[params[x].name] = params[x].value;  
		           }
		    	   $.post(
			               "${pageContext.request.contextPath}/student/modify.action", //url
			               values,
			               function(data) { //callback
			                  if(data) {
			                	  alert("修改成功");
			                  }
			               },
			               "json" //type
			           ); 
		       }
		
		function del(id){
			var isModify = confirm("真要删?");
		       if (isModify) {
		    	   $("#deleteStudent"+id).submit();
		       }
		}
	</script>
	<style type="text/css">
		.studentInfo{
			background-color: transparent;
			border: none;
		}
		.selectNo{
			appearance:none;
			-moz-appearance:none;
			-webkit-appearance:none;
			border: none;
		}
	</style>
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
						<a href="${pageContext.request.contextPath}/student/find.action" class="list-group-item active">学生列表</a>
						<a href="${pageContext.request.contextPath}/student/goadd.action" class="list-group-item">
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
						<li role="presentation" class="active">
							<a href="${pageContext.request.contextPath}/student/find.action">学生列表</a>
						</li>
						<li role="presentation">
							<a href="${pageContext.request.contextPath}/student/goadd.action">添加学生</a>
						</li>
					</ul>
					<!--
                    	描述：功能区上部小导航,结束
                    	搜索栏,开始
                    -->
					<form id="queryHiddenForm" action="${pageContext.request.contextPath}/student/find.action" 
					method="post"
					class="form-inline" style="margin-top:20px;">
						<input type="hidden" name="pageIndex" id="pageIndex"/>
						<div class="form-group">
					    	<label for="exampleInputName2">姓名</label>
					    	<input name="student_name" value="${pageBean.student.student_name }" type="text" class="form-control" style="width:70px;">
						</div>
						<div class="form-group">
					    	<label for="exampleInputName2">年龄</label>
					    	<!-- 这里搞一个年龄为0不予显示 -->
					    	<c:if test="${pageBean.student.student_age!=0 }">
					    	<input name="student_age" value="${pageBean.student.student_age }" type="text" class="form-control" style="width:50px;">
					    	</c:if>
					    	<c:if test="${pageBean.student.student_age==0 }">
					    	<input name="student_age" type="text" class="form-control" style="width:50px;">
					    	</c:if>
						</div>
						<select id="selectGender" class="form-control" name="student_gender" >
							<option value="">性别</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
						<select id="selectBanji" name="student_banji.banji_id" class="form-control">
							<option value="">班级</option>
							<c:forEach items="${banjisList}" var="banji">
		                    <option value="${banji.banji_id }">${banji.banji_name}</option>
	                   		</c:forEach>
						</select>
						<button type="submit" class="btn btn-default">查询</button>
					</form>
					<!-- 搜索栏,结束 -->
					<!-- 展示列表,开始 -->
					<table class="table">
						<tr>
							<td>id</td>
							<td>name</td>
							<td>age</td>
							<td>gender</td>
							<td>birthday</td>
							<td>class</td>
							<td>delete</td>
						</tr>
						<c:forEach items="${pageBean.objList}" var="stu">
							<tr>
							<!-- 用于修改学生信息的表单 -->
							<form id="modifyStudentInfoForm${stu.student_id }" action="${pageContext.request.contextPath}/student/modify.action" method="post">
								<input type="hidden" value="${pageBean.pageIndex}" name="pageIndex">
								<td>
									${stu.student_id }
									<input type="hidden" value="${stu.student_id }" name="student_id"/>
								</td>
								<td>
									<input name="student_name" onblur="modifyInfo(${stu.student_id })" class="studentInfo" type="text" value="${stu.student_name }" style="width:50px;"/>
								</td>
								<td>
									<input name="student_age" onblur="modifyInfo(${stu.student_id })" class="studentInfo" type="text" value="${stu.student_age }" style="width:30px;"/>
								</td>
								<td>
									<select name="student_gender" onblur="modifyInfo(${stu.student_id })" class="selectNo">
										<option>男</option>
										<c:if test="${stu.student_gender=='女' }">
											<option selected="selected">女</option>
										</c:if>
										<c:if test="${stu.student_gender!='女' }">
											<option>女</option>
										</c:if>
									</select>
								</td>
								<td>
									<input onblur="modifyInfo(${stu.student_id })" name="student_birthday" class="studentInfo" type="text" value="${stu.student_birthday }" style="width:100px;"/>
								</td>
							<td>
								<select onblur="modifyInfo(${stu.student_id })" class="selectNo" name="student_banji.banji_id">
	                        	<c:forEach items="${banjisList}" var="banji">
	                        		<c:if test="${stu.student_banji.banji_name==banji.banji_name }">
										<option selected="selected" value="${banji.banji_id}">${banji.banji_name }</option>
									</c:if>
									<c:if test="${stu.student_banji.banji_name!=banji.banji_name }">
										<option value="${banji.banji_id }">${banji.banji_name }</option>
									</c:if>
	                        	</c:forEach>
	                       		</select>
							</td>
							</form>
							<td>
								<!-- 用于删除的表单 -->
								<form id="deleteStudent${stu.student_id }" action="${pageContext.request.contextPath}/student/delete.action" method="post">
									<input type="hidden" value="${stu.student_id }" name="student_id"/>
									<input type="button" value="delete" class="btn btn-danger btn-xs" onclick="del(${stu.student_id })"/>
								</form>
							</td>
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
					<!-- 用于提交翻页信息的表单 -->
					<form id="queryHiddenForm" action="${pageContext.request.contextPath}/student?method=queryStudents" method="post">
						<input id="pageIndex" type="hidden" name="pageIndex"/>
					</form>
				</div>
				<!--
	        	描述：右侧功能区,结束
	        -->
			</div>
		</div>
	</body>
</html>