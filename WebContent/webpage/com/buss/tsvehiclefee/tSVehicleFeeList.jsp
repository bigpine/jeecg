<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTSVehicleFeeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTSVehicleFeeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTSVehicleFeeBtn').bind('click', function(){   
 		 var tr =  $("#add_tSVehicleFee_table_template tr").clone();
	 	 $("#add_tSVehicleFee_table").append(tr);
	 	 resetTrNum('add_tSVehicleFee_table');
	 	 return false;
    });  
	$('#delTSVehicleFeeBtn').bind('click', function(){   
      	$("#add_tSVehicleFee_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tSVehicleFee_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#tSVehicleFee_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTSVehicleFeeBtn" href="#">添加</a> <a id="delTSVehicleFeeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tSVehicleFee_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">
						发车日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						车牌
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						驾驶员
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						当天行驶公里
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						下班公里
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						园区停车
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						油费
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						油耗
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						停车费
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						通行费
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						维修费
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						洗车费
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						ETC费用
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						出车里程
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						回程里程
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						加油里程数
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						加油公升数
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						维修明细
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						费用基础ID
				  </td>
	</tr>
	<tbody id="add_tSVehicleFee_table">	
	<c:if test="${fn:length(tSVehicleFeeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tSVehicleFeeList[0].id" type="hidden"/>
					<input name="tSVehicleFeeList[0].createName" type="hidden"/>
					<input name="tSVehicleFeeList[0].createBy" type="hidden"/>
					<input name="tSVehicleFeeList[0].createDate" type="hidden"/>
					<input name="tSVehicleFeeList[0].updateName" type="hidden"/>
					<input name="tSVehicleFeeList[0].updateBy" type="hidden"/>
					<input name="tSVehicleFeeList[0].updateDate" type="hidden"/>
				  <td align="left">
							<input name="tSVehicleFeeList[0].sendDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发车日期</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].carCode" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">车牌</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].driver" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">驾驶员</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].dayKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">当天行驶公里</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].outKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">下班公里</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].parkFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">园区停车</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].oilFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">油费</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].oilMouse" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">油耗</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].stopFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">停车费</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].pikeFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">通行费</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].serviceFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">维修费</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].washFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">洗车费</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].etcFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">ETC费用</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].startKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">出车里程</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].endKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">回程里程</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].addOilKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">加油里程数</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].oilNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">加油公升数</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].serviceDetail" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">维修明细</label>
					</td>
				  <td align="left">
					  	<input name="tSVehicleFeeList[0].feeId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用基础ID</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tSVehicleFeeList)  > 0 }">
		<c:forEach items="${tSVehicleFeeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tSVehicleFeeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tSVehicleFeeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="tSVehicleFeeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="tSVehicleFeeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="tSVehicleFeeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="tSVehicleFeeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="tSVehicleFeeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
				   <td align="left">
							<input name="tSVehicleFeeList[${stuts.index }].sendDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.sendDate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">发车日期</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].carCode" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.carCode }">
					  <label class="Validform_label" style="display: none;">车牌</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].driver" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.driver }">
					  <label class="Validform_label" style="display: none;">驾驶员</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].dayKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.dayKm }">
					  <label class="Validform_label" style="display: none;">当天行驶公里</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].outKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.outKm }">
					  <label class="Validform_label" style="display: none;">下班公里</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].parkFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.parkFee }">
					  <label class="Validform_label" style="display: none;">园区停车</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].oilFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.oilFee }">
					  <label class="Validform_label" style="display: none;">油费</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].oilMouse" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.oilMouse }">
					  <label class="Validform_label" style="display: none;">油耗</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].stopFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.stopFee }">
					  <label class="Validform_label" style="display: none;">停车费</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].pikeFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.pikeFee }">
					  <label class="Validform_label" style="display: none;">通行费</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].serviceFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.serviceFee }">
					  <label class="Validform_label" style="display: none;">维修费</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].washFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.washFee }">
					  <label class="Validform_label" style="display: none;">洗车费</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].etcFee" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.etcFee }">
					  <label class="Validform_label" style="display: none;">ETC费用</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].startKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.startKm }">
					  <label class="Validform_label" style="display: none;">出车里程</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].endKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.endKm }">
					  <label class="Validform_label" style="display: none;">回程里程</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].addOilKm" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.addOilKm }">
					  <label class="Validform_label" style="display: none;">加油里程数</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].oilNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.oilNum }">
					  <label class="Validform_label" style="display: none;">加油公升数</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].serviceDetail" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.serviceDetail }">
					  <label class="Validform_label" style="display: none;">维修明细</label>
				   </td>
				   <td align="left">
					  	<input name="tSVehicleFeeList[${stuts.index }].feeId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.feeId }">
					  <label class="Validform_label" style="display: none;">费用基础ID</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
