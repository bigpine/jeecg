package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSTaskInfoServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tstaskInfoService")
@Transactional
public class TSTaskInfoServiceImpl extends CommonServiceImpl implements
		TSTaskInfoServiceI {

}
