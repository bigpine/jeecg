package com.buss.entity.tsfeedaily;

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
 * @Description: 日常费用管理
 * @author onlineGenerator
 * @date 2015-08-20 13:59:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_fee_daily", schema = "")
@SuppressWarnings("serial")
public class TSFeeDailyEntity implements java.io.Serializable {
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
	/**费用名称*/
	@Excel(name="费用名称")
	private java.lang.String feeName;
	/**楼层*/
	@Excel(name="楼层")
	private java.lang.String floor;
	/**费用基础外键*/
	private java.lang.String feeId;
	/**发生日期*/
	@Excel(name="发生日期")
	private java.util.Date markDate;
	/**金额*/
	@Excel(name="金额")
	private java.math.BigDecimal amout;
	
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
	 *@return: java.lang.String  费用名称
	 */
	@Column(name ="FEE_NAME",nullable=true,length=255)
	public java.lang.String getFeeName(){
		return this.feeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用名称
	 */
	public void setFeeName(java.lang.String feeName){
		this.feeName = feeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  楼层
	 */
	@Column(name ="FLOOR",nullable=true,length=50)
	public java.lang.String getFloor(){
		return this.floor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  楼层
	 */
	public void setFloor(java.lang.String floor){
		this.floor = floor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用基础外键
	 */
	@Column(name ="FEE_ID",nullable=true,length=36)
	public java.lang.String getFeeId(){
		return this.feeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用基础外键
	 */
	public void setFeeId(java.lang.String feeId){
		this.feeId = feeId;
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
}
