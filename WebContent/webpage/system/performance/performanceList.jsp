<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="performanceList" title="员工绩效管理" actionUrl="tsperformanceController.do?datagrid" fitColumns="true" checkbox="true" idField="id" fit="true" queryMode="group">
	<t:dgCol title="主键" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="发生日期" field="markDate" formatter="yyyy-MM-dd"  query="true" queryMode="group"></t:dgCol>
	<t:dgCol title="所属部门" field="departName" query="true"></t:dgCol>
	<t:dgCol title="员工名称" field="realName" query="true"></t:dgCol>
	<t:dgCol title="职责" field="position" ></t:dgCol>
	<t:dgCol title="分值" field="score"></t:dgCol>
	<t:dgCol title="外部投诉" field="isTrue"></t:dgCol>
	<t:dgCol title="绩效描述" field="performanceDesc" hidden="true"></t:dgCol>
	<t:dgCol title="状态" field="subStatus"   query="true"></t:dgCol> 
	<t:dgCol title="创建人" field="createName"></t:dgCol>
	<t:dgCol title="创建日期" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" ></t:dgCol>
	<t:dgCol title="修改人" field="updateName"></t:dgCol>
	<t:dgCol title="修改日期" field="updateDate" ></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
    <%-- <t:dgFunOpt exp="subStatus#eq#未处理" operationCode="szqm" funname="szqm(id)" title="审核" /> --%>
    <t:dgDelOpt title="提交" exp="subStatus#eq#未处理" url="tsperformanceController.do?saveAuthor&id={id}" />
  <%--   <t:dgFunOpt exp="subStatus#eq#已处理" operationCode="szqm1" funname="szqm1(id)" title="撤回" /> --%>
	<t:dgDelOpt title="删除"  url="tsperformanceController.do?del&id={id}" />
	<t:dgDelOpt title="取消" exp="subStatus#eq#待确认" url="tsperformanceController.do?reset&id={id}" />
	<t:dgDelOpt title="确认" exp="subStatus#eq#待确认" url="tsperformanceController.do?subStatus&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="tsperformanceController.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tsperformanceController.do?addorupdate" funname="update" ></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="tsperformanceController.do?addorupdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
  <%--   <t:dgToolBar title="批量删除" icon="icon-remove" url="tsperformanceController.do?doDeleteALLSelect" funname="deleteALLSelect"></t:dgToolBar> --%>
   
</t:datagrid>
</div>
</div>

<script type="text/javascript">


$(document).ready(function(){
	$("input[name='markDate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
	$("input[name='markDate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
});
/* function szqm1(id) {
	createwindow('撒回', 'tsperformanceController.do?reset&id=' + id);
} */
/* function szqm(id) {
	createwindow('审核', 'tsperformanceController.do?doCheck&id=' + id);
}
 */
</script>