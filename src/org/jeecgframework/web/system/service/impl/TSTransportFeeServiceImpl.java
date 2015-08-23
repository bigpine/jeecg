package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSTransportFeeServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tstransportfeeService")
@Transactional
public class TSTransportFeeServiceImpl extends CommonServiceImpl implements
		TSTransportFeeServiceI {

}
