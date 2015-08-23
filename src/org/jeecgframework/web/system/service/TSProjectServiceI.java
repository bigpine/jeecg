package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSProjectEntity;
import org.jeecgframework.web.system.pojo.base.TSProjectFilesEntity;

public interface TSProjectServiceI extends CommonService {


	 void deleteFile(TSProjectFilesEntity projectfile);

	 void deleteProject(TSProjectEntity project);
}
