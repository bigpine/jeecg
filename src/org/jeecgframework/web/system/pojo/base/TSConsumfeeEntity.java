package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
@Entity
@Table(name = "t_s_consumfee", schema = "")
@SuppressWarnings("serial")
//CRM耗材费用管理 by tony
public class TSConsumfeeEntity implements Serializable {
	

	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**科目*/
	@Excel(name="科目")
	private java.lang.String itemName;
	@Excel(name="数量")
	private java.math.BigDecimal itemNum;
	/**明细*/
	@Excel(name="明细")
	private java.lang.String itemDetail;
	/**规格*/
	@Excel(name="规格")
	private java.lang.String standard;
	/**发生日期*/
	@Excel(name="发生日期")
	private java.util.Date markDate;
	/**单价*/
	@Excel(name="单价")
	private java.math.BigDecimal price;
	/**总额*/
	@Excel(name="总额")
	private java.math.BigDecimal amout;
	/**供应商*/
	@Excel(name="供应商")
	private java.lang.String supplier;
	
	private TSFeeManageEntity feeManage;
	/**费用类型*/
	@Excel(name="费用类型")
	private String feeType;
	/**费用基础ID*/
	/*@Excel(name="费用基础ID")
	private java.lang.String feeId;*/
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  科目
	 */
	@Column(name ="ITEM_NAME",nullable=true,length=255)
	public java.lang.String getItemName(){
		return this.itemName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  科目
	 */
	public void setItemName(java.lang.String itemName){
		this.itemName = itemName;
	}
	@Column(name ="ITEM_NUM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getItemNum() {
		return itemNum;
	}

	public void setItemNum(java.math.BigDecimal itemNum) {
		this.itemNum = itemNum;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  明细
	 */
	@Column(name ="ITEM_DETAIL",nullable=true,length=255)
	public java.lang.String getItemDetail(){
		return this.itemDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  明细
	 */
	public void setItemDetail(java.lang.String itemDetail){
		this.itemDetail = itemDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */
	@Column(name ="STANDARD",nullable=true,length=255)
	public java.lang.String getStandard(){
		return this.standard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setStandard(java.lang.String standard){
		this.standard = standard;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发生日期
	 */
	@Column(name ="MARK_DATE",nullable=true,length=20)
	public java.util.Date getMarkDate(){
		return this.markDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发生日期
	 */
	public void setMarkDate(java.util.Date markDate){
		this.markDate = markDate;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  单价
	 */
	@Column(name ="PRICE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  单价
	 */
	public void setPrice(java.math.BigDecimal price){
		this.price = price;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  总额
	 */
	@Column(name ="AMOUT",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getAmout(){
		return this.amout;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  总额
	 */
	public void setAmout(java.math.BigDecimal amout){
		this.amout = amout;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商
	 */
	@Column(name ="SUPPLIER",nullable=true,length=255)
	public java.lang.String getSupplier(){
		return this.supplier;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应商
	 */
	public void setSupplier(java.lang.String supplier){
		this.supplier = supplier;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用基础ID
	 */
/*	@Column(name ="FEE_ID",nullable=true,length=36)
	public java.lang.String getFeeId(){
		return this.feeId;
	}

	*//**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用基础ID
	 *//*
	public void setFeeId(java.lang.String feeId){
		this.feeId = feeId;
	}
*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fee_id")
	public TSFeeManageEntity getFeeManage() {
		return feeManage;
	}

	public void setFeeManage(TSFeeManageEntity feeManage) {
		this.feeManage = feeManage;
	}
	@Column(name ="FEE_TYPE",nullable=true,length=50)
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	
}
