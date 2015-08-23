


<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>配送信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="crmDeliveryController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${crmDeliveryPage.id }">
					<input id="createName" name="createName" type="hidden" value="${crmDeliveryPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${crmDeliveryPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${crmDeliveryPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${crmDeliveryPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${crmDeliveryPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${crmDeliveryPage.updateDate }">
					<input id="tCompanyCode" name="tCompanyCode" type="hidden" value="${crmDeliveryPage.tCompanyCode }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司:
						</label>
					</td>
					<td class="value">
					     	 <input id="tCompany" name="tCompany" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司</label>
						</td>
			    </tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							售达方:
						</label>
					</td>
					<td class="value">
					     	 <input id="tSale" name="tSale" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">售达方</label>
						</td>
					
				
					<td align="right">
						<label class="Validform_label">
							售达方抬头:
						</label>
					</td>
					<td class="value">
					     	 <input id="tSaleTitle" name="tSaleTitle" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">售达方抬头</label>
						</td>
			    </tr>
			    <tr>
					<td align="right">
						<label class="Validform_label">
							送达方:
						</label>
					</td>
					<td class="value">
					     	 <input id="tSend" name="tSend" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">送达方</label>
						</td>
					
				
					<td align="right">
						<label class="Validform_label">
							送达方抬头:
						</label>
					</td>
					<td class="value">
					     	 <input id="tSendTitle" name="tSendTitle" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">送达方抬头</label>
						</td>
					</tr>
					<tr>	
					<td align="right">
						<label class="Validform_label">
							发货单类别:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="tShipReq" type="list"
									typeGroupCode="crm_ship" defaultVal="${crmDeliveryPage.tShipReq}" hasLabel="false"  title="发货单要求"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货单类别</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							发货单份数:
						</label>
					</td>
					<td class="value">
						     	 <input id="tShipNum" name="tShipNum" type="n" style="width: 150px" class="inputxt"  
									               
										       value='${crmDeliveryPage.tShipNum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货单份数</label>
						</td>
					
				
					<td align="right">
						<label class="Validform_label">
							发货单备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="tShipReqadd" name="tShipReqadd" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货单备注</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							发票要求:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="tInvoice" type="list"
									typeGroupCode="invoice" defaultVal="${crmDeliveryPage.tInvoice}" hasLabel="false"  title="发票要求"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票要求</label>
						</td>
					
					<td align="right">
						<label class="Validform_label">
							发票备注信息:
						</label>
					</td>
					<td class="value">
					     	 <input id="tInvoiceAdd" name="tInvoiceAdd" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发票备注信息</label>
						</td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							回单要求:
						</label>
					</td>
					<td class="value">
					     	 <input id="tReceipt" name="tReceipt" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回单要求</label>
						</td>
				   </tr>
				   <tr>
					<td align="right">
						<label class="Validform_label">
							发货要求:
						</label>
					</td>
					<td class="value">
					     	 <input id="tDeliveryReq" name="tDeliveryReq" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货要求</label>
						</td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							装箱要求:
						</label>
					</td>
					<td class="value">
					     	 <input id="tBinning" name="tBinning" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装箱要求</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户其他要求:
						</label>
					</td>
					<td class="value">
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="tCustomerReq" name="tCustomerReq"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户其他要求</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注信息:
						</label>
					</td>
					<td class="value">
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="tDeliveryDesc" name="tDeliveryDesc"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注信息</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/rundacrm/com.runda.delivery/crmDelivery.js"></script>		