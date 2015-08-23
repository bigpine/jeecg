
package com.buss.page.tsfeebase;
import com.buss.entity.tsfeebase.TSFeeBaseEntity;
import com.buss.entity.tscarriagefee.TSCarriageFeeEntity;
import com.buss.entity.tsvehiclefee.TSVehicleFeeEntity;
import com.buss.entity.tsmaterialfee.TSMaterialFeeEntity;
import com.buss.entity.tsfeedaily.TSFeeDailyEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;


/**   
 * @Title: Entity
 * @Description: 费用基础信息
 * @author onlineGenerator
 * @date 2015-08-20 13:59:07
 * @version V1.0   
 *
 */
public class TSFeeBasePage implements java.io.Serializable {
	/**保存-运输费用管理*/
	private List<TSCarriageFeeEntity> tSCarriageFeeList = new ArrayList<TSCarriageFeeEntity>();
	public List<TSCarriageFeeEntity> getTSCarriageFeeList() {
		return tSCarriageFeeList;
	}
	public void setTSCarriageFeeList(List<TSCarriageFeeEntity> tSCarriageFeeList) {
		this.tSCarriageFeeList = tSCarriageFeeList;
	}
	/**保存-车辆费用管理*/
	private List<TSVehicleFeeEntity> tSVehicleFeeList = new ArrayList<TSVehicleFeeEntity>();
	public List<TSVehicleFeeEntity> getTSVehicleFeeList() {
		return tSVehicleFeeList;
	}
	public void setTSVehicleFeeList(List<TSVehicleFeeEntity> tSVehicleFeeList) {
		this.tSVehicleFeeList = tSVehicleFeeList;
	}
	/**保存-耗材费用管理*/
	private List<TSMaterialFeeEntity> tSMaterialFeeList = new ArrayList<TSMaterialFeeEntity>();
	public List<TSMaterialFeeEntity> getTSMaterialFeeList() {
		return tSMaterialFeeList;
	}
	public void setTSMaterialFeeList(List<TSMaterialFeeEntity> tSMaterialFeeList) {
		this.tSMaterialFeeList = tSMaterialFeeList;
	}
	/**保存-日常费用管理*/
	private List<TSFeeDailyEntity> tSFeeDailyList = new ArrayList<TSFeeDailyEntity>();
	public List<TSFeeDailyEntity> getTSFeeDailyList() {
		return tSFeeDailyList;
	}
	public void setTSFeeDailyList(List<TSFeeDailyEntity> tSFeeDailyList) {
		this.tSFeeDailyList = tSFeeDailyList;
	}

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
	private java.lang.String feeFieds;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	public java.lang.String getFeeFieds(){
		return this.feeFieds;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字段一
	 */
	public void setFeeFieds(java.lang.String feeFieds){
		this.feeFieds = feeFieds;
	}
}
