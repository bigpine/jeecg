<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCrmConsumableManBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCrmConsumableManBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCrmConsumableManBtn').bind('click', function(){   
 		 var tr =  $("#add_crmConsumableMan_table_template tr").clone();
	 	 $("#add_crmConsumableMan_table").append(tr);
	 	 resetTrNum('add_crmConsumableMan_table');
	 	 return false;
    });  
	$('#delCrmConsumableManBtn').bind('click', function(){   
      	$("#add_crmConsumableMan_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_crmConsumableMan_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#crmConsumableMan_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addCrmConsumableManBtn" href="#">添加</a> <a id="delCrmConsumableManBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="crmConsumableMan_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">
						数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						发生日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						总额
				  </td>
	</tr>
	<tbody id="add_crmConsumableMan_table">	
	<c:if test="${fn:length(crmConsumableManList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="crmConsumableManList[0].id" type="hidden"/>
					<input name="crmConsumableManList[0].createName" type="hidden"/>
					<input name="crmConsumableManList[0].createBy" type="hidden"/>
					<input name="crmConsumableManList[0].createDate" type="hidden"/>
					<input name="crmConsumableManList[0].updateName" type="hidden"/>
					<input name="crmConsumableManList[0].updateBy" type="hidden"/>
					<input name="crmConsumableManList[0].updateDate" type="hidden"/>
					<input name="crmConsumableManList[0].consumId" type="hidden"/>
				  <td align="left">
					  	<input name="crmConsumableManList[0].itemNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
							<input name="crmConsumableManList[0].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发生日期</label>
					</td>
				  <td align="left">
					  	<input name="crmConsumableManList[0].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总额</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(crmConsumableManList)  > 0 }">
		<c:forEach items="${crmConsumableManList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="crmConsumableManList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="crmConsumableManList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="crmConsumableManList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="crmConsumableManList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="crmConsumableManList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="crmConsumableManList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="crmConsumableManList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
					<input name="crmConsumableManList[${stuts.index }].consumId" type="hidden" value="${poVal.consumId }"/>
				   <td align="left">
					  	<input name="crmConsumableManList[${stuts.index }].itemNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.itemNum }">
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
							<input name="crmConsumableManList[${stuts.index }].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.markDate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">发生日期</label>
				   </td>
				   <td align="left">
					  	<input name="crmConsumableManList[${stuts.index }].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amout }">
					  <label class="Validform_label" style="display: none;">总额</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
