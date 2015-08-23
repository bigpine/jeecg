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
import org.jeecgframework.poi.excel.annotation.Excel;


/**   
 * @Title: Entity
 * @Description: 公共项目管理
 * @author 刘大松
 * @date 2015-06-22 14:08:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_kfproject", schema = "")
@SuppressWarnings("serial")
public class TSKfprojectEntity implements Serializable {

	
	/**主键*/
	private String id;
	/**项目名称*/
	@Excel(name="项目名称")
	private String kfprojectName;
	/**项目负责人*/
	@Excel(name="项目负责人")
	private String kfprojectManager;
	/**项目开始日期*/
	private Date kfprojectStartDate;
	/**项目结束日期*/
	private Date kfprojectEndDate;
	
	/**项目状态*/
	@Excel(name="项目状态")
	private String kfprojectStatus;
	/**项目描述*/
	@Excel(name="项目描述")
	private String kfprojectDesc;
	/** 创建人名称 */
	@Excel(name="创建人")
	private String createName;
	/** 创建人登录名称 */
	private String createBy;
	/** 创建日期 */
	@Excel(name="创建日期")
	private Date createDate;
	/** 更新人名称 */
	private String updateName;
	/** 更新人登录名称 */
	private String updateBy;
	/** 更新日期 */
	private Date updateDate;
	@Excel(name="客户联系人")
	private String contactUser;//联系人
	@Excel(name="入库要求")
	private String rkRequire;//入库要求
	@Excel(name="出库要求")
	private String ckRequire;//出库要求
	@Excel(name="开票要求")
	private String kpRequire;//开票要求
	@Excel(name="装箱要求")
	private String zxRequire;//装箱要求
	
	
	private List<TSKfprojectFilesEntity> kfprojectFiles;

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
	 * @return the kfprojectName
	 */
	@Column(name ="KFPROJECT_NAME",nullable=false,length=50)
	public String getKfprojectName() {
		return kfprojectName;
	}

	/**
	 * @param kfprojectName the kfprojectName to set
	 */
	public void setKfprojectName(String kfprojectName) {
		this.kfprojectName = kfprojectName;
	}

	/**
	 * @return the kfprojectManager
	 */
	@Column(name ="KFPROJECT_MANAGER",nullable=true,length=50)
	public String getKfprojectManager() {
		return kfprojectManager;
	}

	/**
	 * @param kfprojectManager the kfprojectManager to set
	 */
	public void setKfprojectManager(String kfprojectManager) {
		this.kfprojectManager = kfprojectManager;
	}

	/**
	 * @return the kfprojectStartDate
	 */
	@Column(name ="KFPROJECT_START_DATE",nullable=true)
	public Date getKfprojectStartDate() {
		return kfprojectStartDate;
	}

	/**
	 * @param kfprojectStartDate the kfprojectStartDate to set
	 */
	public void setKfprojectStartDate(Date kfprojectStartDate) {
		this.kfprojectStartDate = kfprojectStartDate;
	}

	/**
	 * @return the kfprojectEndDate
	 */
	@Column(name ="KFPROJECT_END_DATE",nullable=true)
	public Date getKfprojectEndDate() {
		return kfprojectEndDate;
	}

	/**
	 * @param kfprojectEndDate the kfprojectEndDate to set
	 */
	public void setKfprojectEndDate(Date kfprojectEndDate) {
		this.kfprojectEndDate = kfprojectEndDate;
	}

	/**
	 * @return the kfprojectStatus
	 */
	@Column(name ="KFPROJECT_STATUS",nullable=true,length=50)
	public String getKfprojectStatus() {
		return kfprojectStatus;
	}

	/**
	 * @param kfprojectStatus the kfprojectStatus to set
	 */
	public void setKfprojectStatus(String kfprojectStatus) {
		this.kfprojectStatus = kfprojectStatus;
	}

	/**
	 * @return the kfprojectDesc
	 */
	@Column(name ="KFPROJECT_DESC",nullable=true)
	public String getKfprojectDesc() {
		return kfprojectDesc;
	}

	/**
	 * @param kfprojectDesc the kfprojectDesc to set
	 */
	public void setKfprojectDesc(String kfprojectDesc) {
		this.kfprojectDesc = kfprojectDesc;
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
	 * @return the kfprojectFiles
	 */
	@OneToMany(mappedBy="kfproject",cascade={CascadeType.REMOVE})
	public List<TSKfprojectFilesEntity> getKfprojectFiles() {
		return kfprojectFiles;
	}

	/**
	 * @param kfprojectFiles the kfprojectFiles to set
	 */
	public void setKfprojectFiles(List<TSKfprojectFilesEntity> kfprojectFiles) {
		this.kfprojectFiles = kfprojectFiles;
	}

	/**
	 * @return the contactUser
	 */
	@Column(name ="CONTACT_USER",nullable=true,length=255)
	public String getContactUser() {
		return contactUser;
	}

	/**
	 * @param contactUser the contactUser to set
	 */
	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	/**
	 * @return the rkRequire
	 */
	@Column(name ="RK_REQUIRE",nullable=true,length=255)
	public String getRkRequire() {
		return rkRequire;
	}

	/**
	 * @param rkRequire the rkRequire to set
	 */
	public void setRkRequire(String rkRequire) {
		this.rkRequire = rkRequire;
	}

	/**
	 * @return the ckRequire
	 */
	@Column(name ="CK_REQUIRE",nullable=true,length=255)
	public String getCkRequire() {
		return ckRequire;
	}

	/**
	 * @param ckRequire the ckRequire to set
	 */
	public void setCkRequire(String ckRequire) {
		this.ckRequire = ckRequire;
	}

	/**
	 * @return the kpRequire
	 */
	@Column(name ="KP_REQUIRE",nullable=true,length=255)
	public String getKpRequire() {
		return kpRequire;
	}

	/**
	 * @param kpRequire the kpRequire to set
	 */
	public void setKpRequire(String kpRequire) {
		this.kpRequire = kpRequire;
	}

	/**
	 * @return the zxRequire
	 */
	@Column(name ="ZX_REQUIRE",nullable=true,length=255)
	public String getZxRequire() {
		return zxRequire;
	}

	/**
	 * @param zxRequire the zxRequire to set
	 */
	public void setZxRequire(String zxRequire) {
		this.zxRequire = zxRequire;
	}
	
	
	
}
