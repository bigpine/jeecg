package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_s_express",schema="")
@SuppressWarnings("serial")
public class TSExpressEntity implements Serializable {
    
	/** 主键 */
	private String id ;
	/** 发运订单号 */
	private String sendOrderNum;
	/** 快递单号 */
	private String expressNum;
	/** 发运日期  */
	private Date sendDate;
	/** 寄件公司 */
	private String sendCompany;
	/** 寄件人姓名 */
	private String sendContactName;
	/** 寄件地址 */
	private String sendAddress;
	/** 收货人 */
	private String consignee;
	/** 收货人地址 */
	private String cAddress;
	/** 收货公司 */
	private String cCompany;
	/** 电话1  */
	private String telephone1;
	/** 电话2 */
	private String telephone2;
	/** 快递备注信息 */
	private String expressDesc;
	/** 承运商 */
	private String carrier;
	/** 回单状态 */
	private String receiptStatus;
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
	@Column(name = "ID", nullable = false, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "SEND_ORDER_NUM", nullable = false)
	public String getSendOrderNum() {
		return sendOrderNum;
	}
	public void setSendOrderNum(String sendOrderNum) {
		this.sendOrderNum = sendOrderNum;
	}
	@Column(name = "EXPRESS_NUM", nullable = false, length = 50)
	public String getExpressNum() {
		return expressNum;
	}
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	@Column(name = "SEND_DATE", nullable = true)
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	@Column(name = "SEND_COMPANY", nullable = true)
	public String getSendCompany() {
		return sendCompany;
	}
	public void setSendCompany(String sendCompany) {
		this.sendCompany = sendCompany;
	}
	@Column(name = "SEND_CONTACT_NAME", nullable = true)
	public String getSendContactName() {
		return sendContactName;
	}
	public void setSendContactName(String sendContactName) {
		this.sendContactName = sendContactName;
	}
	@Column(name = "SEND_ADDRESS", nullable = true)
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	@Column(name = "CONSIGNEE", nullable = true)
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	@Column(name = "C_ADDRESS", nullable = true)
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	@Column(name = "C_COMPANY", nullable = true)
	public String getcCompany() {
		return cCompany;
	}
	public void setcCompany(String cCompany) {
		this.cCompany = cCompany;
	}
	@Column(name = "TELEPHONE1", nullable = true)
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	@Column(name = "TELEPHONE2", nullable = true)
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	@Column(name = "EXPRESS_DESC", nullable = true)
	public String getExpressDesc() {
		return expressDesc;
	}
	public void setExpressDesc(String expressDesc) {
		this.expressDesc = expressDesc;
	}
	@Column(name = "CARRIER", nullable = true)
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	@Column(name = "RECEIPT_STATUS", nullable = true)
	public String getReceiptStatus() {
		return receiptStatus;
	}
	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
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
