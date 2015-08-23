package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 任务管理
 * @author 刘大松
 * @date 2015-06-22 16:08:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_taskInfo", schema = "")
@SuppressWarnings("serial")
public class TSTaskInfoEntity implements Serializable {

	/**主键*/
	private String id;
	/**任务名称*/
	private String taskName;
	/**任务负责人*/
	private String taskManager;
	/**任务开始日期*/
	private Date taskStartDate;
	/**任务结束日期*/
	private Date taskEndDate;
	/**任务计划完成日期*/
	private Date taskPlanDate;
	/**任务状态*/
	private String taskStatus;
	/**任务类型*/
	private String taskType;
	/**任务级别*/
	private String taskLevel;
	/**任务描述*/
	private String taskDesc;

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
	 * @return the taskName
	 */
	@Column(name ="TASK_NAME",nullable=false,length=50)
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the taskManager
	 */
	@Column(name ="TASK_MANAGER",nullable=true,length=50)
	public String getTaskManager() {
		return taskManager;
	}
	/**
	 * @param taskManager the taskManager to set
	 */
	public void setTaskManager(String taskManager) {
		this.taskManager = taskManager;
	}
	/**
	 * @return the taskStartDate
	 */
	@Column(name ="TASK_START_DATE",nullable=true)
	public Date getTaskStartDate() {
		return taskStartDate;
	}
	/**
	 * @param taskStartDate the taskStartDate to set
	 */
	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	/**
	 * @return the taskEndDate
	 */
	@Column(name ="TASK_END_DATE",nullable=true)
	public Date getTaskEndDate() {
		return taskEndDate;
	}
	/**
	 * @param taskEndDate the taskEndDate to set
	 */
	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	/**
	 * @return the taskPlanDate
	 */
	@Column(name ="TASK_PLAN_DATE",nullable=true)
	public Date getTaskPlanDate() {
		return taskPlanDate;
	}
	/**
	 * @param taskPlanDate the taskPlanDate to set
	 */
	public void setTaskPlanDate(Date taskPlanDate) {
		this.taskPlanDate = taskPlanDate;
	}
	/**
	 * @return the taskStatus
	 */
	@Column(name ="TASK_STATUS",nullable=true,length=50)
	public String getTaskStatus() {
		return taskStatus;
	}
	/**
	 * @param taskStatus the taskStatus to set
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	/**
	 * @return the taskType
	 */
	@Column(name ="TASK_TYPE",nullable=true,length=50)
	public String getTaskType() {
		return taskType;
	}
	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * @return the taskLevel
	 */
	@Column(name ="TASK_LEVEL",nullable=true,length=50)
	public String getTaskLevel() {
		return taskLevel;
	}
	/**
	 * @param taskLevel the taskLevel to set
	 */
	public void setTaskLevel(String taskLevel) {
		this.taskLevel = taskLevel;
	}
	/**
	 * @return the taskDesc
	 */
	@Column(name ="TASK_DESC",nullable=true,length=50)
	public String getTaskDesc() {
		return taskDesc;
	}
	/**
	 * @param taskDesc the taskDesc to set
	 */
	
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
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
	
}
