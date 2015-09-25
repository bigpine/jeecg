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
@Table(name="t_s_performance_base")
@SuppressWarnings("serial")
public class TSPerformanceBaseEntity implements Serializable {

	private String id; //ID主键
	private String perforName; //绩效名称
	private String perforType; //绩效类别
	private String perforDetail; //绩效明细
	private java.math.BigDecimal score ; //绩效分值
	private String createName; //创建人
	private String createBy;  //
	private Date createDate; //创建日期
	private String updateName; //修改人
	private String updateBy;
	private Date updateDate;  //修改日期
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "PERFOR_NAME", nullable = false)
	public String getPerforName() {
		return perforName;
	}
	public void setPerforName(String perforName) {
		this.perforName = perforName;
	}
	@Column(name = "PERFOR_TYPE", nullable = false)
	public String getPerforType() {
		return perforType;
	}
	public void setPerforType(String perforType) {
		this.perforType = perforType;
	}
	@Column(name = "PERFOR_DETAIL", nullable = false)
	public String getPerforDetail() {
		return perforDetail;
	}
	public void setPerforDetail(String perforDetail) {
		this.perforDetail = perforDetail;
	}
	@Column(name ="SCORE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getScore() {
		return score;
	}
	public void setScore(java.math.BigDecimal score) {
		this.score = score;
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
