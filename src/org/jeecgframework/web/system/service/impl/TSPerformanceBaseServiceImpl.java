package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSPerformanceBaseServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsperformanceBaseService")
@Transactional
public class TSPerformanceBaseServiceImpl extends CommonServiceImpl implements
		TSPerformanceBaseServiceI {

}
