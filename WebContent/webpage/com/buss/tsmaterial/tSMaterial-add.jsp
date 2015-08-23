<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>耗材基础信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="tSMaterialController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${tSMaterialPage.id }">
					<input id="createName" name="createName" type="hidden" value="${tSMaterialPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${tSMaterialPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${tSMaterialPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${tSMaterialPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${tSMaterialPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${tSMaterialPage.updateDate }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">科目:</label>
			</td>
			<td class="value">
					<t:dictSelect field="itemName" type="list"
						typeGroupCode="subject"  hasLabel="false"  title="科目"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">科目</label>
			</td>
			<td align="right">
				<label class="Validform_label">明细:</label>
			</td>
			<td class="value">
		     	 <input id="itemDetail" name="itemDetail" type="text" style="width: 150px" class="inputxt">
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">明细</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">规格:</label>
			</td>
			<td class="value">
		     	 <input id="standard" name="standard" type="text" style="width: 150px" class="inputxt">
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">规格</label>
			</td>
			<td align="right">
				<label class="Validform_label">单价:</label>
			</td>
			<td class="value">
		     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt">
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单价</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">供应商:</label>
			</td>
			<td class="value">
		     	 <input id="supplier" name="supplier" type="text" style="width: 150px" class="inputxt">
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">供应商</label>
			</td>
		</tr>
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="tSMaterialController.do?tSMaterialinfoList&id=${tSMaterialPage.id}" icon="icon-search" title="耗材费用管理" id="tSMaterialinfo"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_tSMaterialinfo_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tSMaterialinfoList[#index#].itemNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialinfoList[#index#].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发生日期</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialinfoList[#index#].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总额</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/tsmaterial/tSMaterial.js"></script>	