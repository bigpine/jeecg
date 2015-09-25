<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>员工绩效管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function() {
		//查看模式情况下,删除和上传附件功能禁止使用
		if (location.href.indexOf("load=detail") != -1) {
			$(".jeecgDetail").hide();
		}
	});	

	function close() {
		frameElement.api.close();
	}
	
	function getPerforTypeList(id) {
		if(id==''){
			$('#itemDetail').html("");
			return;
		}
		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getPerforTypeList&performanceName=" + encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#perforType').html(d.msg);
					var id = $("#perforType").val();
					//getPerforDetailList(id);

				}
			}
		});
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
		layout="table" action="tsperformanceController.do?save">
		<input id="id" name="id" type="hidden" value="${tsperformancePage.id }">
		<input id="createName" name="createUser" type="hidden"
			value="${tsperformancePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsperformancePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsperformancePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsperformancePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsperformancePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsperformancePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
		
        
		<tr>     
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="所属部门: "/></label></td>
			<td class="value" nowrap>
                <input  name="departid" type="hidden" value="${id}" id="departid">
                <input name="departname" class="departname" value="${tsperformancePage.depart.departname }" id="departname" readonly="readonly" datatype="*" />
                <t:choose hiddenName="departid" hiddenid="id" url="tsperformanceController.do?departs" name="departList"
                          icon="icon-search" title="部门名称" textname="departname" isclear="true" isInit="true"></t:choose>
                <%-- <span class="Validform_checktip"><t:mutiLang langKey="选择绩效类型"/></span> --%>
            </td>
             
			<td align="right"><label class="Validform_label"> 发生日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="markDate" name="markDate" ignore="ignore" datatype="*"
				value="<fmt:formatDate value='${tsperformancePage.markDate}' type="date" pattern="yyyy-MM-dd"/>" > <span class="Validform_checktip"></span></td>
             
             
			</tr>
		
		<tr>
			 	 	
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="员工: "/></label></td>
			<td class="value" nowrap>
                <input name="userid" type="hidden" value="${id}" id="userid">
                <input name="realName" class="realName" value="${tsperformancePage.user.realName }" id="realName" readonly="readonly" datatype="*" />
                <t:choose hiddenName="userid" hiddenid="id" url="tsperformanceController.do?users" name="userList"
                          icon="icon-search" title="员工姓名" textname="realName" isclear="true" isInit="true"></t:choose>
                <%-- <span class="Validform_checktip"><t:mutiLang langKey="选择绩效类型"/></span> --%>
            </td>
			
				</tr>
		
		<tr>
		
		<tr>			
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="绩效名称: "/></label></td>
			<td class="value" nowrap>
                <input name="baseid" name="baseid" type="hidden" value="${id}" id="baseid">
                <input name="perforName" class="perforName" value="${tsperformancePage.performanceBaseEntity.perforName }" id="perforName" readonly="readonly" datatype="*" />
                <t:choose hiddenName="baseid" hiddenid="id" url="tsperformanceController.do?performanceBases" name="performanceBaseList"
                          icon="icon-search" title="绩效名称" textname="perforName" isclear="true" isInit="true"></t:choose>
                <%-- <span class="Validform_checktip"><t:mutiLang langKey="选择绩效类型"/></span> --%>
            </td>
            
		 <%-- <td align="right"><label class="Validform_label"> 绩效类别: </label></td>
		 <td class="value"><input class="inputxt" id="performanceDetail" name="performanceDetail"  value="${tsperformancePage.performanceBaseEntity.perforType}"> <span class="Validform_checktip"></span></td>
             --%>
		</tr>
		
<%-- 		<tr>
			<td align="right"><label class="Validform_label"> 绩效名称: </label></td>
		    <td class="value">
		    <input class="inputxt" id="performanceName" name="performanceName"  value="${tsperformancePage.performanceName}"> 
		    <span class="Validform_checktip"></span>
		      
       		 <select id="performanceName" name="performanceName" onchange="getPerforTypeList(this.value)" datatype="*" >
				<c:forEach items="${performanceNameList}" var="performanceName">
					<option value="${performanceName }" <c:if test="${performanceName==tsperformancePage.performanceName}">selected="selected"</c:if>>${performanceName}</option>
				</c:forEach>
			</select>
            
		    </td>
		</tr> --%>
			 	
		<%--  <td align="right"><label class="Validform_label"> 绩效明细: </label></td>
		 <td class="value"><input class="inputxt" id="performanceDetail" name="performanceDetail"  value="${tsperformancePage.performanceBaseEntity.perforDetail}"> <span class="Validform_checktip"></span></td>
		
			 <td align="right"><label class="Validform_label">分值: </label></td>
		     <td class="value"><input class="inputxt" id="score" name="score"  value="${tsperformancePage.performanceBaseEntity.score}"> <span class="Validform_checktip"></span></td>
			 --%>
			 
			  <td align="right"><label class="Validform_label"> 绩效描述: </label></td>
		     <td class="value"><input class="inputxt" id="performanceDesc" name="performanceDesc"  value="${tsperformancePage.performanceDesc}" > <span class="Validform_checktip"></span></td>
			
			</tr>
			
			
		</table>
	</t:formvalid>
</body>