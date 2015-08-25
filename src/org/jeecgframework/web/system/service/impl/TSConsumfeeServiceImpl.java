package org.jeecgframework.web.system.service.impl;

import java.util.List;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.pojo.base.TSConsumfeeEntity;
import org.jeecgframework.web.system.service.TSConsumfeeServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("tsconsumfeeService")
@Transactional
public class TSConsumfeeServiceImpl extends CommonServiceImpl implements
		TSConsumfeeServiceI {

	/*@Override
	public List<TSConsumfeeEntity> getDetail(String itemName) {
		String hql = "select * from TSConsumfee where itemName = '"+itemName+"'";
		return commonDao.findByQueryString(hql);
	}
*/
}
