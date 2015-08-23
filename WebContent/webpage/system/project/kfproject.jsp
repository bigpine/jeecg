<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>客服项目管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });

  	function uploadFile(data){
  		$("#kfprojectId").val(data.obj.id);
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			frameElement.api.opener.reloadTable();
  			frameElement.api.close();
  		}
  	}
  	
  	function close(){
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
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="@Override uploadFile" action="tskfprojectController.do?save">
	<input id="id" name="id" type="hidden" value="${tsKfprojectPage.id }">
	
    <input id="createName" name="createUser" type="hidden" value="${tsKfprojectPage.createName}">
    <input id="createDate" name="createTime" type="hidden" value="${tsKfprojectPage.createDate}">
    <input id="updateName" name="updateUser" type="hidden" value="${tsKfprojectPage.updateName}">
    <input id="updateDate" name="createUser" type="hidden" value="${tsKfprojectPage.updateDate}">
    <input id="updateBy" name="updateBy" type="hidden" value="${tsKfprojectPage.updateBy}">
    <input id="createBy" name="createBy" type="hidden" value="${tsKfprojectPage.createBy}">
	<table cellpadding="0" cellspacing="1" class="formtable">
	   <tr>
			<td align="right"><label class="Validform_label">公司: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">售达方: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label"> 售达方抬头: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectManager" name="kfprojectManager"  value="${tsKfprojectPage.kfprojectManager}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">送达方: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label">送达方抬头: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectManager" name="kfprojectManager"  value="${tsKfprojectPage.kfprojectManager}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">发货单要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label">发货单备注信息: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectManager" name="kfprojectManager"  value="${tsKfprojectPage.kfprojectManager}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">发票要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label">发票信息要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectManager" name="kfprojectManager"  value="${tsKfprojectPage.kfprojectManager}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">发货要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label">回单要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectManager" name="kfprojectManager"  value="${tsKfprojectPage.kfprojectManager}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label">装箱要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectName" name="kfprojectName"  value="${tsKfprojectPage.kfprojectName}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label">客户其他要求: </label></td>
			<td class="value"><input class="inputxt" id="kfprojectManager" name="kfprojectManager"  value="${tsKfprojectPage.kfprojectManager}"> <span class="Validform_checktip"></span></td>
		</tr>
 		<%-- <tr>
			<td align="right"><label class="Validform_label"> 项目开始日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="kfprojectStartDate" name="kfprojectStartDate" ignore="ignore"
				value="<fmt:formatDate value='${tsKfprojectPage.kfprojectStartDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label"> 项目结束日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="kfprojectEndDate" name="kfprojectEndDate" ignore="ignore"
				value="<fmt:formatDate value='${tsKfprojectPage.kfprojectEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
			
		</tr> --%>
	
	  <%--   <tr>
	    <td align="right"><label class="Validform_label"> 项目状态:</label></td>
				
	    <td>
	       <t:dictSelect field="kfprojectStatus" typeGroupCode="pro_status" defaultVal="${tsKfprojectPage.kfprojectStatus}" hasLabel="false"></t:dictSelect>
	    </td>
	
	    <td align="right"><label class="Validform_label"> 客户联系人: </label></td>
			<td class="value"><input class="inputxt" id="contactUser" name="contactUser"  value="${tsKfprojectPage.contactUser}"> <span class="Validform_checktip"></span></td>
		
	    </tr> --%>
	    	
	 <%--     <tr>
	        <td align="right"><label class="Validform_label"> 入库要求: </label></td>
			<td class="value"><input class="inputxt" id="rkRequire" name="rkRequire"  value="${tsKfprojectPage.rkRequire}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label"> 出库要求: </label></td>
			<td class="value"><input class="inputxt" id="ckRequire" name="ckRequire"  value="${tsKfprojectPage.ckRequire}"> <span class="Validform_checktip"></span></td>
		
	    </tr>
	    <tr>
	        <td align="right"><label class="Validform_label"> 装箱要求: </label></td>
			<td class="value"><input class="inputxt" id="zxRequire" name="zxRequire"  value="${tsKfprojectPage.zxRequire}"> <span class="Validform_checktip"></span></td>
		
			<td align="right"><label class="Validform_label"> 开票要求: </label></td>
			<td class="value"><input class="inputxt" id="kpRequire" name="kpRequire"  value="${tsKfprojectPage.kpRequire}"> <span class="Validform_checktip"></span></td>
		
	    </tr> --%>
	  <!--   附件信息---内容---- -->
	 <%--   <tr>
			<td align="right"><label class="Validform_label">附件:</label></td>
			<td colspan="3" class="value"><input type="hidden" value="${tsKfprojectPage.id}" id="kfprojectId" name="kfprojectId" />
			<table>
				<c:forEach items="${tsKfprojectPage.kfprojectFiles}" var="kfprojectFiles">
					<tr style="height: 34px;">
						<td>${kfprojectFiles.attachmenttitle}</td>                                       
						<td><a href="commonController.do?viewFile&fileid=${kfprojectFiles.id}&subclassname=org.jeecgframework.web.system.pojo.base.TSKfprojectFilesEntity" title="下载">下载</a></td>
						
						
						<td><a href="javascript:void(0)" class="jeecgDetail" onclick="del('tskfprojectController.do?delFile&id=${kfprojectFiles.id}',this)">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
		 --%>
        <tr>
			<td></td>
			<td colspan="3" class="value"><script type="text/javascript">
					$.dialog.setting.zIndex =1990;
					function del(url,obj){
						$.dialog.confirm("确认删除该条记录?", function(){
						  	$.ajax({
								async : false,
								cache : false,
								type : 'POST',
								url : url,// 请求的action路径
								error : function() {// 请求失败处理函数
								},
								success : function(data) {
									var d = $.parseJSON(data);
									if (d.success) {
										var msg = d.msg;
										tip(msg);
										$(obj).closest("tr").hide("slow");
									}
								}
							});  
						}, function(){
						});
					}
					</script>
			<%-- <div class="form" id="filediv"></div>
			<div class="form jeecgDetail">
			<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formId="formobj" uploader="tskfprojectController.do?saveFiles">
			</t:upload>
				</div> --%>
			</td>
		</tr>
	    <tr>
				<td align="right"><label class="Validform_label"> 备注信息:
				</label></td>
				<td colspan="3" class="value"><textarea name="kfprojectDesc" id="kfprojectDesc" style="width:800px;height:150px;">${tsKfprojectPage.kfprojectDesc}</textarea></td>
		</tr>
	</table>
</t:formvalid>
</body>