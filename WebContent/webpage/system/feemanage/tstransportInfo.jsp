<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>运输费用管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function() {
		//查看模式情况下,删除和上传附件功能禁止使用
		if (location.href.indexOf("load=detail") != -1) {
			$(".jeecgDetail").hide();
		}
		$('#sendNum, #price').live('keyup', function(){
			$('#amout').val($('#price').val() * $('#sendNum').val() );
		});
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
		layout="table" action="tstransportfeeController.do?save">
		<input id="id" name="id" type="hidden" value="${tsTransportPage.id }">

		<input id="createName" name="createUser" type="hidden"
			value="${tsTransportPage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsTransportPage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsTransportPage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsTransportPage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsTransportPage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsTransportPage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			 <td align="right"><label class="Validform_label"> 发车日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="sendDate" name="sendDate" ignore="ignore"
				value="<fmt:formatDate value='${tsTransportPage.sendDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
			 <td align="right"><label class="Validform_label"> 到货日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="arrDate" name="arrDate" ignore="ignore"
				value="<fmt:formatDate value='${tsTransportPage.arrDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>

		</tr>
		<tr>
             <td align="right"><label class="Validform_label">始发地: </label></td>
		     <td class="value"><input class="inputxt" id="origin" name="origin"  value="${tsTransportPage.origin}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 目的地: </label></td>
		     <td class="value"><input class="inputxt" id="destination" name="destination"  value="${tsTransportPage.destination}"> <span class="Validform_checktip"></span></td>

		</tr>
		
           <tr>
             <td align="right"><label class="Validform_label">要求温度: </label></td>
		     <td class="value"><input class="inputxt" id="reqTemp" name="reqTemp"  value="${tsTransportPage.reqTemp}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 到货温度: </label></td>
		     <td class="value"><input class="inputxt" id="arrTemp" name="arrTemp"  value="${tsTransportPage.arrTemp}"> <span class="Validform_checktip"></span></td>

			</tr>
			
			  <tr>
            <td align="right"><label class="Validform_label">结算方式:</label></td>
			 <td>
	         <t:dictSelect field="payType" typeGroupCode="pay_type" defaultVal="${tsTransportPage.payType}" hasLabel="false"></t:dictSelect>
	        </td>
			 <td align="right"><label class="Validform_label"> 单价: </label></td>
		     <td class="value"><input class="inputxt" id="price" name="price"  value="${tsTransportPage.price}">元<span class="Validform_checktip"></span></td>

			</tr>
			<tr>
             <td align="right"><label class="Validform_label">发运次数: </label></td>
		     <td class="value"><input class="inputxt" id="sendNum" name="sendNum"  value="${tsTransportPage.sendNum}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 金额: </label></td>
		     <td class="value"><input class="inputxt" id="amout" name="amout" readonly="readonly" value="${tsTransportPage.amout}">元<span class="Validform_checktip"></span></td>

		     </tr>
		     <tr>
             <td align="right"><label class="Validform_label">仪器名称: </label></td>
		     <td class="value"><input class="inputxt" id="instrument" name="instrument"  value="${tsTransportPage.instrument}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 车型: </label></td>
		     <td class="value"><input class="inputxt" id="model" name="model"  value="${tsTransportPage.model}"> <span class="Validform_checktip"></span></td>

		     </tr>
			 <tr>
            
			 <td align="right"><label class="Validform_label"> 体积: </label></td>
		     <td class="value"><input class="inputxt" id="volume" name="volume"  value="${tsTransportPage.volume}">M3 <span class="Validform_checktip"></span></td>
			 <td align="right"><label class="Validform_label"> 重量: </label></td>
		     <td class="value"><input class="inputxt" id="weight" name="weight"  value="${tsTransportPage.weight}">KG <span class="Validform_checktip"></span></td>

			</tr>
			<tr>
			<td align="right"><label class="Validform_label">承运商: </label></td>
		     <td class="value"><input class="inputxt" id="carrier" name="carrier"  value="${tsTransportPage.carrier}"> <span class="Validform_checktip"></span></td>
	        
			</tr>
	        <tr>
	         
				<td align="right"><label class="Validform_label"> 备注:
				</label></td>
				<td class="value"><textarea name="carriageDesc" id="carriageDesc" style="width:300px;height:300px;">${tsTransportPage.carriageDesc}</textarea></td>
		   </tr>
			
		</table>
	</t:formvalid>
</body>