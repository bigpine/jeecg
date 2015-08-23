package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSBaseFeeServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsbasefeeService")
@Transactional
public class TSBaseFeeServiceImpl extends CommonServiceImpl implements
		TSBaseFeeServiceI {

}
