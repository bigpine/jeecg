package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_s_performance")
@SuppressWarnings("serial")
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class TSPerformanceEntity implements Serializable {

	
	private String id;   //ID主键
	private TSDepart depart;
	private TSUser user;  //员工姓名
	private String departName; //所属部门
	private String position;   //职责
	private String realName;  //真实姓名
	private TSPerformanceBaseEntity performanceBaseEntity;
	private String performanceDesc; //绩效描述
	private java.math.BigDecimal score; //分值
	private Date markDate; //发生日期
	private String subStatus;  //提交状态
	private String checkStatus; //审核状态
	private String checkDesc;  //审核内容
	private String perforName;
	private String perforType;
	private String perforDetail;
	private String email;
	private String createName; 
	private String createBy;
	private Date createDate;
	private String updateName;
	private String updateBy;
	private Date updateDate;
	private String isTrue; //是否外部投诉
	private String isRecode; //是否记过
	
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
	@Column(name = "POSITION", nullable = false)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Column(name = "MARK_DATE", nullable = false)
	public Date getMarkDate() {
		return markDate;
	}
	public void setMarkDate(Date markDate) {
		this.markDate = markDate;
	}
	
	@Column(name = "SUB_STATUS", nullable = false)
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	@Column(name = "CHECK_STATUS", nullable = false)
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	@Column(name = "CHECK_DESC", nullable = false)
	public String getCheckDesc() {
		return checkDesc;
	}
	public void setCheckDesc(String checkDesc) {
		this.checkDesc = checkDesc;
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
	@Column(name = "PERFORMANCE_NAME", nullable = true)
	public String getPerforName() {
		return perforName;
	}
	public void setPerforName(String perforName) {
		this.perforName = perforName;
	}
	@Column(name = "PERFORMANCE_TYPE", nullable = true)
	public String getPerforType() {
		return perforType;
	}
	public void setPerforType(String perforType) {
		this.perforType = perforType;
	}
	@Column(name = "PERFORMANCE_DETAIL", nullable = true)
	public String getPerforDetail() {
		return perforDetail;
	}
	public void setPerforDetail(String perforDetail) {
		this.perforDetail = perforDetail;
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=TSPerformanceBaseEntity.class )
    @JoinColumn(name="performanceBase_id")
	public TSPerformanceBaseEntity getPerformanceBaseEntity() {
		return performanceBaseEntity;
	}
	public void setPerformanceBaseEntity(
			TSPerformanceBaseEntity performanceBaseEntity) {
		this.performanceBaseEntity = performanceBaseEntity;
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=TSUser.class )
    @JoinColumn(name="user_id")
	public TSUser getUser() {
		return user;
	}
	public void setUser(TSUser user) {
		this.user = user;
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=TSDepart.class )
    @JoinColumn(name="depart_id")
	public TSDepart getDepart() {
		return depart;
	}
	public void setDepart(TSDepart depart) {
		this.depart = depart;
	}
	@Column(name = "DEPART_NAME", nullable = true)
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	@Column(name = "PERFORMANCE_DESC", nullable = true)
	public String getPerformanceDesc() {
		return performanceDesc;
	}
	public void setPerformanceDesc(String performanceDesc) {
		this.performanceDesc = performanceDesc;
	}
	@Column(name ="SCORE",nullable=true,scale=2,length=10)
	public java.math.BigDecimal getScore() {
		return score;
	}
	public void setScore(java.math.BigDecimal score) {
		this.score = score;
	}
	@Column(name = "REAL_NAME", nullable = true)
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Column(name = "EMAIL", nullable = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "IS_TRUE", nullable = true)
	public String getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}
	@Column(name = "IS_RECODE", nullable = true)
	public String getIsRecode() {
		return isRecode;
	}
	public void setIsRecode(String isRecode) {
		this.isRecode = isRecode;
	}
	
	
}
