<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>公共项目管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });

  	function uploadFile(data){
  		$("#projectId").val(data.obj.id);
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
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="@Override uploadFile" action="tsprojectController.do?save">
	<input id="id" name="id" type="hidden" value="${tsProjectPage.id }">
	
    <input id="createName" name="createUser" type="hidden" value="${tsProjectPage.createName}">
    <input id="createDate" name="createTime" type="hidden" value="${tsProjectPage.createDate}">
    <input id="updateName" name="updateUser" type="hidden" value="${tsProjectPage.updateName}">
    <input id="updateDate" name="createUser" type="hidden" value="${tsProjectPage.updateDate}">
    <input id="updateBy" name="updateBy" type="hidden" value="${tsProjectPage.updateBy}">
    <input id="createBy" name="createBy" type="hidden" value="${tsProjectPage.createBy}">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 项目名称: </label></td>
			<td class="value"><input class="inputxt" id="projectName" name="projectName"  value="${tsProjectPage.projectName}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 项目负责人: </label></td>
			<td class="value"><input class="inputxt" id="projectManager" name="projectManager"  value="${tsProjectPage.projectManager}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 项目开始日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="projectStartDate" name="projectStartDate" ignore="ignore"
				value="<fmt:formatDate value='${tsProjectPage.projectStartDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 项目结束日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="projectEndDate" name="projectEndDate" ignore="ignore"
				value="<fmt:formatDate value='${tsProjectPage.projectEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
			
		</tr>
	    <tr>
	    <td align="right"><label class="Validform_label"> 项目状态:
				</label></td>
				<td>
	<t:dictSelect field="projectStatus" typeGroupCode="pro_status" defaultVal="${tsProjectPage.projectStatus}" hasLabel="false"></t:dictSelect>
			</td>			
	    </tr>
		<tr>
			<td align="right"><label class="Validform_label">附件:</label></td>
			<td colspan="3" class="value"><input type="hidden" value="${tsProjectPage.id}" id="projectId" name="projectId" />
			<table>
				<c:forEach items="${tsProjectPage.projectFiles}" var="projectFiles">
					<tr style="height: 34px;">
						<td>${projectFiles.attachmenttitle}</td>
						<td><a href="commonController.do?viewFile&fileid=${projectFiles.id}&subclassname=org.jeecgframework.web.system.pojo.base.TSProjectFilesEntity" title="下载">下载</a></td>
						<td><a href="javascript:void(0)" class="jeecgDetail" onclick="del('tsprojectController.do?delFile&id=${projectFiles.id}',this)">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
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
			<div class="form" id="filediv"></div>
			<div class="form jeecgDetail">
			<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formId="formobj" uploader="tsprojectController.do?saveFiles">
			</t:upload>
				</div>
			</td>
		</tr>
		<tr>
				<td align="right"><label class="Validform_label"> 项目描述:
				</label></td>
				<td class="value"><textarea name="projectDesc" id="projectDesc" style="width:800px;height:300px;">${tsProjectPage.projectDesc}</textarea></td>
		</tr>
	</table>
</t:formvalid>
</body>