package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSKfprojectEntity;
import org.jeecgframework.web.system.pojo.base.TSKfprojectFilesEntity;

public interface TSKfprojectServiceI extends CommonService {
	
	void deleteFile(TSKfprojectFilesEntity projectfile);

	 void deleteKfproject(TSKfprojectEntity project);

}
