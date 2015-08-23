<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>费用管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function() {
		//查看模式情况下,删除和上传附件功能禁止使用
		if (location.href.indexOf("load=detail") != -1) {
			$(".jeecgDetail").hide();
		}
	});

	/* 	function uploadFile(data){
			$("#projectId").val(data.obj.id);
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				frameElement.api.opener.reloadTable();
				frameElement.api.close();
			}
		}
	 */
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
		layout="table" action="tsfeemanageController.do?save">
		<input id="id" name="id" type="hidden" value="${tsFeeManagePage.id }">

		<input id="createName" name="createUser" type="hidden"
			value="${tsFeeManagePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsFeeManagePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsFeeManagePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsFeeManagePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsFeeManagePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsFeeManagePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label">费用类别:</label></td>
			 <td>
	         <t:dictSelect field="feeType" typeGroupCode="fee_type" defaultVal="${tsFeeManagePage.feeType}" hasLabel="false"></t:dictSelect>
	        </td>
			 <td align="right"><label class="Validform_label"> 字段一: </label></td>
		     <td class="value"><input class="inputxt" id="feeFied1" name="feeFied1"  value="${tsFeeManagePage.feeFied1}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>

			<td align="right"><label class="Validform_label"> 字段二: </label></td>
		     <td class="value"><input class="inputxt" id="feeFied2" name="feeFied2"  value="${tsFeeManagePage.feeFied2}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 字段三: </label></td>
		     <td class="value"><input class="inputxt" id="feeFied3" name="feeFied3"  value="${tsFeeManagePage.feeFied3}"> <span class="Validform_checktip"></span></td>

			</tr>
			<tr>

			 <td align="right"><label class="Validform_label"> 字段四: </label></td>
		     <td class="value"><input class="inputxt" id="feeFied4" name="feeFied4"  value="${tsFeeManagePage.feeFied4}"> <span class="Validform_checktip"></span></td>

			</tr>

			<tr>
				<td></td>
				<td colspan="3" class="value"><script type="text/javascript">
					$.dialog.setting.zIndex = 1990;
					function del(url, obj) {
						$.dialog.confirm("确认删除该条记录?", function() {
							$.ajax({
								async : false,
								cache : false,
								type : 'POST',
								url : url,// 请求的action路径
								error : function() {// 请求失败处理函数
								},
								success : function(data) {
									var d = $.parseJSON(data);
									if (d.success) {
										var msg = d.msg;
										tip(msg);
										$(obj).closest("tr").hide("slow");
									}
								}
							});
						}, function() {
						});
					}
				</script></td>
			</tr>
		</table>
	</t:formvalid>
</body>