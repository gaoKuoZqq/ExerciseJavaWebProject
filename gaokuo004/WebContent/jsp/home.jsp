<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ page import="com.studentclass.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
	<script src="${pageContext.request.contextPath}/jsp/lib/jquery/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/css/bootstrap.css" />
	<script src="${pageContext.request.contextPath}/jsp/lib/js/bootstrap.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/lib/FindAllStudents.css">
	<script type="text/javascript">
	function del(id) {
	       var isDel = confirm("您确认要删除吗？");
	       if (isDel) {
	           //要删除
	           document.getElementById("delete"+id).submit();
	       }
	};
	
	function log(){
		var isLog = confirm("注销当前用户?")
		if (isLog) {
			location.href = "${pageContext.request.contextPath}/student?method=log"
		}
	};
	
	function goPage(pageIndex){
		$('#pageIndex').val(pageIndex);
		$('#queryStudents').submit();
	};
	
	$(function() {
	       $("#name").blur(function(){
	           var name = $(this).val();
	           $.post(
	               "${pageContext.request.contextPath}/student?method=checkName", //url
	               {"name":name}, //data
	               function(data) { //callback
	                  if(data.isExit) {//用户已经存在
	                      $("#nameInfo").html("该用户名已存在");
	                      $("#nameInfo").css("color", "red");
	                  }else {
	                	  $("#nameInfo").html("输入学生信息进行添加");
	                	  $("#nameInfo").css("color", "black");
	                  }
	               },
	               "json" //type
	           );
	       });
	    });
	function check(){
		$("input[name=deleteBox]").prop("checked", $("#checkAll").is(":checked"))
	}
	//1,
	/* function getChecks(){
		var obj=document.getElementsByName('deleteBox');
		var s=''; 
		for(var i=0; i<obj.length; i++){ 
			if(obj[i].checked) {
				s+=obj[i].value+'+'; //如果选中，将value添加到变量s中 
			} 
			
		} 
		$("#testForm").attr("action","${pageContext.request.contextPath}/student?method=test");
		$("#iii").val(s);
		$("#testForm").submit();
	} */
	//2,
	
	 $(function() {
	       $("#a").click(function(){
	           var ids = document.getElementsByName('deleteBox');
	           var json=JSON.stringify(ids)
	           alert(json);
	           $.post(
	               "${pageContext.request.contextPath}/student?method=test", //url
	               {"idList":json}, //data
	               function(data) { //callback
	                  
	               },
	               "json" //type
	           );
	       });
	    }); 
	</script>
</head>
<body class="body">
	<div class="nav">
		<div class="left"><a href="${pageContext.request.contextPath}/student?method=queryStudents">Student Management System</a></div>
		<div class="right">
			<a>在线人数:${online}</a>
			<a>欢迎</a>
			<a class="blue">${userName.userName}</a>
			<a>, </a>
			<a onclick='log()'>注销</a>
			<br/>
			<c:forEach items="${users}" var="userName">
			<p>${userName }</p>
			</c:forEach>
		</div>
	</div>
	
	<table class="table table-striped table-hover table-bordered">
		<tr>
			<form action="${pageContext.request.contextPath}/student?method=queryStudents" method="post" id="queryStudents">
				<input type="hidden" id="pageIndex" name="pageIndex"/>
				<td>id</td>
				<td colspan="2">
					name
					<input
					maxlength= "3"
					onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" 
					style="border:0px; width:100px"
					type="text" name="name"
					value="${stu.name }"/>
				</td>
				<c:if test="${stu.age==0 }">
					<td>
						age
						<input
						maxlength= "2"
						onkeyup="this.value=this.value.replace(/\D/g,'')" 
						onafterpaste="this.value=this.value.replace(/\D/g,'')" 
						style="border:0px; width:50px"
						type="text" name="age"
						/>
					</td>
				</c:if>
				<c:if test="${stu.age!=0 }">
					<td>
						age
						<input
						maxlength= "2"
						onkeyup="this.value=this.value.replace(/\D/g,'')" 
						onafterpaste="this.value=this.value.replace(/\D/g,'')" 
						style="border:0px; width:50px"
						type="text" name="age"
						value="${stu.age }"/>
					</td>
				</c:if>
				<td>
					gender
					<input
					maxlength= "1"
					onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"
					style='width:50px; border:0px;' name="gender" type="text"
					value="${stu.gender }"/>
				</td>
				<td colspan="2">
					<input type="submit" value="find by infos" style="width:100px"/>
				</td>
			</form>
		</tr>
		<tr>
			<form action="${pageContext.request.contextPath}/student?method=addStudent" method="post">
				<td>id</td>
				<td>
					<input 
					maxlength= "3"
					onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" 
					id="name"
					style='width:50px; border:0px;' name="studentName" type="text"
					/>
				</td>
				<td>
					<input
					maxlength= "2"
					onkeyup="this.value=this.value.replace(/\D/g,'')" 
					onafterpaste="this.value=this.value.replace(/\D/g,'')" 
					style='width:50px; border:0px;' name="studentAge" type="text"
				 	/>
				 </td>
				<td>
					<input
					maxlength= "1"
					onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"
					style='width:50px; border:0px;' name="studentGender" type="text"
					/>
				</td>
				<td><input style='width:100px; border:0px;' name="studentBirthday" type="text"/></td>
				<td colspan="2"><input type="submit" value="addition" style="width:100px"/></td>
			</form>
		</tr>
		<tr><td id="nameInfo" colspan="7">输入学生信息进行添加</td></tr>
		<tr>
			<td>
				<input type="checkbox" id="checkAll" onclick="check()"/>
			</td>
			<td>ID</td>
			<td>name</td>
			<td>age</td>
			<td>gender</td>
			<td>birthday</td>
			<td>modify</td>
			<td>delete</td>
		</tr>
		
		<c:forEach items="${pageBean.list}" var="student">
			<tr>
				<form  action='${pageContext.request.contextPath}/student?method=modifyStudent' method="post">
					<input type="hidden" name="pageIndex" value="${pageBean.pageIndex }"/>
					<input type="hidden" name="pageSize" value="${pageBean.pageSize }"/>
					<input type="hidden" name="name" value="${stu.name }"/>
					<input type="hidden" name="age" value="${stu.age }"/>
					<input type="hidden" name="gender" value="${stu.gender }"/>
					<!-- 这里是选择框 -->
					<td>
						<input type="checkbox" name="deleteBox" value="${student.id }"/>
					</td>
					<td>${student.id }</td>
					<input type="hidden" name="id" value="${student.id }" />
					<td>
						<input class="inp" type='text' name='studentName' value="${student.name }"/>
					</td>
					<td>
						<input class="inp" type='text' name='studentAge' value="${student.age }" />
					</td>
					<td>
						<input class="inp" type='text' name='studentGender' value="${student.gender }" />
					</td>
					<td>
						<input class="inp" type='text' name='studentBirthday' value="${student.birthday }"/>
					</td>
					<td>
						<input class="btn-warning" type='submit' value='modify'/>
					</td>
				</form>
				<form action='${pageContext.request.contextPath}/student?method=deleteStudent' id="delete${student.id}" method="post">
					<td>
						<input type="hidden" name="pageIndex" value="${pageBean.pageIndex }"/>
						<input type="hidden" name="pageSize" value="${pageBean.pageSize }"/>
						<input type="hidden" name="name" value="${stu.name }"/>
						<input type="hidden" name="age" value="${stu.age }"/>
						<input type="hidden" name="gender" value="${stu.gender }"/>
						<input class="btn-danger" type="button" value="delete" onclick="del(${student.id})"/>
						<input type="hidden" name="id" value="${student.id }"/>
					</td>
				</form>
			</tr>
		</c:forEach>
		<input type="button" value="ceshi" id="a"/>
	<!-- <input type="button" value="deleteC" onclick="getChecks()"/>
	<form id="testForm" method="post"><input type="hidden" id="iii" name="iii"/></form> -->
	</table>
	<!-- 分页开始 -->
	<div style="margin:auto;width:600px;">
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
	</div>
	<!-- 分页结束 -->
</body>
</html>