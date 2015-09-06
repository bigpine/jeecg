package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSConsumbaseServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsconsumbaseService")
@Transactional
public class TSConsumbaseServiceImpl extends CommonServiceImpl implements
		TSConsumbaseServiceI {

}
