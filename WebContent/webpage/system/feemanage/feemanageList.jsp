<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="feemanageList" title="费用管理" actionUrl="tsfeemanageController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="费用类别" field="feeType" query="true" dictionary ="fee_type"></t:dgCol>
	<t:dgCol title="字段1" field="feeFied1"></t:dgCol>
	<t:dgCol title="字段2" field="feeFied2"></t:dgCol>
	<t:dgCol title="字段3" field="feeFied3" ></t:dgCol>
	<t:dgCol title="字段4" field="feeFied4" ></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建时间" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsfeemanageController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsfeemanageController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsfeemanageController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsfeemanageController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<script type="text/javascript">

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tsfeemanageController.do?upload', "feemanageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tsfeemanageController.do?exportXls","feemanageList");
}



</script>