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
@Table(name = "t_s_vehiclefee", schema = "")
@SuppressWarnings("serial")
//CRM车辆费用管理 by tony
public class TSVechicleFeeEntity implements Serializable {


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
	/**发车日期*/
	@Excel(name="发车日期")
	private java.util.Date sendDate;
	/**车牌*/
	@Excel(name="车牌")
	private java.lang.String carCode;
	/**驾驶员*/
	@Excel(name="驾驶员")
	private java.lang.String driver;
	/**当天行驶公里*/
	@Excel(name="当天行驶公里")
	private java.math.BigDecimal dayKm;
	/**下班公里*/
	@Excel(name="下班公里")
	private java.math.BigDecimal outKm;
	/**园区停车*/
	@Excel(name="园区停车")
	private java.math.BigDecimal parkFee;
	/**油费*/
	@Excel(name="油费")
	private java.math.BigDecimal oilFee;
	/**油耗*/
	@Excel(name="油耗")
	private java.math.BigDecimal oilMouse;
	/**停车费*/
	@Excel(name="停车费")
	private java.math.BigDecimal stopFee;
	/**通行费*/
	@Excel(name="通行费")
	private java.math.BigDecimal pikeFee;
	/**维修费*/
	@Excel(name="维修费")
	private java.math.BigDecimal serviceFee;
	/**洗车费*/
	@Excel(name="洗车费")
	private java.math.BigDecimal washFee;
	/**ETC费用*/
	@Excel(name="ETC费用")
	private java.math.BigDecimal etcFee;
	/**出车里程*/
	@Excel(name="出车里程")
	private java.math.BigDecimal startKm;
	/**回程里程*/
	@Excel(name="回程里程")
	private java.math.BigDecimal endKm;
	/**加油里程数*/
	@Excel(name="加油里程数")
	private java.math.BigDecimal addOilKm;
	/**加油公升数*/
	@Excel(name="加油公升数")
	private java.math.BigDecimal oilNum;
	/**维修明细*/
	@Excel(name="维修明细")
	private java.lang.String serviceDetail;
	/**费用基础ID*/
	/*@Excel(name="费用基础ID")
	private java.lang.String feeId;*/
	
	private TSFeeManageEntity feeManage;
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
	 *@return: java.lang.String  车牌
	 */
	@Column(name ="CAR_CODE",nullable=true,length=50)
	public java.lang.String getCarCode(){
		return this.carCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌
	 */
	public void setCarCode(java.lang.String carCode){
		this.carCode = carCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶员
	 */
	@Column(name ="DRIVER",nullable=true,length=50)
	public java.lang.String getDriver(){
		return this.driver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶员
	 */
	public void setDriver(java.lang.String driver){
		this.driver = driver;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  当天行驶公里
	 */
	@Column(name ="DAY_KM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getDayKm(){
		return this.dayKm;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  当天行驶公里
	 */
	public void setDayKm(java.math.BigDecimal dayKm){
		this.dayKm = dayKm;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  下班公里
	 */
	@Column(name ="OUT_KM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getOutKm(){
		return this.outKm;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  下班公里
	 */
	public void setOutKm(java.math.BigDecimal outKm){
		this.outKm = outKm;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  园区停车
	 */
	@Column(name ="PARK_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getParkFee(){
		return this.parkFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  园区停车
	 */
	public void setParkFee(java.math.BigDecimal parkFee){
		this.parkFee = parkFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  油费
	 */
	@Column(name ="OIL_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getOilFee(){
		return this.oilFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  油费
	 */
	public void setOilFee(java.math.BigDecimal oilFee){
		this.oilFee = oilFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  油耗
	 */
	@Column(name ="OIL_MOUSE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getOilMouse(){
		return this.oilMouse;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  油耗
	 */
	public void setOilMouse(java.math.BigDecimal oilMouse){
		this.oilMouse = oilMouse;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  停车费
	 */
	@Column(name ="STOP_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getStopFee(){
		return this.stopFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  停车费
	 */
	public void setStopFee(java.math.BigDecimal stopFee){
		this.stopFee = stopFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  通行费
	 */
	@Column(name ="PIKE_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getPikeFee(){
		return this.pikeFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  通行费
	 */
	public void setPikeFee(java.math.BigDecimal pikeFee){
		this.pikeFee = pikeFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  维修费
	 */
	@Column(name ="SERVICE_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getServiceFee(){
		return this.serviceFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  维修费
	 */
	public void setServiceFee(java.math.BigDecimal serviceFee){
		this.serviceFee = serviceFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  洗车费
	 */
	@Column(name ="WASH_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getWashFee(){
		return this.washFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  洗车费
	 */
	public void setWashFee(java.math.BigDecimal washFee){
		this.washFee = washFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  ETC费用
	 */
	@Column(name ="ETC_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getEtcFee(){
		return this.etcFee;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  ETC费用
	 */
	public void setEtcFee(java.math.BigDecimal etcFee){
		this.etcFee = etcFee;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  出车里程
	 */
	@Column(name ="START_KM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getStartKm(){
		return this.startKm;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  出车里程
	 */
	public void setStartKm(java.math.BigDecimal startKm){
		this.startKm = startKm;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  回程里程
	 */
	@Column(name ="END_KM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getEndKm(){
		return this.endKm;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  回程里程
	 */
	public void setEndKm(java.math.BigDecimal endKm){
		this.endKm = endKm;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  加油里程数
	 */
	@Column(name ="ADD_OIL_KM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getAddOilKm(){
		return this.addOilKm;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  加油里程数
	 */
	public void setAddOilKm(java.math.BigDecimal addOilKm){
		this.addOilKm = addOilKm;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  加油公升数
	 */
	@Column(name ="OIL_NUM",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getOilNum(){
		return this.oilNum;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  加油公升数
	 */
	public void setOilNum(java.math.BigDecimal oilNum){
		this.oilNum = oilNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维修明细
	 */
	@Column(name ="SERVICE_DETAIL",nullable=true,length=255)
	public java.lang.String getServiceDetail(){
		return this.serviceDetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维修明细
	 */
	public void setServiceDetail(java.lang.String serviceDetail){
		this.serviceDetail = serviceDetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用基础ID
	 */
	/*@Column(name ="FEE_ID",nullable=true,length=36)
	public java.lang.String getFeeId(){
		return this.feeId;
	}

	*//**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用基础ID
	 *//*
	public void setFeeId(java.lang.String feeId){
		this.feeId = feeId;
	}*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fee_id")
	public TSFeeManageEntity getFeeManage() {
		return feeManage;
	}

	public void setFeeManage(TSFeeManageEntity feeManage) {
		this.feeManage = feeManage;
	}
}
