package org.jeecgframework.web.system.pojo.base;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.IdEntity;

@Entity
@Table(name = "t_s_performance_user")
public class TSPerformanceUser extends IdEntity implements java.io.Serializable {
	
	private TSUser user;
	
	private TSPerformanceEntity performance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
	public TSUser getUser() {
		return user;
	}

	public void setUser(TSUser user) {
		this.user = user;
	}

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "performance_id")
	public TSPerformanceEntity getPerformance() {
		return performance;
	}

	public void setPerformance(TSPerformanceEntity performance) {
		this.performance = performance;
	}
	
}
