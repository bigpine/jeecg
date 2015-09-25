<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>绩效基础集合</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="userList" title="用户数据查询"  actionUrl="tsperformanceController.do?datagridUser" idField="id" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
	<t:dgCol title="ID" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="用户名" field="userName" width="50" query="true" ></t:dgCol>
	<t:dgCol title="真实姓名" field="realName" width="50" query="true" ></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	var ids = "${ids}";
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#userList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>