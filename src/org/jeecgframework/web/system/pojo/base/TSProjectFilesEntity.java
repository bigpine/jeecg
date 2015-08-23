package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @Title: Entity
 * @Description: 公共项目管理附件
 * @author 刘大松
 * @date 2015-06-21 23:32:04
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_s_project_files", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class TSProjectFilesEntity extends TSAttachment implements Serializable {

	
	private TSProjectEntity project;

	/**
	 * @return the project
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId")
	public TSProjectEntity getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(TSProjectEntity project) {
		this.project = project;
	}

}
