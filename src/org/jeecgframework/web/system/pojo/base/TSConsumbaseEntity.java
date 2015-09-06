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
@Table(name = "t_s_consum_base", schema = "")
@SuppressWarnings("serial")
public class TSConsumbaseEntity implements Serializable {

	private String id; //主键
	private String itemName;//科目
	private String itemDetail;//明细
	private String standard;//规格
	private String supplier; //供应商
	private java.math.BigDecimal price; //单价
	private String createName; //创建人
	private String createBy;   //创建人
	private Date createDate;   //创建日期
	private String updateName; //修改人
	private String updateBy;   //修改人
	private Date updateDate;   //修改日期
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name ="ITEM_NAME",nullable=true,length=255)
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Column(name ="ITEM_DETAIL",nullable=true,length=255)
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	@Column(name ="STANDARD",nullable=true,length=255)
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	@Column(name ="SUPPLIER",nullable=true,length=255)
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	@Column(name ="PRICE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getPrice() {
		return price;
	}
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Column(name ="CREATE_DATE",nullable=true)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
