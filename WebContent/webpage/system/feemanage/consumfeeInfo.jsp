<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden;">
<head>
<title>耗材费用管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	$(function() {
		//查看模式情况下,删除和上传附件功能禁止使用
		if (location.href.indexOf("load=detail") != -1) {
			$(".jeecgDetail").hide();
		}
	});

	function close() {
		frameElement.api.close();
	}
	/* 
	//泡沫箱
	var city1 = ["2泡沫箱","4泡沫箱","6泡沫箱","8泡沫箱","9泡沫箱","BV-E48H包装箱110L","BV-E48H包装箱43L","BV-E48H包装箱10L"]; 
	//泡沫平板
	var city2 = ["1泡沫平板1","1泡沫平板2","2泡沫平板1","2泡沫平板2","2泡沫平板3","4泡沫平板1","4泡沫平板2","4泡沫平板3","5泡沫平板1","5泡沫平板2","5泡沫平板3","7泡沫平板1","7泡沫平板2","7泡沫平板3","泡沫平板1","泡沫平板2"]; 
	//纸箱
	var city3 = ["1纸箱","2纸箱","3纸箱","4纸箱","5纸箱","6纸箱","7纸箱","8纸箱","9纸箱","#纸箱","定标包装盒"]; 
	//冰
	var city4 = ["冰袋","冰袋20L","冰袋20S","干冰","包冰布"]; 
	//托盘
	var city5 = ["托盘"];
	//发票袋
	var city6 = ["得力5521拉链袋"];
	//其他
	var city7 = ["机制打包带","手工打包带","打包扣","纸护角","纤维棉","缠绕膜","气泡垫","缓冲气垫","封箱带","印字封箱带","1号印字封箱带","牛皮纸","润达发货单","康祥发货单","SAP发货单","内包装高压袋1(5号箱)","内包装高压袋2(4号箱)","内包装高压袋3"];
	//标签
	var city8 = ["标签","防水标签","标签纸"];
	//碳带
	var city9 = ["碳带","色带"]; */


	//科目
	/* var provinceName = ["泡沫箱","泡沫平板","纸箱","冰","托盘","发票袋","其他","标签","碳带"];


	function province() 
	{

	    var e = document.form1.province; 
	    for (var i=0; i<provinceName.length; i++) 
	       e.options.add(new Option(provinceName[i], provinceName[i])); 
	} 
	function cityName(n) 
	{ 
	    var e = document.form1.city; 
	    for (var i=e.options.length; i>0; i--)  e.remove(i); 
	    if (n == 0) return; 
	    var a = eval("city"+ n); //得到明细的数组名 
	    for (var i=0; i<a.length; i++) e.options.add(new Option(a[i], a[i])); 
	} 
	function onload() 
	{ 
	    province(); //初始时给科目下拉菜单赋内容 
	} 

	 */
	
</script>
<!-- 弹出页面窗口大小控制 -->
<style type="text/css">
#formobj {
	height: 65%;
	min-height: 300px;
	overflow-y: auto;
	overflow-x: auto;
	min-width: 600px;
}
</style>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="tsconsumfeeController.do?save">
		<input id="id" name="id" type="hidden" value="${tsConsumFeePage.id }">

		<input id="createName" name="createUser" type="hidden"
			value="${tsConsumFeePage.createName}">
		<input id="createDate" name="createTime" type="hidden"
			value="${tsConsumFeePage.createDate}">
		<input id="updateName" name="updateUser" type="hidden"
			value="${tsConsumFeePage.updateName}">
		<input id="updateDate" name="createUser" type="hidden"
			value="${tsConsumFeePage.updateDate}">
		<input id="updateBy" name="updateBy" type="hidden"
			value="${tsConsumFeePage.updateBy}">
		<input id="createBy" name="createBy" type="hidden"
			value="${tsConsumFeePage.createBy}">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
			<td align="right"><label class="Validform_label">科目:</label></td>
			  <td>
	         <t:dictSelect field="itemName"  typeGroupCode="subject" defaultVal="${tsConsumFeePage.itemName}" hasLabel="false"></t:dictSelect>
	        </td>
	        
	           <!--  <td>
	             <select name="province" onchange="cityName(this.selectedIndex)"> 
                 <option value="">请选择科目</option> 
                 </select>
	           </td> -->
	          <td align="right"><label class="Validform_label">明细: </label></td>
		      <td class="value"><input class="inputxt" id="itemDetail" name="itemDetail"  value="${tsConsumFeePage.itemDetail}"> <span class="Validform_checktip"></span></td>
	         
	        <!--  <td>
	         <select name="city"> 
            <option value="">请选择明细</option> 
            </select> 
            </td> -->
		</tr>
		<tr>
             <td align="right"><label class="Validform_label">规格: </label></td>
		     <td class="value"><input class="inputxt" id="standard" name="standard"  value="${tsConsumFeePage.standard}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 供应商: </label></td>
		     <td class="value"><input class="inputxt" id="supplier" name="supplier"  value="${tsConsumFeePage.supplier}"> <span class="Validform_checktip"></span></td>

			</tr>
           <tr>
             <td align="right"><label class="Validform_label">单价: </label></td>
		     <td class="value"><input class="inputxt" id="price" name="price"  value="${tsConsumFeePage.price}"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 数量: </label></td>
		     <td class="value"><input class="inputxt" id="itemNum" name="itemNum"  value="${tsConsumFeePage.itemNum}"> <span class="Validform_checktip"></span></td>

			</tr>
			
			  <tr>
            <td align="right"><label class="Validform_label"> 发生日期: </label></td>
			<td class="value"><input class="Wdate" onClick="WdatePicker()" style="width: 150px" id="markDate" name="markDate" ignore="ignore"
				value="<fmt:formatDate value='${tsConsumFeePage.markDate}' type="date" pattern="yyyy-MM-dd"/>"> <span class="Validform_checktip"></span></td>

			 <td align="right"><label class="Validform_label"> 金额: </label></td>
		     <td class="value"><input class="inputxt" id="amout" name="amout"  value="${tsConsumFeePage.amout}"> <span class="Validform_checktip"></span></td>

			</tr>
            <tr>
            <td align="right"><label class="Validform_label">费用类别:</label></td>
			 <td>
	         <t:dictSelect field="feeType" typeGroupCode="fee_type" defaultVal="${tsConsumFeePage.feeType}" hasLabel="false"></t:dictSelect>
	        </td>
            </tr>
            
			<!-- <tr>
				<td></td>
				<td colspan="3" class="value"><script type="text/javascript">
					$.dialog.setting.zIndex = 1990;
					function del(url, obj) {
						$.dialog.confirm("确认删除该条记录?", function() {
							$.ajax({
								async : false,
								cache : false,
								type : 'POST',
								url : url,// 请求的action路径
								error : function() {// 请求失败处理函数
								},
								success : function(data) {
									var d = $.parseJSON(data);
									if (d.success) {
										var msg = d.msg;
										tip(msg);
										$(obj).closest("tr").hide("slow");
									}
								}
							});
						}, function() {
						});
					}
				</script></td>
			</tr> -->
		</table>
	</t:formvalid>
</body>