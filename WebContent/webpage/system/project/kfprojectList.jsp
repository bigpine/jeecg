<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="kfprojectList" title="客服项目管理" actionUrl="tskfprojectController.do?datagrid" fitColumns="true" idField="id" fit="true" queryMode="group" checkbox="true">
	
	<%-- <t:datagrid name="projectList" title="project.manage" autoLoadData="true" actionUrl="projectController.do?datagrid"  fitColumns="true"
	idField="id" fit="true" queryMode="group" >
	 --%>
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="公司" field="" query="true"></t:dgCol>
	<t:dgCol title="售达方" field=""></t:dgCol>
	<t:dgCol title="售达方抬头" field=""></t:dgCol>
	<t:dgCol title="送达方" field=""></t:dgCol>
	<t:dgCol title="送达方抬头" field=""></t:dgCol>
	<%-- <t:dgCol title="项目开始日期" field="kfprojectStartDate"  formatter="yyyy-MM-dd" ></t:dgCol>
	<t:dgCol title="项目结束日期" field="kfprojectEndDate"  formatter="yyyy-MM-dd" ></t:dgCol> --%>
	<t:dgCol title="发货单要求" field="" query="" dictionary =""></t:dgCol>
	<t:dgCol title="发货单要求备注" field=""></t:dgCol>
	<t:dgCol title="发票要求" field="" query="" dictionary =""></t:dgCol>
	<t:dgCol title="发票要求备注" field=""></t:dgCol>
	<t:dgCol title="发货要求" field="" query="" dictionary =""></t:dgCol>
	<t:dgCol title="回单要求" field="" query="true"></t:dgCol>
	<t:dgCol title="装箱要求" field="zxRequire" query="true"></t:dgCol>
	<t:dgCol title="客户其他要求" field="zxRequire" query="true"></t:dgCol>
	<t:dgCol title="备注" field="zxRequire" query="true"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建时间" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tskfprojectController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tskfprojectController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tskfprojectController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tskfprojectController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>

  <t:dgToolBar title="导出Excel" icon="icon-search" onclick="kfprojectListExportXls();"></t:dgToolBar>
	<t:dgToolBar title="导入Excel" icon="icon-search" onclick="kfprojectListImportXls()"></t:dgToolBar>
   
</t:datagrid>
</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	//给时间控件加上样式
	$("#kfprojectListtb").find("input[name='kfprojectStartDate']").attr("class", "Wdate").attr("style", "height:20px;width:90px;").click(function() {
		WdatePicker({
			dateFmt : 'yyyy-MM-dd'
		});
	});
	$("#kfprojectListtb").find("input[name='kfprojectEndDate']").attr("class", "Wdate").attr("style", "height:20px;width:90px;").click(function() {
		WdatePicker({
			dateFmt : 'yyyy-MM-dd'
		});
	});
});

//导入 导出功能exportXls
    function kfprojectListExportXls() {
		JeecgExcelExport("tskfprojectController.do?exportXls","kfprojectList");
	}
	
	function kfprojectListImportXls() {
		openuploadwin('Excel导入', 'tskfprojectController.do?upload', "kfprojectList");
	}

</script>