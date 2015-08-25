<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!-- context path -->
<t:base type="jquery,easyui"></t:base>
<script type="text/javascript" src="plug-in/Highcharts-2.2.5/js/highcharts.src.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-2.2.5/js/modules/exporting.src.js"></script>
<t:tabs id="tt" iframe="false">
	<t:tab href="tsconsumfeeController.do?consumCount&reportType=line" icon="icon-search" title="111" id="pnode"></t:tab>
	<t:tab href="tsconsumfeeController.do?consumCount&reportType=pie" icon="icon-search" title="222" id="pnode"></t:tab>
	<t:tab href="tsconsumfeeController.do?consumCount&reportType=column" icon="icon-search" title="333" id="pnode"></t:tab>
</t:tabs>
