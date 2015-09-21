<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="taskInfoList" title="任务管理" actionUrl="tstaskInfoController.do?datagrid" fitColumns="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="任务名称" field="taskName" query="true"></t:dgCol>
	<t:dgCol title="任务负责人" field="taskManager"></t:dgCol>
	<t:dgCol title="任务开始日期" field="taskStartDate" formatter="yyyy-MM-dd" ></t:dgCol>
	<t:dgCol title="任务结束日期" field="taskEndDate" formatter="yyyy-MM-dd"  ></t:dgCol>
	<t:dgCol title="计划完成日期" field="taskPlanDate" formatter="yyyy-MM-dd" ></t:dgCol>
	<t:dgCol title="任务状态" field="taskStatus" query="true" dictionary ="taskstatus"></t:dgCol>
	<t:dgCol title="任务类型" field="taskType" query="true" dictionary ="tasktype"></t:dgCol>
	<t:dgCol title="任务级别" field="taskLevel" query="true" dictionary ="tasklevel" ></t:dgCol>
	<t:dgCol title="项目描述" field="taskDesc"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建时间" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsprojectController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tstaskInfoController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tstaskInfoController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tstaskInfoController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="批量删除" icon="icon-del" url="tstaskInfoController.do?doBatchDel" funname="del" width="100%" height="100%"></t:dgToolBar>
</t:datagrid>
</div>
</div>
