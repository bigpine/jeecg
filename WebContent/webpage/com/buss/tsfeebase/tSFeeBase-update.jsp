<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>费用基础信息</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="tSFeeBaseController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${tSFeeBasePage.id }">
					<input id="createName" name="createName" type="hidden" value="${tSFeeBasePage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${tSFeeBasePage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${tSFeeBasePage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${tSFeeBasePage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${tSFeeBasePage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${tSFeeBasePage.updateDate }">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">费用类别:</label>
			</td>
			<td class="value">
					<t:dictSelect field="feeType" type="list"
						typeGroupCode="fee_type" defaultVal="${tSFeeBasePage.feeType}" hasLabel="false"  title="费用类别"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">费用类别</label>
			</td>
			<td align="right">
				<label class="Validform_label">字段一:</label>
			</td>
			<td class="value">
		     	 <input id="feeFieds" name="feeFieds" type="text" style="width: 150px" class="inputxt" value='${tSFeeBasePage.feeFieds}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">字段一</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="tSFeeBaseController.do?tSCarriageFeeList&id=${tSFeeBasePage.id}" icon="icon-search" title="运输费用管理" id="tSCarriageFee"></t:tab>
				 <t:tab href="tSFeeBaseController.do?tSVehicleFeeList&id=${tSFeeBasePage.id}" icon="icon-search" title="车辆费用管理" id="tSVehicleFee"></t:tab>
				 <t:tab href="tSFeeBaseController.do?tSMaterialFeeList&id=${tSFeeBasePage.id}" icon="icon-search" title="耗材费用管理" id="tSMaterialFee"></t:tab>
				 <t:tab href="tSFeeBaseController.do?tSFeeDailyList&id=${tSFeeBasePage.id}" icon="icon-search" title="日常费用管理" id="tSFeeDaily"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_tSCarriageFee_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].carrier" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">承运商</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].origin" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">起始地</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].destination" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">目的地</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].reqTemp" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">要求温度</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].arrTemp" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">到货温度</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].volume" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">体积</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].weight" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">重量</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].model" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">车型</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="tSCarriageFeeList[#index#].payType" type="list"
										typeGroupCode="pay_type" defaultVal="" hasLabel="false"  title="结算方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">结算方式</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].price" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].sendNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发车次数</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].instrument" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">仪器型号</label>
				  </td>
				  <td align="left">
							<input name="tSCarriageFeeList[#index#].sendDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发车日期</label>
				  </td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[#index#].carriageDesc" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tSVehicleFee_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<input name="tSVehicleFeeList[#index#].sendDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发车日期</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].carCode" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">车牌</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].driver" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">驾驶员</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].dayKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">当天行驶公里</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].outKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">下班公里</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].parkFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">园区停车</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].oilFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">油费</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].oilMouse" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">油耗</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].stopFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">停车费</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].pikeFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">通行费</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].serviceFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">维修费</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].washFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">洗车费</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].etcFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">ETC费用</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].startKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">出车里程</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].endKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">回程里程</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].addOilKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">加油里程数</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].oilNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">加油公升数</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].serviceDetail" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">维修明细</label>
				  </td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[#index#].feeId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用基础ID</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tSMaterialFee_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<t:dictSelect field="tSMaterialFeeList[#index#].itemName" type="list"
										typeGroupCode="subject" defaultVal="" hasLabel="false"  title="科目"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">科目</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[#index#].itemDetail" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">明细</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[#index#].standard" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">规格</label>
				  </td>
				  <td align="left">
							<input name="tSMaterialFeeList[#index#].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发生日期</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[#index#].price" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[#index#].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总额</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[#index#].supplier" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">供应商</label>
				  </td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[#index#].feeId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用基础ID</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tSFeeDaily_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tSFeeDailyList[#index#].feeName" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用名称</label>
				  </td>
				  <td align="left">
					  	<input name="tSFeeDailyList[#index#].floor" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">楼层</label>
				  </td>
				  <td align="left">
							<input name="tSFeeDailyList[#index#].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发生日期</label>
				  </td>
				  <td align="left">
					  	<input name="tSFeeDailyList[#index#].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/tsfeebase/tSFeeBase.js"></script>	