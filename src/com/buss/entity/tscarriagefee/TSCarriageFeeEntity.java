package com.buss.entity.tscarriagefee;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 运输费用管理
 * @author onlineGenerator
 * @date 2015-08-20 13:59:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_carriage_fee", schema = "")
@SuppressWarnings("serial")
public class TSCarriageFeeEntity implements java.io.Serializable {
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
	/**承运商*/
	@Excel(name="承运商")
	private java.lang.String carrier;
	/**起始地*/
	@Excel(name="起始地")
	private java.lang.String origin;
	/**目的地*/
	@Excel(name="目的地")
	private java.lang.String destination;
	/**要求温度*/
	@Excel(name="要求温度")
	private java.lang.String reqTemp;
	/**到货温度*/
	@Excel(name="到货温度")
	private java.lang.String arrTemp;
	/**体积*/
	@Excel(name="体积")
	private java.lang.String volume;
	/**重量*/
	@Excel(name="重量")
	private java.lang.String weight;
	/**车型*/
	@Excel(name="车型")
	private java.lang.String model;
	/**结算方式*/
	@Excel(name="结算方式")
	private java.lang.String payType;
	/**单价*/
	@Excel(name="单价")
	private java.math.BigDecimal price;
	/**发车次数*/
	@Excel(name="发车次数")
	private java.lang.Integer sendNum;
	/**金额*/
	@Excel(name="金额")
	private java.math.BigDecimal amout;
	/**仪器型号*/
	@Excel(name="仪器型号")
	private java.lang.String instrument;
	/**发车日期*/
	@Excel(name="发车日期")
	private java.util.Date sendDate;
	/**费用基础id*/
	private java.lang.String feeId;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String carriageDesc;
	
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
	 *@return: java.lang.String  承运商
	 */
	@Column(name ="CARRIER",nullable=true,length=50)
	public java.lang.String getCarrier(){
		return this.carrier;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承运商
	 */
	public void setCarrier(java.lang.String carrier){
		this.carrier = carrier;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  起始地
	 */
	@Column(name ="ORIGIN",nullable=true,length=255)
	public java.lang.String getOrigin(){
		return this.origin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  起始地
	 */
	public void setOrigin(java.lang.String origin){
		this.origin = origin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目的地
	 */
	@Column(name ="DESTINATION",nullable=true,length=255)
	public java.lang.String getDestination(){
		return this.destination;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的地
	 */
	public void setDestination(java.lang.String destination){
		this.destination = destination;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  要求温度
	 */
	@Column(name ="REQ_TEMP",nullable=true,length=255)
	public java.lang.String getReqTemp(){
		return this.reqTemp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  要求温度
	 */
	public void setReqTemp(java.lang.String reqTemp){
		this.reqTemp = reqTemp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到货温度
	 */
	@Column(name ="ARR_TEMP",nullable=true,length=255)
	public java.lang.String getArrTemp(){
		return this.arrTemp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到货温度
	 */
	public void setArrTemp(java.lang.String arrTemp){
		this.arrTemp = arrTemp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积
	 */
	@Column(name ="VOLUME",nullable=true,length=255)
	public java.lang.String getVolume(){
		return this.volume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积
	 */
	public void setVolume(java.lang.String volume){
		this.volume = volume;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重量
	 */
	@Column(name ="WEIGHT",nullable=true,length=255)
	public java.lang.String getWeight(){
		return this.weight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重量
	 */
	public void setWeight(java.lang.String weight){
		this.weight = weight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车型
	 */
	@Column(name ="MODEL",nullable=true,length=255)
	public java.lang.String getModel(){
		return this.model;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车型
	 */
	public void setModel(java.lang.String model){
		this.model = model;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算方式
	 */
	@Column(name ="PAY_TYPE",nullable=true,length=50)
	public java.lang.String getPayType(){
		return this.payType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算方式
	 */
	public void setPayType(java.lang.String payType){
		this.payType = payType;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发车次数
	 */
	@Column(name ="SEND_NUM",nullable=true,length=10)
	public java.lang.Integer getSendNum(){
		return this.sendNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发车次数
	 */
	public void setSendNum(java.lang.Integer sendNum){
		this.sendNum = sendNum;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  金额
	 */
	@Column(name ="AMOUT",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getAmout(){
		return this.amout;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  金额
	 */
	public void setAmout(java.math.BigDecimal amout){
		this.amout = amout;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仪器型号
	 */
	@Column(name ="INSTRUMENT",nullable=true,length=255)
	public java.lang.String getInstrument(){
		return this.instrument;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仪器型号
	 */
	public void setInstrument(java.lang.String instrument){
		this.instrument = instrument;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发车日期
	 */
	@Column(name ="SEND_DATE",nullable=true,length=20)
	public java.util.Date getSendDate(){
		return this.sendDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发车日期
	 */
	public void setSendDate(java.util.Date sendDate){
		this.sendDate = sendDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用基础id
	 */
	@Column(name ="FEE_ID",nullable=true,length=36)
	public java.lang.String getFeeId(){
		return this.feeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用基础id
	 */
	public void setFeeId(java.lang.String feeId){
		this.feeId = feeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="CARRIAGE_DESC",nullable=true,length=500)
	public java.lang.String getCarriageDesc(){
		return this.carriageDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setCarriageDesc(java.lang.String carriageDesc){
		this.carriageDesc = carriageDesc;
	}
}
