<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="consumfeeList" title="耗材费用基础信息" actionUrl="tsconsumbaseController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="科目" field="itemName" query="true" ></t:dgCol>
	<t:dgCol title="明细" field="itemDetail"></t:dgCol>
	<t:dgCol title="规格"  field="standard" ></t:dgCol>
	<t:dgCol title="供应商" field="supplier" ></t:dgCol>
	<t:dgCol title="单价" field="price"  ></t:dgCol>
	
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDelOpt title="删除" url="tsconsumbaseController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsconsumbaseController.do?addorupdate" funname="add" ></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsconsumbaseController.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsconsumbaseController.do?addorupdate" funname="detail"></t:dgToolBar>
    
</t:datagrid>
</div>
</div>

<script type="text/javascript">


</script>