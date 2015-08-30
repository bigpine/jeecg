<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>日常费用管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function() {
		//查看模式情况下,删除和上传附件功能禁止使用
		if (location.href.indexOf("load=detail") != -1) {
			$(".jeecgDetail").hide();
		}
		var feeName = $("#feeName1").val();
		if(feeName != ''){
			var isExist = false;
			var count = $("#feeName").find("option").length;
			for(var i=0; i<count; i++){
				if($("#feeName").get(0).options[i].value == feeName){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#feeName").append("<option value='${tsBaseFeePage.feeName}'>${tsBaseFeePage.feeName}</option>");
			}
			$("#feeName").attr("value",'${tsBaseFeePage.feeName}');
		}
	});
   function selectValidate(){
	   //val selectData = $("#feeName").find("option:selected").val();
	   alert(111);
	   alert(selectData);
   }
	
	
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
		layout="table" action="tsbasefeeController.do?save">
		<input id="id" name="id" type="hidden" value="${tsBaseFeePage.id }">
		<input id="feeName1" name="feeName1" type="hidden" value="${tsBaseFeePage.feeName}">

		<input id="createName" name="createUser" type="hidden"
			value="${tsBaseFeePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsBaseFeePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsBaseFeePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsBaseFeePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsBaseFeePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsBaseFeePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label">费用项目:</label></td>
			 <%-- <td>
	         <t:dictSelect field="feeName" typeGroupCode="fee_item" defaultVal="${tsBaseFeePage.feeName}" hasLabel="false"></t:dictSelect>
	        </td> --%>
	        <td class="value">
	        <select  id="feeName" name="feeName" ><!-- onchange="selectValidate()">  -->
	         <!-- <option>请选择</option>      -->     
             <option value="电费">电费</option>              
             <option value="水费">水费</option>              
             <option value="物业费">物业费</option>              
             <option value="房租费">房租费</option>              
             <option value="仓储费">仓储费</option>         
             </select> 
	        
	        </td>
			 <td align="right"><label class="Validform_label"> 楼层: </label></td>
		     <td class="value"><input class="inputxt" id="floor" name="floor"  value="${tsBaseFeePage.floor}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>

			<td align="right"><label class="Validform_label"> 发生日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="markDate" name="markDate" ignore="ignore"
				value="<fmt:formatDate value='${tsBaseFeePage.markDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 费用金额: </label></td>
		     <td class="value"><input class="inputxt" id="amout" name="amout"  value="${tsBaseFeePage.amout}"> <span class="Validform_checktip"></span></td>

			</tr>
		</table>
	</t:formvalid>
</body>