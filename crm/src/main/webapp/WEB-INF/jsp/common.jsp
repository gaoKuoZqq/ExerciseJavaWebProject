<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${ctx }/resources/easyui/jquery-easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="${ctx }/resources/easyui/jquery-easyui/themes/icon.css" />
	<script type="text/javascript" src="${ctx }/resources/easyui/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx }/resources/easyui/jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
<script type="text/javascript">

var Util = {
		//对应ServerResoponse成功返回的状态 
		SUCCESS : 0,
		//对应ServerResoponse失败返回的状态 
		ERROR : 1,
		//将datagrid被选中的行拼接成以","分割的字符串:1,2,3
		getSelectionsIds : function(datagridId){
			//getSelections none 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组。 
			var selectedIds = $(datagridId).datagrid("getSelections");
			console.log(selectedIds);
			var ids = [];//[1,2,3]
			for(var i in selectedIds){
				ids.push(selectedIds[i].id);
			}
			ids = ids.join(",");// 1,2,3
			return ids;
		},
		// 格式化时间
		formatDateTime : function(val, row) {
			var now = new Date(val);
			return now.format("yyyy-MM-dd hh:mm:ss");
		},
		// 格式化连接
		formatUrl : function(val, row) {
			if (val) {
				return "<a href='" + val + "' target='_blank'>查看</a>";
			}
			return "";
		},
		
}
</script>
</body>
</html>