<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTSMaterialFeeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTSMaterialFeeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTSMaterialFeeBtn').bind('click', function(){   
 		 var tr =  $("#add_tSMaterialFee_table_template tr").clone();
	 	 $("#add_tSMaterialFee_table").append(tr);
	 	 resetTrNum('add_tSMaterialFee_table');
	 	 return false;
    });  
	$('#delTSMaterialFeeBtn').bind('click', function(){   
      	$("#add_tSMaterialFee_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tSMaterialFee_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#tSMaterialFee_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTSMaterialFeeBtn" href="#">添加</a> <a id="delTSMaterialFeeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tSMaterialFee_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">
						科目
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						明细
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						规格
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						发生日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						总额
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						供应商
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						费用基础ID
				  </td>
	</tr>
	<tbody id="add_tSMaterialFee_table">	
	<c:if test="${fn:length(tSMaterialFeeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tSMaterialFeeList[0].id" type="hidden"/>
					<input name="tSMaterialFeeList[0].createName" type="hidden"/>
					<input name="tSMaterialFeeList[0].createBy" type="hidden"/>
					<input name="tSMaterialFeeList[0].createDate" type="hidden"/>
					<input name="tSMaterialFeeList[0].updateName" type="hidden"/>
					<input name="tSMaterialFeeList[0].updateBy" type="hidden"/>
					<input name="tSMaterialFeeList[0].updateDate" type="hidden"/>
				  <td align="left">
							<t:dictSelect field="itemName" type="list"
										typeGroupCode="subject" defaultVal="${tSMaterialFeePage.itemName}" hasLabel="false"  title="科目"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">科目</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[0].itemDetail" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">明细</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[0].standard" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">规格</label>
					</td>
				  <td align="left">
							<input name="tSMaterialFeeList[0].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发生日期</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[0].price" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[0].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总额</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[0].supplier" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">供应商</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialFeeList[0].feeId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用基础ID</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tSMaterialFeeList)  > 0 }">
		<c:forEach items="${tSMaterialFeeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tSMaterialFeeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tSMaterialFeeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="tSMaterialFeeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="tSMaterialFeeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="tSMaterialFeeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="tSMaterialFeeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="tSMaterialFeeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
				   <td align="left">
							<t:dictSelect field="tSMaterialFeeList[${stuts.index }].itemName" type="list"
										typeGroupCode="subject" defaultVal="${poVal.itemName }" hasLabel="false"  title="科目"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">科目</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialFeeList[${stuts.index }].itemDetail" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.itemDetail }">
					  <label class="Validform_label" style="display: none;">明细</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialFeeList[${stuts.index }].standard" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.standard }">
					  <label class="Validform_label" style="display: none;">规格</label>
				   </td>
				   <td align="left">
							<input name="tSMaterialFeeList[${stuts.index }].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.markDate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">发生日期</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialFeeList[${stuts.index }].price" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.price }">
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialFeeList[${stuts.index }].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amout }">
					  <label class="Validform_label" style="display: none;">总额</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialFeeList[${stuts.index }].supplier" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.supplier }">
					  <label class="Validform_label" style="display: none;">供应商</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialFeeList[${stuts.index }].feeId" maxlength="36" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.feeId }">
					  <label class="Validform_label" style="display: none;">费用基础ID</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
