<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>耗材基础资料信息</title>
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
		layout="table" action="tsconsumbaseController.do?save">
		<input id="id" name="id" type="hidden" value="${tsConsumbasePage.id }">
		<input id="createName" name="createUser" type="hidden"
			value="${tsConsumbasePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsConsumbasePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsConsumbasePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsConsumbasePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsConsumbasePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsConsumbasePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			
	        <td align="right"><label class="Validform_label">科目:</label></td>
		   <td class="value"><input class="inputxt" id="itemName" name="itemName"  value="${tsConsumbasePage.itemName}"> <span class="Validform_checktip"></span></td>
	      
	      <td align="right"><label class="Validform_label">明细: </label></td>
		  <td class="value"><input class="inputxt" id="itemDetail" name="itemDetail"  value="${tsConsumbasePage.itemDetail}"> <span class="Validform_checktip"></span></td>
	     
		</tr>
		<tr>
             <td align="right"><label class="Validform_label">规格: </label></td>
		     <td class="value"><input class="inputxt" id="standard" name="standard"  value="${tsConsumbasePage.standard}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 供应商: </label></td>
		     <td class="value"><input class="inputxt" id="supplier" name="supplier"  value="${tsConsumbasePage.supplier}"> <span class="Validform_checktip"></span></td>

			</tr>
           <tr>
             <td align="right"><label class="Validform_label">单价: </label></td>
		     <td class="value"><input class="inputxt" id="price" name="price"  value="${tsConsumbasePage.price}"> <span class="Validform_checktip"></span></td>

			</tr>
		</table>
	</t:formvalid>
</body>