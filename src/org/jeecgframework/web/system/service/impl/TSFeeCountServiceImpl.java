package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSFeeCountServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsfeecountService")
@Transactional
public class TSFeeCountServiceImpl extends CommonServiceImpl implements
		TSFeeCountServiceI {

}
