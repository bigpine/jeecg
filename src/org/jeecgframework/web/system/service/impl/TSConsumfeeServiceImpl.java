package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSConsumfeeServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsconsumfeeService")
@Transactional
public class TSConsumfeeServiceImpl extends CommonServiceImpl implements
		TSConsumfeeServiceI {

}
