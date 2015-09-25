package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSPerformanceServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsperformanceService")
@Transactional
public class TSPerformanceServiceImpl extends CommonServiceImpl implements
		TSPerformanceServiceI {

}
