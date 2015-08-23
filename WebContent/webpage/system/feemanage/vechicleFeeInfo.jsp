<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>车辆费用管理</title>
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
		layout="table" action="tsvechiclefeeController.do?save">
		<input id="id" name="id" type="hidden" value="${tsVechicleFeePage.id }">

		<input id="createName" name="createUser" type="hidden"
			value="${tsVechicleFeePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsVechicleFeePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsVechicleFeePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsVechicleFeePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsVechicleFeePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsVechicleFeePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label"> 出车日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="sendDate" name="sendDate" ignore="ignore"
				value="<fmt:formatDate value='${tsVechicleFeePage.sendDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
			
			<td align="right"><label class="Validform_label">车牌:</label></td>
			 <td>
	         <t:dictSelect field="carCode" typeGroupCode="car_code" defaultVal="${tsVechicleFeePage.carCode}" hasLabel="false"></t:dictSelect>
	        </td>
		</tr>
		<tr>
             <td align="right"><label class="Validform_label">驾驶员: </label></td>
		     <td class="value"><input class="inputxt" id="driver" name="driver"  value="${tsVechicleFeePage.driver}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 当天公里数: </label></td>
		     <td class="value"><input class="inputxt" id="dayKm" name="dayKm"  value="${tsVechicleFeePage.dayKm}"> <span class="Validform_checktip"></span></td>

			</tr>
           <tr>
             <td align="right"><label class="Validform_label">下班公里数: </label></td>
		     <td class="value"><input class="inputxt" id="outKm" name="outKm"  value="${tsVechicleFeePage.outKm}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 园区停车: </label></td>
		     <td class="value"><input class="inputxt" id="parkFee" name="parkFee"  value="${tsVechicleFeePage.parkFee}"> <span class="Validform_checktip"></span></td>

			</tr>
			  <tr>
             <td align="right"><label class="Validform_label">油费: </label></td>
		     <td class="value"><input class="inputxt" id="oilFee" name="oilFee"  value="${tsVechicleFeePage.oilFee}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 油耗: </label></td>
		     <td class="value"><input class="inputxt" id="oilMouse" name="oilMouse"  value="${tsVechicleFeePage.oilMouse}"> <span class="Validform_checktip"></span></td>

			</tr>
			  <tr>
             <td align="right"><label class="Validform_label">出车里程: </label></td>
		     <td class="value"><input class="inputxt" id="startKm" name="startKm"  value="${tsVechicleFeePage.startKm}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 回车里程: </label></td>
		     <td class="value"><input class="inputxt" id="endKm" name="endKm"  value="${tsVechicleFeePage.endKm}"> <span class="Validform_checktip"></span></td>

			</tr>
			  <tr>
             <td align="right"><label class="Validform_label">停车费: </label></td>
		     <td class="value"><input class="inputxt" id="stopFee" name="stopFee"  value="${tsVechicleFeePage.stopFee}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 通行费: </label></td>
		     <td class="value"><input class="inputxt" id="pikeFee" name="pikeFee"  value="${tsVechicleFeePage.pikeFee}"> <span class="Validform_checktip"></span></td>

			</tr>
			
			 <tr>
             <td align="right"><label class="Validform_label">维修费: </label></td>
		     <td class="value"><input class="inputxt" id="serviceFee" name="serviceFee"  value="${tsVechicleFeePage.serviceFee}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 洗车费: </label></td>
		     <td class="value"><input class="inputxt" id="washFee" name="washFee"  value="${tsVechicleFeePage.washFee}"> <span class="Validform_checktip"></span></td>
			</tr>
			 <tr>
             <td align="right"><label class="Validform_label">ETC </label></td>
		     <td class="value"><input class="inputxt" id="etcFee" name="etcFee"  value="${tsVechicleFeePage.etcFee}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 加油里程数 </label></td>
		     <td class="value"><input class="inputxt" id="addOilKm" name="addOilKm"  value="${tsVechicleFeePage.addOilKm}"> <span class="Validform_checktip"></span></td>
			</tr>
			
			 <tr>
			 <td align="right"><label class="Validform_label"> 加油/公升 </label></td>
		     <td class="value"><input class="inputxt" id="oilNum" name="oilNum"  value="${tsVechicleFeePage.oilNum}"> <span class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 维修明细:
				</label></td>
				<td class="value"><textarea name="serviceDetail" id="serviceDetail" style="width:300px;height:300px;">${tsVechicleFeePage.serviceDetail}</textarea></td>
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