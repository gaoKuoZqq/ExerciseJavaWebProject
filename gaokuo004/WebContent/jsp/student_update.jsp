<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.studentclass.Student" %>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>
	<form action="/Java1707Web/student?method=updateStudent">
		<input type="text" name="id" value="<%=student.getId() %>"/>
		<input type="text" name="name" value="<%=student.getName() %>"/>
		<input type="text" name="age" value="<%=student.getAge() %>"/>
		<input type="text" name="gender" value="<%=student.getGender() %>"/>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>