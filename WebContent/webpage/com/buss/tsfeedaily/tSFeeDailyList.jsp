<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTSFeeDailyBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTSFeeDailyBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTSFeeDailyBtn').bind('click', function(){   
 		 var tr =  $("#add_tSFeeDaily_table_template tr").clone();
	 	 $("#add_tSFeeDaily_table").append(tr);
	 	 resetTrNum('add_tSFeeDaily_table');
	 	 return false;
    });  
	$('#delTSFeeDailyBtn').bind('click', function(){   
      	$("#add_tSFeeDaily_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tSFeeDaily_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
		//将表格的表头固定
	    $("#tSFeeDaily_table").createhftable({
	    	height:'300px',
			width:'auto',
			fixFooter:false
			});
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTSFeeDailyBtn" href="#">添加</a> <a id="delTSFeeDailyBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="tSFeeDaily_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE">序号</td>
		<td align="center" bgcolor="#EEEEEE">操作</td>
				  <td align="left" bgcolor="#EEEEEE">
						费用名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						楼层
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						发生日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE">
						金额
				  </td>
	</tr>
	<tbody id="add_tSFeeDaily_table">	
	<c:if test="${fn:length(tSFeeDailyList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tSFeeDailyList[0].id" type="hidden"/>
					<input name="tSFeeDailyList[0].createName" type="hidden"/>
					<input name="tSFeeDailyList[0].createBy" type="hidden"/>
					<input name="tSFeeDailyList[0].createDate" type="hidden"/>
					<input name="tSFeeDailyList[0].updateName" type="hidden"/>
					<input name="tSFeeDailyList[0].updateBy" type="hidden"/>
					<input name="tSFeeDailyList[0].updateDate" type="hidden"/>
					<input name="tSFeeDailyList[0].feeId" type="hidden"/>
				  <td align="left">
					  	<input name="tSFeeDailyList[0].feeName" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">费用名称</label>
					</td>
				  <td align="left">
					  	<input name="tSFeeDailyList[0].floor" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">楼层</label>
					</td>
				  <td align="left">
							<input name="tSFeeDailyList[0].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					               >  
					  <label class="Validform_label" style="display: none;">发生日期</label>
					</td>
				  <td align="left">
					  	<input name="tSFeeDailyList[0].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tSFeeDailyList)  > 0 }">
		<c:forEach items="${tSFeeDailyList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tSFeeDailyList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tSFeeDailyList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
					<input name="tSFeeDailyList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
					<input name="tSFeeDailyList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
					<input name="tSFeeDailyList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
					<input name="tSFeeDailyList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
					<input name="tSFeeDailyList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
					<input name="tSFeeDailyList[${stuts.index }].feeId" type="hidden" value="${poVal.feeId }"/>
				   <td align="left">
					  	<input name="tSFeeDailyList[${stuts.index }].feeName" maxlength="255" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.feeName }">
					  <label class="Validform_label" style="display: none;">费用名称</label>
				   </td>
				   <td align="left">
					  	<input name="tSFeeDailyList[${stuts.index }].floor" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.floor }">
					  <label class="Validform_label" style="display: none;">楼层</label>
				   </td>
				   <td align="left">
							<input name="tSFeeDailyList[${stuts.index }].markDate" maxlength="20" 
					  		type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"
					                
					                value="<fmt:formatDate value='${poVal.markDate}' type="date" pattern="yyyy-MM-dd"/>">  
					  <label class="Validform_label" style="display: none;">发生日期</label>
				   </td>
				   <td align="left">
					  	<input name="tSFeeDailyList[${stuts.index }].amout" maxlength="10" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.amout }">
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
