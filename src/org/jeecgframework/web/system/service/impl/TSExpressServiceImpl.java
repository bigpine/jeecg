package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSExpressServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsexpressService")
@Transactional
public class TSExpressServiceImpl extends CommonServiceImpl implements
		TSExpressServiceI {

}
