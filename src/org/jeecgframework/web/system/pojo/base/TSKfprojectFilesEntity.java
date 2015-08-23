package org.jeecgframework.web.system.pojo.base;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_s_kfproject_files", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class TSKfprojectFilesEntity extends TSAttachment implements
		Serializable {
	
	private TSKfprojectEntity kfproject;

	/**
	 * @return the kfproject
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "kfprojectId")
	public TSKfprojectEntity getKfproject() {
		return kfproject;
	}

	/**
	 * @param kfproject the kfproject to set
	 */
	public void setKfproject(TSKfprojectEntity kfproject) {
		this.kfproject = kfproject;
	}
	

}
