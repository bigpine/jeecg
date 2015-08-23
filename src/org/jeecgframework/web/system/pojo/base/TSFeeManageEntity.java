package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "t_s_feemanage", schema = "")
@SuppressWarnings("serial")
public class TSFeeManageEntity implements Serializable {
	
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
	/**费用类别*/
	private java.lang.String feeType;
	/**字段一*/
	//private java.lang.String feeFieds;
	
	private java.lang.String feeFied1;
	private java.lang.String feeFied2;
	private java.lang.String feeFied3;
	private java.lang.String feeFied4;
	
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
	 *@return: java.lang.String  费用类别
	 */
	
	@Column(name ="FEE_TYPE",nullable=true,length=50)
	public java.lang.String getFeeType(){
		return this.feeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用类别
	 */
	public void setFeeType(java.lang.String feeType){
		this.feeType = feeType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段一
	 */
	
	@Column(name ="FEE_FIED1",nullable=true,length=255)
	public java.lang.String getFeeFied1(){
		return this.feeFied1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段一
	 */
	public void setFeeFied1(java.lang.String feeFied1){
		this.feeFied1 = feeFied1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段二
	 */
	
	@Column(name ="FEE_FIED2",nullable=true,length=255)
	public java.lang.String getFeeFied2(){
		return this.feeFied2;
	}
	
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段二
	 */
	public void setFeeFied2(java.lang.String feeFied2){
		this.feeFied2 = feeFied2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段三
	 */
	
	@Column(name ="FEE_FIED3",nullable=true,length=255)
	public java.lang.String getFeeFied3(){
		return this.feeFied3;
	}
	
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段三
	 */
	public void setFeeFied3(java.lang.String feeFied3){
		this.feeFied3 = feeFied3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字段四
	 */
	
	@Column(name ="FEE_FIED4",nullable=true,length=255)
	public java.lang.String getFeeFied4(){
		return this.feeFied4;
	}
	
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段四
	 */
	public void setFeeFied4(java.lang.String feeFied4){
		this.feeFied4 = feeFied4;
	}

}
