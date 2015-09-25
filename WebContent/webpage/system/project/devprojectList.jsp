<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="devprojectList" title="开发项目管理" actionUrl="tsdevprojectController.do?datagrid" fitColumns="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="项目名称" field="devprojectName" query="true"></t:dgCol>
	<t:dgCol title="项目负责人" field="devprojectManager"></t:dgCol>
	<t:dgCol title="项目开始日期" field="devprojectStartDate"  formatter="yyyy-MM-dd" query="true" ></t:dgCol>
	<t:dgCol title="项目结束日期" field="devprojectEndDate"  formatter="yyyy-MM-dd" query="true" ></t:dgCol>
	<t:dgCol title="计划完成日期" field="planCompleteDate"  formatter="yyyy-MM-dd" query="true" ></t:dgCol>
	<t:dgCol title="项目状态" field="devprojectStatus" query="true" dictionary ="pro_status"></t:dgCol>
	<t:dgCol title="项目描述" field="devprojectDesc" hidden="true"></t:dgCol>
	<t:dgCol title="反馈意见" field="feedback" hidden="true"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建时间" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsdevprojectController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsdevprojectController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsdevprojectController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsdevprojectController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="删除" icon="icon-delete" url="" funname="detail" width="100%" height="100%"></t:dgToolBar>

</t:datagrid>
</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	//给时间控件加上样式
	$("#devprojectListtb").find("input[name='devprojectStartDate']").attr("class", "Wdate").attr("style", "height:20px;width:90px;").click(function() {
		WdatePicker({
			dateFmt : 'yyyy-MM-dd'
		});
	});
	$("#devprojectListtb").find("input[name='devprojectEndDate']").attr("class", "Wdate").attr("style", "height:20px;width:90px;").click(function() {
		WdatePicker({
			dateFmt : 'yyyy-MM-dd'
		});
	});
});
 </script>