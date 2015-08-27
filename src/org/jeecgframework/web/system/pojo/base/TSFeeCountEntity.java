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
@Table(name = "t_s_feecount", schema = "")
@SuppressWarnings("serial")
public class TSFeeCountEntity implements Serializable {

	private String id; //主键
	
	private java.math.BigDecimal baseFeeCount;  //基础费用总额
	
	private java.math.BigDecimal consumFeeCount;  //耗材费用总额
	
	private java.math.BigDecimal tranFeeCount;   //运输费用总额
	
	private java.math.BigDecimal vehicleFeeCount;  //车辆费用总额
	
	private Date makeDate ;     //发生日期

	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	@Column(name ="BASE_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getBaseFeeCount() {
		return baseFeeCount;
	}

	public void setBaseFeeCount(java.math.BigDecimal baseFeeCount) {
		this.baseFeeCount = baseFeeCount;
	}
	@Column(name ="CONSUM_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getConsumFeeCount() {
		return consumFeeCount;
	}

	public void setConsumFeeCount(java.math.BigDecimal consumFeeCount) {
		this.consumFeeCount = consumFeeCount;
	}
	@Column(name ="TRAN_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getTranFeeCount() {
		return tranFeeCount;
	}

	public void setTranFeeCount(java.math.BigDecimal tranFeeCount) {
		this.tranFeeCount = tranFeeCount;
	}
	@Column(name ="VEHICLE_FEE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getVehicleFeeCount() {
		return vehicleFeeCount;
	}

	public void setVehicleFeeCount(java.math.BigDecimal vehicleFeeCount) {
		this.vehicleFeeCount = vehicleFeeCount;
	}
	@Column(name ="MARK_DATE",nullable=true)
	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}
	
	
	
}
