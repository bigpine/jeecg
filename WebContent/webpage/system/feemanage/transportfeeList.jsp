<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="transportfeeList" title="运输费用管理" actionUrl="tstransportfeeController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="发车日期" field="sendDate" formatter="yyyy-MM-dd" query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="到货日期" field="arrDate" formatter="yyyy-MM-dd" ></t:dgCol>
	<t:dgCol title="始发地" field="origin" query="true" ></t:dgCol>
	<t:dgCol title="目的地" field="destination" query="true" ></t:dgCol>
	<t:dgCol title="承运商" field="carrier" query="true" ></t:dgCol>
	<t:dgCol title="要求温度" field="reqTemp"  ></t:dgCol>
	<t:dgCol title="到货温度" field="arrTemp"></t:dgCol>
	<t:dgCol title="仪器型号" field="instrument"></t:dgCol>
	<t:dgCol title="单价" field="price"></t:dgCol>
	<t:dgCol title="发运次数" field="sendNum"></t:dgCol>
	<t:dgCol title="金额" field="amout"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tstransportfeeController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tstransportfeeController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tstransportfeeController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tstransportfeeController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<script type="text/javascript">

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tstransportfeeController.do?upload', "transportfeeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tstransportfeeController.do?exportXls","transportfeeList");
}

$(document).ready(function(){
	$("input[name='sendDate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='sendDate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});



</script>