<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="consumfeeList" title="耗材费用管理" actionUrl="tsconsumfeeController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="发生日期" field="markDate" frozenColumn="true" formatter="yyyy-MM-dd" query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="科目" field="itemName" frozenColumn="true" query="true" ></t:dgCol>
	<t:dgCol title="明细"  frozenColumn="true" field="itemDetail"></t:dgCol>
	<t:dgCol title="规格"  frozenColumn="true" field="standard" ></t:dgCol>
	<t:dgCol title="单价" frozenColumn="true" field="price"  ></t:dgCol>
	<t:dgCol title="数量" frozenColumn="true" field="itemNum"></t:dgCol>
	<t:dgCol title="金额" frozenColumn="true" field="amout"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsconsumfeeController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsconsumfeeController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsconsumfeeController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsconsumfeeController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<script type="text/javascript">

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tsconsumfeeController.do?upload', "consumfeeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tsconsumfeeController.do?exportXls","consumfeeList");
}

$(document).ready(function(){
	$("input[name='markDate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='markDate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});

	/* $("input[name='markDate_begin']").arrt("class","easyui-datebox");
	$("input[name='markDate_end']").arrt("class","easyui-datebox"); */
});

</script>