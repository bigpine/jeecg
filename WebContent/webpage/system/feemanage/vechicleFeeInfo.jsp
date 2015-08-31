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
		var carCode = $("#carCode1").val();
		if(carCode != ''){
			var isExist = false;
			var count = $("#carCode").find("option").length;
			for(var i=0; i<count; i++){
				if($("#carCode").get(0).options[i].value == carCode){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#carCode").append("<option value='${tsVechicleFeePage.carCode}'>${tsVechicleFeePage.carCode}</option>");
			}
			$("#carCode").attr("value",'${tsVechicleFeePage.carCode}');
		}
		
		var driverName = $("#driverName1").val();
		if(driverName != ''){
			var isExist = false;
			var count = $("#driverName").find("option").length;
			for(var i=0; i<count; i++){
				if($("#driverName").get(0).options[i].value == driverName){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#driverName").append("<option value='${tsVechicleFeePage.driver}'>${tsVechicleFeePage.driver}</option>");
			}
			$("#driverName").attr("value",'${tsVechicleFeePage.driver}');
		}
		
		//计算当天行驶里程数
		$('#startKm, #endKm').live('keyup', function(){
			$('#dayKm').val($('#endKm').val() - $('#startKm').val() );
		});
		//计算当天产生的费用总和
	/* 	var oilFee= $('#oilFee').val;
		if(oilFee==""){
			oilFee=0;
		}
		var stopFee= $('#stopFee').val;
		if(stopFee==""){
			stopFee=0;
		}
		var pikeFee= $('#pikeFee').val;
		if(pikeFee==""){
			pikeFee=0;
		}
		var serviceFee= $('#serviceFee').val;
		if(serviceFee==""){
			serviceFee=0;
		}
		var washFee= $('#washFee').val;
		if(washFee==""){
			washFee=0;
		}
		var etcFee= $('#etcFee').val;
		if(etcFee==""){
			etcFee=0;
		} */
		$('#oilFee, #stopFee,#pikeFee,#serviceFee,#washFee,#etcFee').live('keyup', function(){
			
			$('#amout').val(parseFloat($('#oilFee').val()) + parseFloat($('#stopFee').val())+parseFloat($('#pikeFee').val())+parseFloat($('#serviceFee').val())+parseFloat($('#washFee').val())+parseFloat($('#etcFee').val()));
		});
		
		
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
		<input id="driverName1" name="driverName1" type="hidden" value="${tsVechicleFeePage.driver}">
	    <input id="carCode1" name="carCode1" type="hidden" value="${tsVechicleFeePage.carCode}">
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
			
			<td align="right"><label class="Validform_label">总费用</label></td>
		     <td class="value"><input class="inputxt" id="amout" name="amout"  value="${tsVechicleFeePage.amout} " readonly="readonly"> <span class="Validform_checktip"></span></td>
			
			
		</tr>
		<tr>
		<td align="right"><label class="Validform_label">车牌:</label></td>
			
	         <td class="value">
	         <select  id="carCode" name="carCode" >
             <option value="ATF272">沪ATF272</option>    
             <option value="NR1901">沪NR1901</option> 			 
             <option value="BT1701">沪BT1701</option>              
             <option value="GB7559">沪GB7559</option>              
             <option value="L58137">沪L58137</option>              
             <option value="GB5696">沪GB5696</option>              
            </select> 
           </td>
             <td align="right"><label class="Validform_label">驾驶员:</label></td>
			 
	        <td class="value">
	        <select  id="driverName" name="driverName" >
             <option value="孙俊">孙俊</option>    
             <option value="陆惠明">陆惠明</option> 			 
             <option value="朱黎清">朱黎清</option>              
             <option value="沈韬">沈韬</option>              
             <option value="陆建平">陆建平</option>              
            </select> 
	        
	        </td>
		   
			
			</tr>
			  <tr>
             <td align="right"><label class="Validform_label">出车里程: </label></td>
		     <td class="value"><input class="inputxt" id="startKm" name="startKm"  value="${tsVechicleFeePage.startKm}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 回车里程: </label></td>
		     <td class="value"><input class="inputxt" id="endKm" name="endKm"  value="${tsVechicleFeePage.endKm}"> <span class="Validform_checktip"></span></td>

			</tr>
			<tr>
			
			 <td align="right"><label class="Validform_label"> 当天公里数: </label></td>
		     <td class="value"><input class="inputxt" id="dayKm" name="dayKm"  value="${tsVechicleFeePage.dayKm}" readonly="readonly"> <span class="Validform_checktip"></span></td>
			
			 <td align="right"><label class="Validform_label">下班公里数: </label></td>
		     <td class="value"><input class="inputxt" id="outKm" name="outKm"  value="${tsVechicleFeePage.outKm}"> <span class="Validform_checktip"></span></td>
			
			
			</tr>
           <tr>
            
			 <td align="right"><label class="Validform_label"> 园区停车费: </label></td>
		     <td class="value"><input class="inputxt" id="parkFee" name="parkFee"  value="${tsVechicleFeePage.parkFee}"> <span class="Validform_checktip"></span></td>

             <td align="right"><label class="Validform_label">停车费: </label></td>
		     <td class="value"><input class="inputxt" id="stopFee" name="stopFee"  value="${tsVechicleFeePage.stopFee}"> <span class="Validform_checktip"></span></td>

			</tr>
			  <tr>
             <td align="right"><label class="Validform_label">油费: </label></td>
		     <td class="value"><input class="inputxt" id="oilFee" name="oilFee"  value="${tsVechicleFeePage.oilFee}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 油耗: </label></td>
		     <td class="value"><input class="inputxt" id="oilMouse" name="oilMouse"  value="${tsVechicleFeePage.oilMouse}"> <span class="Validform_checktip"></span></td>

			</tr>
			
			  <tr>
           
			 <td align="right"><label class="Validform_label"> 通行费: </label></td>
		     <td class="value"><input class="inputxt" id="pikeFee" name="pikeFee"  value="${tsVechicleFeePage.pikeFee}"> <span class="Validform_checktip"></span></td>
             
             <td align="right"><label class="Validform_label">ETC </label></td>
		     <td class="value"><input class="inputxt" id="etcFee" name="etcFee"  value="${tsVechicleFeePage.etcFee}"> <span class="Validform_checktip"></span></td>

			</tr>
			
			 <tr>
             <td align="right"><label class="Validform_label">维修费: </label></td>
		     <td class="value"><input class="inputxt" id="serviceFee" name="serviceFee"  value="${tsVechicleFeePage.serviceFee}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 洗车费: </label></td>
		     <td class="value"><input class="inputxt" id="washFee" name="washFee"  value="${tsVechicleFeePage.washFee}"> <span class="Validform_checktip"></span></td>
			</tr>
			 <tr>
             
			 <td align="right"><label class="Validform_label"> 加油里程数 </label></td>
		     <td class="value"><input class="inputxt" id="addOilKm" name="addOilKm"  value="${tsVechicleFeePage.addOilKm}"> <span class="Validform_checktip"></span></td>
		
		    <td align="right"><label class="Validform_label"> 加油/公升 </label></td>
		     <td class="value"><input class="inputxt" id="oilNum" name="oilNum"  value="${tsVechicleFeePage.oilNum}"> <span class="Validform_checktip"></span></td>
			 
			</tr>
			
			<tr>
				<td align="right"><label class="Validform_label"> 维修明细:
				</label></td>
				<td class="value"><textarea name="serviceDetail" id="serviceDetail" style="width:300px;height:300px;">${tsVechicleFeePage.serviceDetail}</textarea></td>
		   </tr>
			
		</table>
	</t:formvalid>
</body>