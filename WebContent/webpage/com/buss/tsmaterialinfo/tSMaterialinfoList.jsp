<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTSMaterialinfoBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTSMaterialinfoBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTSMaterialinfoBtn').bind('click', function(){   
 		 var tr =  $("#add_tSMaterialinfo_table_template tr").clone();
	 	 $("#add_tSMaterialinfo_table").append(tr);
	 	 resetTrNum('add_tSMaterialinfo_table');
	 	 return false;
    });  
	$('#delTSMaterialinfoBtn').bind('click', function(){   
      	$("#add_tSMaterialinfo_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tSMaterialinfo_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#tSMaterialinfo_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTSMaterialinfoBtn" href="#">添加</a> <a id="delTSMaterialinfoBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tSMaterialinfo_table">
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
	<tbody id="add_tSMaterialinfo_table">	
	<c:if test="${fn:length(tSMaterialinfoList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tSMaterialinfoList[0].id" type="hidden"/>
					<input name="tSMaterialinfoList[0].createName" type="hidden"/>
					<input name="tSMaterialinfoList[0].createBy" type="hidden"/>
					<input name="tSMaterialinfoList[0].createDate" type="hidden"/>
					<input name="tSMaterialinfoList[0].updateName" type="hidden"/>
					<input name="tSMaterialinfoList[0].updateBy" type="hidden"/>
					<input name="tSMaterialinfoList[0].updateDate" type="hidden"/>
					<input name="tSMaterialinfoList[0].materialId" type="hidden"/>
				  <td align="left">
					  	<input name="tSMaterialinfoList[0].itemNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">数量</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialinfoList[0].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"   style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">发生日期</label>
					</td>
				  <td align="left">
					  	<input name="tSMaterialinfoList[0].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">总额</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tSMaterialinfoList)  > 0 }">
		<c:forEach items="${tSMaterialinfoList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tSMaterialinfoList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tSMaterialinfoList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="tSMaterialinfoList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="tSMaterialinfoList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="tSMaterialinfoList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="tSMaterialinfoList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="tSMaterialinfoList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
					<input name="tSMaterialinfoList[${stuts.index }].materialId" type="hidden" value="${poVal.materialId }"/>
				   <td align="left">
					  	<input name="tSMaterialinfoList[${stuts.index }].itemNum" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.itemNum }">
					  <label class="Validform_label" style="display: none;">数量</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialinfoList[${stuts.index }].markDate" maxlength="20" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.markDate }">
					  <label class="Validform_label" style="display: none;">发生日期</label>
				   </td>
				   <td align="left">
					  	<input name="tSMaterialinfoList[${stuts.index }].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amout }">
					  <label class="Validform_label" style="display: none;">总额</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
