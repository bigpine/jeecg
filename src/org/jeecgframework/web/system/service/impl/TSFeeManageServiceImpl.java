package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSFeeManageServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsfeemanageService")
@Transactional
public class TSFeeManageServiceImpl extends CommonServiceImpl implements
		TSFeeManageServiceI {

}
