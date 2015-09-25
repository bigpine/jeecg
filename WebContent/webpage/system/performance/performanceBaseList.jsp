<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="performanceBaseList" title="绩效管理基础数据" actionUrl="tsperformanceBaseController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="绩效名称" field="perforName" query="true"></t:dgCol>
	<t:dgCol title="绩效类别" field="perforType" ></t:dgCol>
	<t:dgCol title="绩效明细" field="perforDetail"></t:dgCol>
	<t:dgCol title="分值" field="score"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsperformanceBaseController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsperformanceBaseController.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsperformanceBaseController.do?addorupdate" funname="update" ></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsperformanceBaseController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
    <t:dgToolBar title="批量删除" icon="icon-remove" url="tsperformanceBaseController.do?doDeleteALLSelect" funname="deleteALLSelect"></t:dgToolBar>
   
</t:datagrid>
</div>
</div>

<script type="text/javascript">



</script>