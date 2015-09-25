package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**   
 * @Title: Entity
 * @Description: 开发项目管理
 * @author 刘大松
 * @date 2015-06-22 13:08:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_devproject", schema = "")
@SuppressWarnings("serial")
public class TSDevprojectEntity implements Serializable {

	/**主键*/
	private String id;
	/**项目名称*/
	private String devprojectName;
	/**项目负责人*/
	private String devprojectManager;
	/**项目开始日期*/
	private Date devprojectStartDate;
	/**项目结束日期*/
	private Date devprojectEndDate;
	/**项目状态*/
	private String devprojectStatus;
	/**项目描述*/
	private String devprojectDesc;
	/** 创建人名称 */
	private String createName;
	/** 创建人登录名称 */
	private String createBy;
	/** 创建日期 */
	private Date createDate;
	/** 更新人名称 */
	private String updateName;
	/** 更新人登录名称 */
	private String updateBy;
	/** 更新日期 */
	private Date updateDate;
	
	private String level;//重要级别
	
	private String subStatus;//用户提交状态
	
	private String feedback;//责任人反馈意见
	
	private Date planCompleteDate; //计划完成日期
	private List<TSDevprojectFilesEntity> devprojectFiles;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the devprojectName
	 */
	@Column(name ="DEVPROJECT_NAME",nullable=false,length=50)
	public String getDevprojectName() {
		return devprojectName;
	}

	/**
	 * @param devprojectName the devprojectName to set
	 */
	public void setDevprojectName(String devprojectName) {
		this.devprojectName = devprojectName;
	}

	/**
	 * @return the devprojectManager
	 */
	@Column(name ="DEVPROJECT_MANAGER",nullable=true,length=50)
	public String getDevprojectManager() {
		return devprojectManager;
	}

	/**
	 * @param devprojectManager the devprojectManager to set
	 */
	public void setDevprojectManager(String devprojectManager) {
		this.devprojectManager = devprojectManager;
	}

	/**
	 * @return the devprojectStartDate
	 */
	@Column(name ="DEVPROJECT_START_DATE",nullable=true)
	public Date getDevprojectStartDate() {
		return devprojectStartDate;
	}

	/**
	 * @param devprojectStartDate the devprojectStartDate to set
	 */
	public void setDevprojectStartDate(Date devprojectStartDate) {
		this.devprojectStartDate = devprojectStartDate;
	}

	/**
	 * @return the devprojectEndDate
	 */
	@Column(name ="DEVPROJECT_END_DATE",nullable=true)
	public Date getDevprojectEndDate() {
		return devprojectEndDate;
	}

	/**
	 * @param devprojectEndDate the devprojectEndDate to set
	 */
	public void setDevprojectEndDate(Date devprojectEndDate) {
		this.devprojectEndDate = devprojectEndDate;
	}

	/**
	 * @return the devprojectStatus
	 */
	@Column(name ="DEVPROJECT_STATUS",nullable=true,length=50)
	public String getDevprojectStatus() {
		return devprojectStatus;
	}

	/**
	 * @param devprojectStatus the devprojectStatus to set
	 */
	public void setDevprojectStatus(String devprojectStatus) {
		this.devprojectStatus = devprojectStatus;
	}

	/**
	 * @return the devprojectDesc
	 */
	@Column(name ="DEVPROJECT_DESC",nullable=true)
	public String getDevprojectDesc() {
		return devprojectDesc;
	}

	/**
	 * @param devprojectDesc the devprojectDesc to set
	 */
	public void setDevprojectDesc(String devprojectDesc) {
		this.devprojectDesc = devprojectDesc;
	}
	@Column(name ="CREATE_NAME",nullable=true)
	public String getCreateName() {
		return createName;
	}


	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	@Column(name ="CREATE_BY",nullable=true)
	public String getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Column(name ="UPDATE_BY",nullable=true)
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * @param createUser the createUser to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Column(name ="CREATE_DATE",nullable=true)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	@Column(name ="UPDATE_NAME",nullable=true)
	public String getUpdateName() {
		return updateName;
	}

	
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	
	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the devprojectFiles
	 */
	@OneToMany(mappedBy="devproject",cascade={CascadeType.REMOVE})
	public List<TSDevprojectFilesEntity> getDevprojectFiles() {
		return devprojectFiles;
	}

	/**
	 * @param devprojectFiles the devprojectFiles to set
	 */
	public void setDevprojectFiles(List<TSDevprojectFilesEntity> devprojectFiles) {
		this.devprojectFiles = devprojectFiles;
	}
	@Column(name ="LEVEL",nullable=true)
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name ="SUB_STATUS",nullable=true)
	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	@Column(name ="FEED_BACK",nullable=true)
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Column(name ="PLAN_COMPLETE_DATE",nullable=true)
	public Date getPlanCompleteDate() {
		return planCompleteDate;
	}

	public void setPlanCompleteDate(Date planCompleteDate) {
		this.planCompleteDate = planCompleteDate;
	}
	
	
}
