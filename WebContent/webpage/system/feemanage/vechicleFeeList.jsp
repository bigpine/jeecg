<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="vechiclefeeList" title="车辆费用管理" actionUrl="tsvechiclefeeController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="发车日期" field="sendDate" formatter="yyyy-MM-dd"  query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="车牌" field="carCode" query="true" dictionary ="car_code"></t:dgCol>
	<t:dgCol title="当天公里数" field="dayKm"></t:dgCol>
	<t:dgCol title="下班公里数" field="outKm" ></t:dgCol>
	<t:dgCol title="园区停车" field="parkFee"></t:dgCol>
	<t:dgCol title="油费" field="oilFee"  ></t:dgCol>
	<t:dgCol title="油耗" field="oilMouse"></t:dgCol>
	<t:dgCol title="停车费" field="stopFee" ></t:dgCol>
	<t:dgCol title="通行费" field="pikeFee" ></t:dgCol>
	<t:dgCol title="维修费" field="serviceFee" ></t:dgCol>
	<t:dgCol title="加油公里数" field="addOilKm" ></t:dgCol>
	<t:dgCol title="加油/公升" field="oilNum" ></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsvechiclefeeController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsvechiclefeeController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsvechiclefeeController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsvechiclefeeController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<script type="text/javascript">

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tsvechiclefeeController.do?upload', "vechiclefeeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tsvechiclefeeController.do?exportXls","vechiclefeeList");
}

$(document).ready(function(){
	$("input[name='sendDate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='sendDate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});


</script>