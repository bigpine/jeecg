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
		
		var isTrue = $("#isTrue1").val();
		if(isTrue != ''){
			var isExist = false;
			var count = $("#isTrue").find("option").length;
			for(var i=0; i<count; i++){
				if($("#isTrue").get(0).options[i].value == isTrue){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#isTrue").append("<option value='${tsperformancePage.isTrue}'>${tsperformancePage.isTrue}</option>");
			}
			$("#isTrue").attr("value",'${tsperformancePage.isTrue}');
		}
		var isRecode = $("#isRecode1").val();
		if(isTrue != ''){
			var isExist = false;
			var count = $("#isRecode").find("option").length;
			for(var i=0; i<count; i++){
				if($("#isRecode").get(0).options[i].value == isRecode){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#isRecode").append("<option value='${tsperformancePage.isRecode}'>${tsperformancePage.isRecode}</option>");
			}
			$("#isRecode").attr("value",'${tsperformancePage.isRecode}');
		}
		var departName = $("#departName1").val();
		if(departName != ''){
			var isExist = false;
			var count = $("#departName").find("option").length;
			for(var i=0; i<count; i++){
				if($("#departName").get(0).options[i].value == departName){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#departName").append("<option value='${tsperformancePage.departName}'>${tsperformancePage.departName}</option>");
			}
			$("#departName").attr("value",'${tsperformancePage.departName}');
		} else {
			var id = $("#departName").val();
			getUserList(id);
		}
		
		var perforName = $("#perforName1").val();
		if(perforName != ''){
			var isExist = false;
			var count = $("#perforName").find("option").length;
			for(var i=0; i<count; i++){
				if($("#perforName").get(0).options[i].value == perforName){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				$("#perforName").append("<option value='${tsperformancePage.perforName}'>${tsperformancePage.perforName}</option>");
			}
			$("#perforName").attr("value",'${tsperformancePage.perforName}');
		} else {
			var id = $("#perforName").val();
			getUserList(id);
		}
		
		
	});
		
	
	
	function getUserList(id) {
		if(id==''){
			$('#realName').html("");
			return;
		}
		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getUserList&departName=" + encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#realName').html(d.msg);
					var id = $("#realName").val();
					getPositionList(id);
				}
			}
		});
	}
	//获取员工职责
	function getPositionList(id) {
		if(id==''){
			$('#position').html("");
			return;
		}
		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getPositionList&departName="+encodeURIComponent(encodeURIComponent($('#departName').val()))+"&realName="+encodeURIComponent(encodeURIComponent($('#realName').val()))+"&position=" + encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#position').html(d.msg);
					var id = $("#position").val();
					getEmailList(id);

				}
			}
		});
	} 
	//获取员工职责
	function getEmailList(id) {
		if(id==''){
			$('#email').html("");
			return;
		}
		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getEmailList&departName="+encodeURIComponent(encodeURIComponent($('#departName').val()))+"&realName="+encodeURIComponent(encodeURIComponent($('#realName').val()))+"&position="+encodeURIComponent(encodeURIComponent($('#position').val()))+"&email=" + encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#email').html(d.msg);

				}
			}
		});
	}
 	
	function getPerforTypeList(id) {
		if(id==''){
			$('#perforType').html("");
			return;
		}

		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getPerforTypeList&perforName="+ encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#perforType').html(d.msg);
					var id = $("#perforType").val();
					getPerforDetailList(id);

				}
			}
		});
	} 
	 
	
	
	function getPerforDetailList(id) {
		if(id==''){
			$('#perforDetail').html("");
			return;
		}

		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getPerforDetailList&perforName="+encodeURIComponent(encodeURIComponent($('#perforName').val()))+"&perforType="+encodeURIComponent(encodeURIComponent($('#perforType').val()))+"&perforDetail=" + encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#perforDetail').html(d.msg);
					var id = $("#perforDetail").val();
					getScoreList(id);

				}
			}
		});
	} 
	
	 function getScoreList(id) {
		if(id==''){
			$('#score').html("");
			return;
		}

		window.top.$.messager.progress({
			text : '正在加载数据....',
			interval : 300
		});
		var url = "tsperformanceController.do?getScoreList&perforName="+encodeURIComponent(encodeURIComponent($('#perforName').val()))+"&perforType="+encodeURIComponent(encodeURIComponent($('#perforType').val()))+"&perforDetail="+encodeURIComponent(encodeURIComponent($('#perforDetail').val()))+"&score=" + encodeURIComponent(encodeURIComponent(id));
		$.ajax({
			type : 'POST',
			url : url,
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					window.top.$.messager.progress('close');
					$('#score').html(d.msg);

				}
			}
		});
	}
 
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
		layout="table" action="tsperformanceController.do?save">
		<input id="id" name="id" type="hidden" value="${tsperformancePage.id }">
		<input id="departName1" name="departName1" type="hidden" value="${tsperformancePage.departName}">
		<input id="perforName1" name="perforName1" type="hidden" value="${tsperformancePage.perforName}">
        <input id="isTrue1" name="isTrue1" type="hidden" value="${tsperformancePage.isTrue}">
        <input id="isRecode1" name="isRecode1" type="hidden" value="${tsperformancePage.isRecode}">
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
			
	        <td align="right"><label class="Validform_label">所属部门:</label></td>
			
	         <td class="value">
       		 <select id="departName" name="departName" onchange="getUserList(this.value)"  >
				<c:forEach items="${departNameList}" var="departName">
					<option value="${departName }" <c:if test="${departName==tsperformancePage.departName}">selected="selected"</c:if>>${departName}</option>
				</c:forEach>
			</select>
            </td>
				<td align="right"><label class="Validform_label">员工姓名: </label></td>
		         <td class="value">
		       		 <select id="realName" name="realName"  onchange="getPositionList(this.value)">
						<option value=${tsperformancePage.realName}>${tsperformancePage.realName}</option>    
					</select>
				</td>
		</tr>
		<tr>
			
	        <td align="right"><label class="Validform_label">职责:</label></td>
			
	         
       		 <td class="value">
		       		 <select id="position" name="position" onchange="getEmailList(this.value)">
						<option value=${tsperformancePage.position}>${tsperformancePage.position}</option>    
					</select>
				</td>
				<td align="right"><label class="Validform_label">邮箱: </label></td>
		         <td class="value">
		       		 <select id="email" name="email" >
						<option value=${tsperformancePage.email}>${tsperformancePage.email}</option>    
					</select>
				</td>
		</tr>
		
		
		 	<tr>
			
	        <td align="right"><label class="Validform_label">绩效名称:</label></td>
			
	         <td class="value">
       		 <select id="perforName" name="perforName" onchange="getPerforTypeList(this.value)" datatype="*" >
				<c:forEach items="${performanceNameList}" var="perforName">
					<option value="${perforName}" <c:if test="${perforName==tsperformancePage.perforName}">selected="selected"</c:if>>${perforName}</option>
				</c:forEach>
			</select>
            </td>
				<td align="right"><label class="Validform_label">绩效类别: </label></td>
		         <td class="value">
		       		 <select id="perforType" name="perforType" onchange="getPerforDetailList(this.value)" datatype="*">
						<option value=${tsperformancePage.perforType}>${tsperformancePage.perforType}</option>    
					</select>
				</td>
		</tr>
		<tr>
             <td align="right"><label class="Validform_label">绩效明细: </label></td>
		     <td class="value">
		     	<select id="perforDetail" name="perforDetail" onchange="getScoreList(this.value)"  datatype="*">
					<option value=${tsperformancePage.perforDetail}>${tsperformancePage.perforDetail}</option>    
		     	</select>
		     </td>
		     
			 <td align="right"><label class="Validform_label"> 分值: </label></td>
		     <td class="value">
		     	<select id="score" name="score"  datatype="*">
             		<option value=${tsperformancePage.score}>${tsperformancePage.score}</option>    
		     	</select>
		     </td>

			</tr>
		<tr>
             
		     <td align="right"><label class="Validform_label"> 发生日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="markDate" name="markDate" ignore="ignore"
				value="<fmt:formatDate value='${tsperformancePage.markDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>

		       
		     <td align="right"><label class="Validform_label"> 是否外部投诉: </label></td>
		      
		    <td class="value">
	        <select  id="isTrue" name="isTrue" >
             <option value="否">否</option>    
             <option value="是">是</option> 			 
            </select> 
	        
	        </td>
			
			</tr>
			
			<tr>
			 <td align="right"><label class="Validform_label"> 描述: </label></td>
		
		    <td class="value"><textarea name="performanceDesc" id="performanceDesc" style="width:200px;height:50px;">${tsperformancePage.performanceDesc}</textarea></td>
			
			
			 <td align="right"><label class="Validform_label"> 是否记过: </label></td>
		      
		    <td class="value">
	        <select  id="isRecode" name="isRecode" >
             <option value="否">否</option>    
             <option value="是">是</option> 			 
            </select> 
	        
	        </td>
			</tr>
			
		</table>
	</t:formvalid>
</body>