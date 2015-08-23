<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>配送管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
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
  	function close(){
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
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tsdeliveryInfoController.do?save">
	<input id="id" name="id" type="hidden" value="${tsDeliveryPage.id }">
	
    <input id="createName" name="createUser" type="hidden" value="${tsDeliveryPage.createName}">
    <input id="createDate" name="createTime" type="hidden" value="${tsDeliveryPage.createDate}">
    <input id="updateName" name="updateUser" type="hidden" value="${tsDeliveryPage.updateName}">
    <input id="updateDate" name="createUser" type="hidden" value="${tsDeliveryPage.updateDate}">
    <input id="updateBy" name="updateBy" type="hidden" value="${tsDeliveryPage.updateBy}">
    <input id="createBy" name="createBy" type="hidden" value="${tsDeliveryPage.createBy}">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 公司: </label></td>
			<td class="value"><input class="inputxt" id="company" name="company"  value="${tsDeliveryPage.company}"> <span class="Validform_checktip"></span></td>
	     	<td align="right"><label class="Validform_label"> 暂无: </label></td>
			<td class="value"><input class="inputxt" id="" name=""  value=""> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 送达方: </label></td>
			<td class="value"><input class="inputxt" id="sendCode" name="sendCode"  value="${tsDeliveryPage.sendCode}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label"> 送达方名称: </label></td>
			<td class="value"><input class="inputxt" id="sendName" name="sendName"  value="${tsDeliveryPage.sendName}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 售达方: </label></td>
			<td class="value"><input class="inputxt" id="saleCode" name="saleCode"  value="${tsDeliveryPage.saleCode}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label"> 售达方名称: </label></td>
			<td class="value"><input class="inputxt" id="saleName" name="saleName"  value="${tsDeliveryPage.saleName}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		
		 <tr>
			 
			 <td align="right"><label class="Validform_label">发货单类型: </label></td>
			 <td>
	         <t:dictSelect field="fhdType" typeGroupCode="fhd_type" defaultVal="${tsDeliveryPage.fhdType}" hasLabel="false"></t:dictSelect>
	         </td>
	    
			<td align="right"><label class="Validform_label">发票是否随货:</label></td>
			 <td>
	         <t:dictSelect field="isInvoice" typeGroupCode="is_invoice" defaultVal="${tsDeliveryPage.isInvoice}" hasLabel="false"></t:dictSelect>
	        </td>
			</tr>
			
			<tr>
			<td align="right"><label class="Validform_label"> 发货单备注: </label></td>
			<td class="value"><input class="inputxt" id="fhdReq" name="fhdReq"  value="${tsDeliveryPage.fhdReq}"> <span class="Validform_checktip"></span></td>
		   
		   <td align="right"><label class="Validform_label"> 份数: </label></td>
		   <td class="value"><input class="inputxt" id="fhdNum" name="fhdNum"  value="${tsDeliveryPage.fhdNum}"> <span class="Validform_checktip"></span></td>
		
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label">发票要求: </label></td>
			<td class="value"><input class="inputxt" id="invoiceReq" name="invoiceReq"  value="${tsDeliveryPage.invoiceReq}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 回单要求: </label></td>
			<td class="value"><input class="inputxt" id="receiptReq" name="receiptReq"  value="${tsDeliveryPage.receiptReq}"> <span class="Validform_checktip"></span></td>
			
			<td align="right"><label class="Validform_label"> 装箱要求: </label></td>
			<td class="value"><input class="inputxt" id="binningReq" name="binningReq"  value="${tsDeliveryPage.binningReq}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		
		
		<tr>
			<td></td>
			<td colspan="3" class="value"><script type="text/javascript">
					$.dialog.setting.zIndex =1990;
					function del(url,obj){
						$.dialog.confirm("确认删除该条记录?", function(){
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
						}, function(){
						});
					}
					</script>
					
			</td>
		</tr>
		<tr>
				<td align="right"><label class="Validform_label"> 其他要求:
				</label></td>
				<td class="value"><textarea name="otherReq" id="otherReq" style="width:300px;height:150px;">${tsDeliveryPage.otherReq}</textarea></td>
		       <td align="right"><label class="Validform_label"> 备注:
				</label></td>
				<td class="value"><textarea name="deliveryDesc" id="deliveryDesc" style="width:300px;height:150px;">${tsDeliveryPage.deliveryDesc}</textarea></td>
		
		
		</tr>
		
	</table>
</t:formvalid>
</body>