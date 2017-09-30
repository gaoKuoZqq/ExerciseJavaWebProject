<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta charset="UTF-8">
		<title>login please</title>
		<script src="/gaokuo004/jsp/lib/jquery/jquery-3.2.1.min.js"></script>
		<link rel="stylesheet" href="/gaokuo004/jsp/lib/css/bootstrap.css" />
		<script src="/gaokuo004/jsp/lib/js/bootstrap.js"></script>
		<style>
			.body {
				margin-left: auto;
				margin-right: auto;
				margin-top: 100PX;
				width: 300px;
				padding-left: 40px;
			}
		</style>
		
	</head>

	<body class="body">
		<form action="/gaokuo004/login?method=login" method="post">
			<div class="input-group">
				<input name="userName" type="text" class="form-control" placeholder="name" aria-describedby="basic-addon1">
			</div>
			<br>
			<div class="input-group">
				<input name="passWord" type="password" class="form-control" placeholder="password" aria-describedby="basic-addon1">
			</div>
			<br>
			<c:if test="${userName!=null}">
				<a style="color:red; font-size: 8px;">请重新输入并登录</a>
				<br>
			</c:if>
			<img id="codeImage" src="${pageContext.request.contextPath }/checkImg"/>
			<button type="submit" style="width:180px;" class="btn btn-info">login</button>
		</form>

	</body>
		<script type="text/javascript">
			$("#codeImage").click(function(){
				$("#codeImage").attr("src","${pageContext.request.contextPath}/checkImg?" + Math.random());
			});
		</script>
</html>