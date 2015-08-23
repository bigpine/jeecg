package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

@Entity
@Table(name="t_s_deliveryInfo",schema="")
@SuppressWarnings("serial")
public class TSDeliverInfoEntity implements Serializable {

	//private static final long serialVersionUID = 1L;
	
	private String id;//ID主键
	@Excel(name="公司")
	private String company; //公司
	@Excel(name="售达方")
	private String saleCode;//售达方
	@Excel(name="售达方名称")
	private String saleName;//售达方名称
	@Excel(name="送达方")
	private String sendCode;//送达方
	@Excel(name="送达方名称")
	private String sendName;//送达方名称
	@Excel(name="发货单类型")
    private String fhdType;//发货单类型
	@Excel(name="发货单要求")
    private String fhdReq; //发货单要求
	@Excel(name="发货单份数")
    private String fhdNum; //发货单份数
	@Excel(name="发票是否随货")
	private String isInvoice; //随货同行
	@Excel(name="发票要求")
	private String invoiceReq; //发票要求
	@Excel(name="送货要求")
	private String deliveryReq; //送货要求
	@Excel(name="回单要求")
	private String receiptReq;//回单要求
	@Excel(name="装箱要求")
	private String binningReq;//装箱要求
	@Excel(name="其他要求")
	private String otherReq; //顾客其他要求
	@Excel(name="备注")
	private String deliveryDesc;//备注信息
	/** 创建人名称 */
	private String createName;
	/** 创建人登录名称 */
	private String createBy;
	/** 创建日期 */
	private Date createDate;
	/** 更新人名称 */
	private String updateName;
	/** 更新人登录名称 */
	private String updateBy;
	/** 更新日期 */
	private Date updateDate;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "COMPANY", nullable = false)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name = "SALE_CODE", nullable = false)
	public String getSaleCode() {
		return saleCode;
	}
	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}
	@Column(name = "SALE_NAME", nullable = false)
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	@Column(name = "SEND_CODE", nullable = false)
	public String getSendCode() {
		return sendCode;
	}
	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}
	@Column(name = "SEND_NAME", nullable = false)
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	@Column(name = "FHD_TYPE", nullable = false)
	public String getFhdType() {
		return fhdType;
	}
	public void setFhdType(String fhdType) {
		this.fhdType = fhdType;
	}
	@Column(name = "FHD_REQ", nullable = false)
	public String getFhdReq() {
		return fhdReq;
	}
	public void setFhdReq(String fhdReq) {
		this.fhdReq = fhdReq;
	}
	@Column(name = "FHD_NUM", nullable = false)
	public String getFhdNum() {
		return fhdNum;
	}
	public void setFhdNum(String fhdNum) {
		this.fhdNum = fhdNum;
	}
	@Column(name = "IS_INVOICE", nullable = false)
	public String getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}
	@Column(name = "INVOICE_REQ", nullable = false)
	public String getInvoiceReq() {
		return invoiceReq;
	}
	public void setInvoiceReq(String invoiceReq) {
		this.invoiceReq = invoiceReq;
	}
	@Column(name = "DELIVERY_REQ", nullable = false)
	public String getDeliveryReq() {
		return deliveryReq;
	}
	public void setDeliveryReq(String deliveryReq) {
		this.deliveryReq = deliveryReq;
	}
	@Column(name = "RECEIPT_REQ", nullable = false)
	public String getReceiptReq() {
		return receiptReq;
	}
	public void setReceiptReq(String receiptReq) {
		this.receiptReq = receiptReq;
	}
	@Column(name = "BINNING_REQ", nullable = false)
	public String getBinningReq() {
		return binningReq;
	}
	public void setBinningReq(String binningReq) {
		this.binningReq = binningReq;
	}
	@Column(name = "OTHER_REQ", nullable = false)
	public String getOtherReq() {
		return otherReq;
	}
	public void setOtherReq(String otherReq) {
		this.otherReq = otherReq;
	}
	@Column(name = "DELIVERY_DESC", nullable = false)
	public String getDeliveryDesc() {
		return deliveryDesc;
	}
	public void setDeliveryDesc(String deliveryDesc) {
		this.deliveryDesc = deliveryDesc;
	}
	@Column(name = "CREATE_NAME", nullable = true)
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@Column(name = "CREATE_BY", nullable = true)
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Column(name = "CREATE_DATE", nullable = true)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name = "UPDATE_NAME", nullable = true)
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	@Column(name = "UPDATE_BY", nullable = true)
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	@Column(name = "UPDATE_DATE", nullable = true)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
