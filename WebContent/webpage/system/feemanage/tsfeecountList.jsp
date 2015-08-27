<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="consumfeeList" title="test" actionUrl="tsfeecountcontroller.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="发生日期" field="markDate" formatter="yyyy-MM-dd" query="true" queryMode="group" hidden="true"></t:dgCol>
	<t:dgCol title="基础费用" field="baseFeeCount" ></t:dgCol>
	<t:dgCol title="耗材费用" field="consumFeeCount"></t:dgCol>
	<t:dgCol title="市内运输费用" field="vehicleFeeCount" ></t:dgCol>
	<t:dgCol title="外地运输费用" field="tranFeeCount"  ></t:dgCol>
	
	<t:dgCol title="操作" field="opt"></t:dgCol>
	
	<t:dgDelOpt title="查看详情" url="" />
	
</t:datagrid>
</div>
</div>

<script type="text/javascript">



$(document).ready(function(){
	$("input[name='markDate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='markDate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});

	
});

</script>