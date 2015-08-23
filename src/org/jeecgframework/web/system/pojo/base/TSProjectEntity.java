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
 * @Description: 公共项目管理
 * @author 刘大松
 * @date 2015-06-21 23:08:04
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_s_project", schema = "")
@SuppressWarnings("serial")
public class TSProjectEntity implements Serializable {

	/** 主键 */
	private String id;
	/** 项目名称 */
	private String projectName;
	/** 项目负责人 */
	private String projectManager;
	/** 项目开始日期 */
	private Date projectStartDate;
	/** 项目结束日期 */
	private Date projectEndDate;
	/** 项目状态 */
	private String projectStatus;
	/** 项目描述 */
	private String projectDesc;

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

	private List<TSProjectFilesEntity> projectFiles;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 32)
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the projectName
	 */
	@Column(name = "PROJECT_NAME", nullable = false, length = 50)
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectManager
	 */
	@Column(name = "PROJECT_MANAGER", nullable = true, length = 50)
	public String getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager
	 *            the projectManager to set
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the projectStartDate
	 */
	@Column(name = "PROJECT_START_DATE", nullable = true)
	public Date getProjectStartDate() {
		return projectStartDate;
	}

	/**
	 * @param projectStartDate
	 *            the projectStartDate to set
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * @return the projectEndDate
	 */
	@Column(name = "PROJECT_END_DATE", nullable = true)
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	/**
	 * @param projectEndDate
	 *            the projectEndDate to set
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	/**
	 * @return the projectStatus
	 */
	@Column(name = "PROJECT_STATUS", nullable = true, length = 50)
	public String getProjectStatus() {
		return projectStatus;
	}

	/**
	 * @param projectStatus
	 *            the projectStatus to set
	 */
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	/**
	 * @return the projectDesc
	 */
	@Column(name = "PROJECT_DESC", nullable = true)
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * @param projectDesc
	 *            the projectDesc to set
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	@Column(name = "CREATE_NAME", nullable = true)
	public String getCreateName() {
		return createName;
	}

	/**
	 * @param createUser
	 *            the createUser to set
	 */
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

	@Column(name = "UPDATE_BY", nullable = true)
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param createUser
	 *            the createUser to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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

	@Column(name = "UPDATE_DATE", nullable = true)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the projectFiles
	 */
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE })
	public List<TSProjectFilesEntity> getProjectFiles() {
		return projectFiles;
	}

	/**
	 * @param projectFiles
	 *            the projectFiles to set
	 */
	public void setProjectFiles(List<TSProjectFilesEntity> projectFiles) {
		this.projectFiles = projectFiles;
	}

}
