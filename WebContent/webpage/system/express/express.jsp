<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>快递管理</title>
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
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tsexpressController.do?save">
	<input id="id" name="id" type="hidden" value="${tsExpressPage.id }">
	
    <input id="createName" name="createUser" type="hidden" value="${tsExpressPage.createName}">
    <input id="createDate" name="createTime" type="hidden" value="${tsExpressPage.createDate}">
    <input id="updateName" name="updateUser" type="hidden" value="${tsExpressPage.updateName}">
    <input id="updateDate" name="createUser" type="hidden" value="${tsExpressPage.updateDate}">
    <input id="updateBy" name="updateBy" type="hidden" value="${tsExpressPage.updateBy}">
    <input id="createBy" name="createBy" type="hidden" value="${tsExpressPage.createBy}">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 发运订单: </label></td>
			<td class="value"><input class="inputxt" id="sendOrderNum" name="sendOrderNum"  value="${tsExpressPage.sendOrderNum}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 快递单号: </label></td>
			<td class="value"><input class="inputxt" id="expressNum" name="expressNum"  value="${tsExpressPage.expressNum}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 发运日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="sendDate" name="sendDate" ignore="ignore"
				value="<fmt:formatDate value='${tsExpressPage.sendDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 寄件公司: </label></td>
			<td class="value"><input class="inputxt" id="sendCompany" name="sendCompany"  value="${tsExpressPage.sendCompany}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 寄件人: </label></td>
			<td class="value"><input class="inputxt" id="sendContactName" name="sendContactName"  value="${tsExpressPage.sendContactName}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 寄件地址: </label></td>
			<td class="value"><input class="inputxt" id="sendAddress" name="sendAddress"  value="${tsExpressPage.sendAddress}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 收件公司: </label></td>
			<td class="value"><input class="inputxt" id="cCompany" name="cCompany"  value="${tsExpressPage.cCompany}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 收货人: </label></td>
			<td class="value"><input class="inputxt" id="consignee" name="consignee"  value="${tsExpressPage.consignee}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 寄件地址: </label></td>
			<td class="value"><input class="inputxt" id="cAddress" name="cAddress"  value="${tsExpressPage.cAddress}"> <span class="Validform_checktip"></span></td>
		
		</tr>
	    <tr>
	    <td align="right"><label class="Validform_label"> 回单状态:
				</label></td>
				<td>
	<t:dictSelect field="receiptStatus" typeGroupCode="rec_status" defaultVal="${tsExpressPage.receiptStatus}" hasLabel="false"></t:dictSelect>
			</td>			
	    </tr>
	    <tr>
	    <td align="right"><label class="Validform_label"> 承运商:
				</label></td>
				<td>
	<t:dictSelect field="carrier" typeGroupCode="carrier" defaultVal="${tsExpressPage.carrier}" hasLabel="false"></t:dictSelect>
			</td>			
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
				<td align="right"><label class="Validform_label"> 备注信息:
				</label></td>
				<td class="value"><textarea name="expressDesc" id="expressDesc" style="width:800px;height:300px;">${tsExpressPage.expressDesc}</textarea></td>
		</tr>
	</table>
</t:formvalid>
</body>