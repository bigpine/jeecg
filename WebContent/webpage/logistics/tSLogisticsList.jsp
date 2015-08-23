<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tSLogisticsList" checkbox="true" fitColumns="false" title="物流配送管理" actionUrl="tSLogisticsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司"  field="tCompany"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="售达方"  field="tSalesCode"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="售达方抬头"  field="tSalesTitle"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="送达方"  field="tSendCode"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="送达方抬头"  field="tSendTitle"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货单要求"  field="tShipCode"   query="true" queryMode="single" dictionary="crm_ship" width="120"></t:dgCol>
   <t:dgCol title="发货单备注"  field="tShipAdd"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发票要求"  field="tInvoice"   query="true" queryMode="single" dictionary="invoice" width="120"></t:dgCol>
   <t:dgCol title="发票备注"  field="tInvoiceAdd"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回单要求"  field="tReceipt"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货要求"  field="tSendReq"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装箱要求"  field="tBinning"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户其他要求"  field="tCustomerOther"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注信息"  field="tDesc"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tSLogisticsController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tSLogisticsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tSLogisticsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tSLogisticsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tSLogisticsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/logistics/tSLogisticsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#tSLogisticsListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#tSLogisticsListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tSLogisticsController.do?upload', "tSLogisticsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tSLogisticsController.do?exportXls","tSLogisticsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tSLogisticsController.do?exportXlsByT","tSLogisticsList");
}
 </script>