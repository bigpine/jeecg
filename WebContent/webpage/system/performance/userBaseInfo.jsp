<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>用户基础数据管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function() {
		//查看模式情况下,删除和上传附件功能禁止使用
		if (location.href.indexOf("load=detail") != -1) {
			$(".jeecgDetail").hide();
		}
	});	

	function close() {
		frameElement.api.close();
	}
</script>
<!-- 弹出页面窗口大小控制 -->
<style type="text/css">
#formobj {
	height: 65%;
	min-height: 300px;
	overflow-y: auto;
	overflow-x: auto;
	min-width: 600px;
}
</style>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="tsuserbaseinfoController.do?save">
		<input id="id" name="id" type="hidden" value="${tsuserBasePage.id }">
		<input id="createName" name="createUser" type="hidden"
			value="${tsuserBasePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsuserBasePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsuserBasePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsuserBasePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsuserBasePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsuserBasePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label">用户名</label></td>
		     <td class="value"><input class="inputxt" id="userName" name="userName" datatype="*" value="${tsuserBasePage.userName} " > <span class="Validform_checktip"></span></td>
			</tr>
			
			<tr>
			<td align="right"><label class="Validform_label">真实姓名</label></td>
		     <td class="value"><input class="inputxt" id="realName" name="realName" datatype="*" value="${tsuserBasePage.realName} " > <span class="Validform_checktip"></span></td>
		    </tr>
		
			  <tr>
             <td align="right"><label class="Validform_label">职责: </label></td>
		     <td class="value"><input class="inputxt" id="position" name="position" datatype="*" value="${tsuserBasePage.position}"> <span class="Validform_checktip"></span></td>
            </tr>
            <tr>
			<td align="right"><label class="Validform_label">所属部门: </label></td>
		     <td class="value"><input class="inputxt" id="departName" name="departName" datatype="*" value="${tsuserBasePage.departName}"> <span class="Validform_checktip"></span></td>
			
			</tr>
            <tr>
			<td align="right"><label class="Validform_label">邮箱: </label></td>
		     <td class="value"><input class="inputxt" id="email" name="email"  datatype="e" value="${tsuserBasePage.email}"> <span class="Validform_checktip"></span></td>
			
			</tr>
		
			
		</table>
	</t:formvalid>
</body>