
package com.buss.page.tsmaterial;
import com.buss.entity.tsmaterial.TSMaterialEntity;
import com.buss.entity.tsmaterialinfo.TSMaterialinfoEntity;

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
 * @Description: 耗材基础信息
 * @author onlineGenerator
 * @date 2015-08-19 13:46:42
 * @version V1.0   
 *
 */
public class TSMaterialPage implements java.io.Serializable {
	/**保存-耗材费用管理*/
	private List<TSMaterialinfoEntity> tSMaterialinfoList = new ArrayList<TSMaterialinfoEntity>();
	public List<TSMaterialinfoEntity> getTSMaterialinfoList() {
		return tSMaterialinfoList;
	}
	public void setTSMaterialinfoList(List<TSMaterialinfoEntity> tSMaterialinfoList) {
		this.tSMaterialinfoList = tSMaterialinfoList;
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
	/**科目*/
	private java.lang.String itemName;
	/**明细*/
	private java.lang.String itemDetail;
	/**规格*/
	private java.lang.String standard;
	/**单价*/
	private java.math.BigDecimal price;
	/**供应商*/
	private java.lang.String supplier;
	
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
	 *@return: java.lang.String  科目
	 */
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  明细
	 */
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
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  单价
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应商
	 */
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
}
