<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTSCarriageFeeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTSCarriageFeeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTSCarriageFeeBtn').bind('click', function(){   
 		 var tr =  $("#add_tSCarriageFee_table_template tr").clone();
	 	 $("#add_tSCarriageFee_table").append(tr);
	 	 resetTrNum('add_tSCarriageFee_table');
	 	 return false;
    });  
	$('#delTSCarriageFeeBtn').bind('click', function(){   
      	$("#add_tSCarriageFee_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tSCarriageFee_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#tSCarriageFee_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTSCarriageFeeBtn" href="#">添加</a> <a id="delTSCarriageFeeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tSCarriageFee_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">
						承运商
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						起始地
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						目的地
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						要求温度
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						到货温度
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						体积
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						重量
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						车型
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						结算方式
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						发车次数
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						仪器型号
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						发车日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						备注
				  </td>
	</tr>
	<tbody id="add_tSCarriageFee_table">	
	<c:if test="${fn:length(tSCarriageFeeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tSCarriageFeeList[0].id" type="hidden"/>
					<input name="tSCarriageFeeList[0].createName" type="hidden"/>
					<input name="tSCarriageFeeList[0].createBy" type="hidden"/>
					<input name="tSCarriageFeeList[0].createDate" type="hidden"/>
					<input name="tSCarriageFeeList[0].updateName" type="hidden"/>
					<input name="tSCarriageFeeList[0].updateBy" type="hidden"/>
					<input name="tSCarriageFeeList[0].updateDate" type="hidden"/>
					<input name="tSCarriageFeeList[0].feeId" type="hidden"/>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].carrier" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">承运商</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].origin" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">起始地</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].destination" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">目的地</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].reqTemp" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">要求温度</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].arrTemp" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">到货温度</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].volume" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">体积</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].weight" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">重量</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].model" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">车型</label>
					</td>
				  <td align="left">
							<t:dictSelect field="payType" type="list"
										typeGroupCode="pay_type" defaultVal="${tSCarriageFeePage.payType}" hasLabel="false"  title="结算方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">结算方式</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].price" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].sendNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发车次数</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].instrument" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">仪器型号</label>
					</td>
				  <td align="left">
							<input name="tSCarriageFeeList[0].sendDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发车日期</label>
					</td>
				  <td align="left">
					  	<input name="tSCarriageFeeList[0].carriageDesc" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tSCarriageFeeList)  > 0 }">
		<c:forEach items="${tSCarriageFeeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tSCarriageFeeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tSCarriageFeeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="tSCarriageFeeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="tSCarriageFeeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="tSCarriageFeeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="tSCarriageFeeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="tSCarriageFeeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
					<input name="tSCarriageFeeList[${stuts.index }].feeId" type="hidden" value="${poVal.feeId }"/>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].carrier" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.carrier }">
					  <label class="Validform_label" style="display: none;">承运商</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].origin" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.origin }">
					  <label class="Validform_label" style="display: none;">起始地</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].destination" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.destination }">
					  <label class="Validform_label" style="display: none;">目的地</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].reqTemp" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.reqTemp }">
					  <label class="Validform_label" style="display: none;">要求温度</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].arrTemp" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.arrTemp }">
					  <label class="Validform_label" style="display: none;">到货温度</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].volume" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.volume }">
					  <label class="Validform_label" style="display: none;">体积</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].weight" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.weight }">
					  <label class="Validform_label" style="display: none;">重量</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].model" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.model }">
					  <label class="Validform_label" style="display: none;">车型</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="tSCarriageFeeList[${stuts.index }].payType" type="list"
										typeGroupCode="pay_type" defaultVal="${poVal.payType }" hasLabel="false"  title="结算方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">结算方式</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].price" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.price }">
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].sendNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.sendNum }">
					  <label class="Validform_label" style="display: none;">发车次数</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amout }">
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].instrument" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.instrument }">
					  <label class="Validform_label" style="display: none;">仪器型号</label>
				   </td>
				   <td align="left">
							<input name="tSCarriageFeeList[${stuts.index }].sendDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.sendDate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">发车日期</label>
				   </td>
				   <td align="left">
					  	<input name="tSCarriageFeeList[${stuts.index }].carriageDesc" maxlength="500" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.carriageDesc }">
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
