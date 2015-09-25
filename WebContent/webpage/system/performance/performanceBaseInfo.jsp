<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>绩效管理基础数据</title>
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
		layout="table" action="tsperformanceBaseController.do?save">
		<input id="id" name="id" type="hidden" value="${tsperformanceBasePage.id }">
		<input id="createName" name="createUser" type="hidden"
			value="${tsperformanceBasePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsperformanceBasePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsperformanceBasePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsperformanceBasePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsperformanceBasePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsperformanceBasePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label">绩效名称</label></td>
		     <td class="value"><input class="inputxt" id="perforName" name="perforName"  value="${tsperformanceBasePage.perforName} " > <span class="Validform_checktip"></span></td>
			</tr>
			
			<tr>
			<td align="right"><label class="Validform_label">绩效类别</label></td>
		     <td class="value"><input class="inputxt" id="perforType" name="perforType"  value="${tsperformanceBasePage.perforType} " > <span class="Validform_checktip"></span></td>
		    </tr>
		
			  <tr>
             <td align="right"><label class="Validform_label">绩效明细: </label></td>
		     <td class="value"><input class="inputxt" id="perforDetail" name="perforDetail"  value="${tsperformanceBasePage.perforDetail}"> <span class="Validform_checktip"></span></td>
            </tr>
            <tr>
			<td align="right"><label class="Validform_label">分值: </label></td>
		     <td class="value"><input class="inputxt" id="score" name="score"  value="${tsperformanceBasePage.score}"> <span class="Validform_checktip"></span></td>
			
			</tr>
		
			
		</table>
	</t:formvalid>
</body>