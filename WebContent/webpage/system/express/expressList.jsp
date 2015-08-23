<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="projectList" title="快递信息" actionUrl="tsexpressController.do?datagrid" fitColumns="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="发运单号" field="sendOrderNum" query="true" ></t:dgCol>
	<t:dgCol title="快递单号" field="expressNum"></t:dgCol>
	<t:dgCol title="发运日期" field="sendDate" formatter="yyyy-MM-dd" query="true" ></t:dgCol>
	<t:dgCol title="寄件公司" field="sendCompany" ></t:dgCol>
	<t:dgCol title="回单状态" field="receiptStatus" query="true" dictionary ="rec_status"></t:dgCol>
	<t:dgCol title="承运商" field="carrier" query="true" dictionary ="carrier"></t:dgCol>
	<t:dgCol title="收货人" field="consignee"></t:dgCol>
	<t:dgCol title="收货地址" field="cAddress"></t:dgCol>
	<t:dgCol title="电话1" field="telephone1"></t:dgCol>
	<t:dgCol title="项目描述" field="projectDesc"></t:dgCol>
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建时间" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsexpressController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsexpressController.do?addorupdate" funname="add" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsexpressController.do?addorupdate" funname="update" width="100%" height="100%"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsexpressController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
</t:datagrid>
</div>
</div>

<script type="text/javascript">
/* $(document).ready(function() {
	//给时间控件加上样式
	$("#projectListtb").find("input[name='projectStartDate']").attr("class", "Wdate").attr("style", "height:20px;width:90px;").click(function() {
		WdatePicker({
			dateFmt : 'yyyy-MM-dd'
		});
	});
	$("#projectListtb").find("input[name='projectEndDate']").attr("class", "Wdate").attr("style", "height:20px;width:90px;").click(function() {
		WdatePicker({
			dateFmt : 'yyyy-MM-dd'
		});
	});
}); */

</script>