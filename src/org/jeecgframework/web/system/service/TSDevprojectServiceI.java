package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSDevprojectEntity;
import org.jeecgframework.web.system.pojo.base.TSDevprojectFilesEntity;


public interface TSDevprojectServiceI extends CommonService {

	 void deleteFile(TSDevprojectFilesEntity devprojectfile);

	 void deleteDevproject(TSDevprojectEntity devproject);
}
