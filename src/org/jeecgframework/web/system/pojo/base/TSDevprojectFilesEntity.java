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
 * @Description: 开发项目管理附件
 * @author 刘大松
 * @date 2015-06-22 13:32:04
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_s_devproject_files", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class TSDevprojectFilesEntity extends TSAttachment implements
		Serializable {
	
	private TSDevprojectEntity devproject;

	/**
	 * @return the devproject
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "devprojectId")
	public TSDevprojectEntity getDevproject() {
		return devproject;
	}

	/**
	 * @param devproject the devproject to set
	 */
	public void setDevproject(TSDevprojectEntity devproject) {
		this.devproject = devproject;
	}

}
