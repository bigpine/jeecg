<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="deliveryInfoList" title="配送信息管理" actionUrl="tsdeliveryInfoController.do?datagrid" fitColumns="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="公司" field="company" ></t:dgCol>
	<t:dgCol title="送达方" field="sendCode"></t:dgCol>
	<t:dgCol title="送达方名称" field="sendName"></t:dgCol>
	<t:dgCol title="售达方" field="saleCode" ></t:dgCol>
	<t:dgCol title="售达方名称" field="saleName" ></t:dgCol>
	<t:dgCol title="发货单类型" field="fhdType" query="true" dictionary ="fhd_type"></t:dgCol>
	<t:dgCol title="份数" field="fhdNum" ></t:dgCol>
	<t:dgCol title="发货单要求" field="fhdReq" ></t:dgCol>
	<t:dgCol title="发票是否随货" field="isInvoice" query="true" dictionary="is_invoice" ></t:dgCol>
	<t:dgCol title="发票要求" field="invoiceReq" query="true"></t:dgCol>
	<t:dgCol title="送货要求" field="deliveryReq"></t:dgCol>
	<t:dgCol title="回单要求" field="receiptReq"></t:dgCol>
	<t:dgCol title="装箱要求" field="binningReq"></t:dgCol>
	<t:dgCol title="其他要求" field="otherReq" hidden="true"></t:dgCol>
	<t:dgCol title="备注" field="deliveryDesc" hidden="true"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建时间" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsdeliveryInfoController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsdeliveryInfoController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsdeliveryInfoController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsdeliveryInfoController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<script type="text/javascript">

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tsdeliveryInfoController.do?upload', "deliveryInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tsdeliveryInfoController.do?exportXls","deliveryInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tsdeliveryInfoController.do?exportXlsByT","deliveryInfoList");
}

</script>