<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="easyui_test.*" %>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
	<link rel="stylesheet" href="${ctx }/easyui/jquery-easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="${ctx }/easyui/jquery-easyui/themes/icon.css" />
</head>
	<script type="text/javascript" src="${ctx }/easyui/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx }/easyui/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function find(value,name){
 		    var options = $("#tt" ).datagrid("getPager" ).data("pagination" ).options;
		    var page = options.pageNumber;
		    var rows = options.pageSize;
		    if(name == 'student.name'){
		    	options = {
						url : '${ctx}/student/list.action',
						type : 'post',
						dataType : 'json',
						data :{
							"page" : page,
							"rows" : rows,
							"student.name" : value,
							},
						success : function(news){
							$('#tt').datagrid('loadData',news);
						}
				}
		    }else if(name == 'student.gender'){
		    	options = {
						url : '${ctx}/student/list.action',
						type : 'post',
						dataType : 'json',
						data :{
							"page" : page,
							"rows" : rows,
							"student.gender" : value,
							},
						success : function(news){
							$('#tt').datagrid('loadData',news);
						}
				}
		    }else{
		    	options = {
						url : '${ctx}/student/list.action',
						type : 'post',
						dataType : 'json',
						data :{
							"page" : 1,
							"rows" : rows,
							},
						success : function(news){
							$('#tt').datagrid('loadData',news);
						}
				}
		    }
			$.ajax(options);
		}
	</script>
<body>
	<table class="easyui-datagrid" id="tt"
		data-options="fitColumns:true,singleSelect:true,striped:true,url:'list.action',pagination:true,checkbox:true">
		<input id="ss" class="easyui-searchbox" style="width: 300px"
			data-options="prompt:'Please Input Value',menu:'#mm',searcher:find"></input>
		<div id="mm" style="width: 120px">
			<div data-options="name:'student.name',iconCls:'icon-ok'">姓名</div>
			<div data-options="name:'student.gender'">性别</div>
		</div>
		<thead>
			<tr>
				<th data-options="field:'id',align:'center'" style="width: 10%">id</th>
				<th data-options="field:'name',align:'center'" style="width: 20%">姓名</th>
				<th data-options="field:'age',align:'center'" style="width: 20%">年龄</th>
				<th data-options="field:'gender',align:'center'" style="width: 20%">性别</th>
				<th data-options="field:'birthday',align:'center'"
					style="width: 20%">生日</th>
			</tr>
		</thead>
	</table>
</body>
</html>