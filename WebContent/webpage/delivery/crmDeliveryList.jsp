<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="crmDeliveryList" checkbox="true" fitColumns="false" title="配送信息表" actionUrl="crmDeliveryController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司"  field="tCompany"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司编号"  field="tCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="售达方11111"  field="tSale"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="售达方抬头"  field="tSaleTitle"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="送达方"  field="tSend"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="送达方抬头"  field="tSendTitle"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货单要求"  field="tShipReq"    queryMode="single" dictionary="crm_ship" width="120"></t:dgCol>
   <t:dgCol title="发货单备注"  field="tShipReqadd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票要求"  field="tInvoice"   query="true" queryMode="single" dictionary="invoice" width="120"></t:dgCol>
   <t:dgCol title="发票备注信息"  field="tInvoiceAdd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回单要求"  field="tReceipt"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货要求"  field="tDeliveryReq"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装箱要求"  field="tBinning"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户其他要求"  field="tCustomerReq"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注信息"  field="tDeliveryDesc"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="crmDeliveryController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="crmDeliveryController.do?goAdd" funname="add"width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="crmDeliveryController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="crmDeliveryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="crmDeliveryController.do?goUpdate" funname="detail"width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/rundacrm/com.runda.delivery/crmDeliveryList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#crmDeliveryListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#crmDeliveryListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'crmDeliveryController.do?upload', "crmDeliveryList");
}

//导出
function ExportXls() {
	JeecgExcelExport("crmDeliveryController.do?exportXls","crmDeliveryList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("crmDeliveryController.do?exportXlsByT","crmDeliveryList");
}
 </script>