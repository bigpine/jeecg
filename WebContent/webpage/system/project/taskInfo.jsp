<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>任务管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });

  	/* function uploadFile(data){
  		$("#projectId").val(data.obj.id);
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			frameElement.api.opener.reloadTable();
  			frameElement.api.close();
  		}
  	}
  	 */
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
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tstaskInfoController.do?save">
	<input id="id" name="id" type="hidden" value="${tsTaskPage.id }">
	
    <input id="createName" name="createUser" type="hidden" value="${tsTaskPage.createName}">
    <input id="createDate" name="createTime" type="hidden" value="${tsTaskPage.createDate}">
    <input id="updateName" name="updateUser" type="hidden" value="${tsTaskPage.updateName}">
    <input id="updateDate" name="createUser" type="hidden" value="${tsTaskPage.updateDate}">
    <input id="updateBy" name="updateBy" type="hidden" value="${tsTaskPage.updateBy}">
    <input id="createBy" name="createBy" type="hidden" value="${tsTaskPage.createBy}">
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 任务名称: </label></td>
			<td class="value"><input class="inputxt" id="taskName" name="taskName"  value="${tsTaskPage.taskName}"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			
			<td align="right"><label class="Validform_label"> 任务负责人: </label></td>
			<td class="value"><input class="inputxt" id="taskManager" name="taskManager"  value="${tsTaskPage.taskManager}"> <span class="Validform_checktip"></span></td>
		
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 任务开始日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="taskStartDate" name="taskStartDate" ignore="ignore"
				value="<fmt:formatDate value='${tsTaskPage.taskStartDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 任务结束日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="taskEndDate" name="taskEndDate" ignore="ignore"
				value="<fmt:formatDate value='${tsTaskPage.taskEndDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
			
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> 计划完成日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="taskPlanDate" name="taskPlanDate" ignore="ignore"
				value="<fmt:formatDate value='${tsTaskPage.taskPlanDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>
			
		</tr>
		
		<tr>
	    <td align="right"><label class="Validform_label"> 任务类型:
				</label></td>
				
	<td>
	<t:dictSelect field="taskType" typeGroupCode="tasktype" defaultVal="${tsTaskPage.taskType}" hasLabel="false"></t:dictSelect>
	</td>
	 <!--    <td class="value"><select id="taskType"
					name="taskType">

						<option value="需求调研">需求调研</option>
						<option value="项目开发" selected="selected">项目开发</option>
						<option value="问题待澄清">问题待澄清</option>
						<option value="项目优化">项目优化</option>
						<option value="产品升级">产品升级</option>
				</select></td> -->
	    </tr>
	    <tr>
	    <td align="right"><label class="Validform_label"> 任务状态:
				</label></td>
				
				<td>
	<t:dictSelect field="taskStatus" typeGroupCode="taskstatus" defaultVal="${tsTaskPage.taskStatus}" hasLabel="false"></t:dictSelect>
			</td>
	 <!--    <td class="value"><select id="taskStatus"
					name="taskStatus">

						<option value="开发已完成">开发已完成</option>
						<option value="项目待开发" selected="selected">项目待开发</option>
						<option value="测试通过">测试通过</option>
						<option value="任务已取消">任务已取消</option>
						<option value="任务创建">任务创建</option>
				</select></td> -->
	    </tr>
	    <tr>
	    <td align="right"><label class="Validform_label"> 任务级别:
				</label></td>
	<td>
	<t:dictSelect field="taskLevel" typeGroupCode="tasklevel" defaultVal="${tsTaskPage.taskLevel}" hasLabel="false"></t:dictSelect>
	</td>
	    <!-- <td class="value"><select id="taskLevel"
					name="taskLevel">

						<option value="非常紧急">非常紧急</option>
						<option value="重要" selected="selected">重要</option>
						<option value="普通">普通</option>
						<option value="后期优化">后期优化</option>
				</select></td> -->
	    </tr>
	<%-- 	<tr>
			<td align="right"><label class="Validform_label">附件:</label></td>
			<td colspan="3" class="value"><input type="hidden" value="${tsTaskPage.id}" id="projectId" name="projectId" />
			<table>
				<c:forEach items="${tsTaskPage.projectFiles}" var="projectFiles">
					<tr style="height: 34px;">
						<td>${projectFiles.attachmenttitle}</td>
						<td><a href="commonController.do?viewFile&fileid=${projectFiles.id}&subclassname=org.jeecgframework.web.system.pojo.base.TSProjectFilesEntity" title="下载">下载</a></td>
						
						<td><a href="javascript:void(0);"
							onclick="openwindow('预览','commonController.do?openViewFile&fileid=${projectFiles.id}&subclassname=org.jeecgframework.web.system.pojo.base.TSProjectFilesEntity','fList','800','700')">预览</a></td>
						
						<td><a href="javascript:void(0)" class="jeecgDetail" onclick="del('tsprojectController.do?delFile&id=${projectFiles.id}',this)">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr> --%>
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
			<t:upload name="fiels" id="file_upload" extend="*.doc;*.docx;*.txt;*.ppt;*.xls;*.xlsx;*.html;*.htm;*.pdf;" buttonText="添加文件" formId="formobj" uploader="tsprojectController.do?saveFiles">
			</t:upload>
				</div> --%>
			</td>
		</tr>
		<tr>
				<td align="right"><label class="Validform_label"> 任务描述:
				</label></td>
				<td class="value"><textarea name="taskDesc" id="taskDesc" style="width:800px;height:300px;">${tsTaskPage.taskDesc}</textarea></td>
		</tr>
	</table>
</t:formvalid>
</body>