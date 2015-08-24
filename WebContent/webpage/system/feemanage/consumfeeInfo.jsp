<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>耗材费用管理</title>
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
		layout="table" action="tsconsumfeeController.do?save">
		<input id="id" name="id" type="hidden" value="${tsConsumFeePage.id }">

		<input id="createName" name="createUser" type="hidden"
			value="${tsConsumFeePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsConsumFeePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsConsumFeePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsConsumFeePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsConsumFeePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsConsumFeePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label">科目:</label></td>
			 <td>
	         <t:dictSelect field="itemName" typeGroupCode="subject" defaultVal="${tsConsumFeePage.itemName}" hasLabel="false"></t:dictSelect>
	        </td>
	        
	          <td align="right"><label class="Validform_label">明细: </label></td>
		     <td class="value"><input class="inputxt" id="itemDetail" name="itemDetail"  value="${tsConsumFeePage.itemDetail}"> <span class="Validform_checktip"></span></td>
	        
		</tr>
		<tr>
             <td align="right"><label class="Validform_label">规格: </label></td>
		     <td class="value"><input class="inputxt" id="standard" name="standard"  value="${tsConsumFeePage.standard}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 供应商: </label></td>
		     <td class="value"><input class="inputxt" id="supplier" name="supplier"  value="${tsConsumFeePage.supplier}"> <span class="Validform_checktip"></span></td>

			</tr>
           <tr>
             <td align="right"><label class="Validform_label">单价: </label></td>
		     <td class="value"><input class="inputxt" id="price" name="price"  value="${tsConsumFeePage.price}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 数量: </label></td>
		     <td class="value"><input class="inputxt" id="itemNum" name="itemNum"  value="${tsConsumFeePage.itemNum}"> <span class="Validform_checktip"></span></td>

			</tr>
			
			  <tr>
            <td align="right"><label class="Validform_label"> 发生日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="markDate" name="markDate" ignore="ignore"
				value="<fmt:formatDate value='${tsConsumFeePage.markDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 金额: </label></td>
		     <td class="value"><input class="inputxt" id="amout" name="amout"  value="${tsConsumFeePage.amout}"> <span class="Validform_checktip"></span></td>

			</tr>
            <tr>
            <td align="right"><label class="Validform_label">费用类别:</label></td>
			 <td>
	         <t:dictSelect field="feeType" typeGroupCode="fee_type" defaultVal="${tsConsumFeePage.feeType}" hasLabel="false"></t:dictSelect>
	        </td>
            </tr>
            
			<!-- <tr>
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
			</tr> -->
		</table>
	</t:formvalid>
</body>