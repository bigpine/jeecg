package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TSDeliveryInfoServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsdeliveryInfoService")
@Transactional
public class TSDeliveryInfoServiceImpl extends CommonServiceImpl implements
		TSDeliveryInfoServiceI {

}
