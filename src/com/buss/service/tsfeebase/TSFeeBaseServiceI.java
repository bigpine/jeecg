package com.buss.service.tsfeebase;
import com.buss.entity.tsfeebase.TSFeeBaseEntity;
import com.buss.entity.tscarriagefee.TSCarriageFeeEntity;
import com.buss.entity.tsvehiclefee.TSVehicleFeeEntity;
import com.buss.entity.tsmaterialfee.TSMaterialFeeEntity;
import com.buss.entity.tsfeedaily.TSFeeDailyEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface TSFeeBaseServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(TSFeeBaseEntity tSFeeBase,
	        List<TSCarriageFeeEntity> tSCarriageFeeList,List<TSVehicleFeeEntity> tSVehicleFeeList,List<TSMaterialFeeEntity> tSMaterialFeeList,List<TSFeeDailyEntity> tSFeeDailyList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(TSFeeBaseEntity tSFeeBase,
	        List<TSCarriageFeeEntity> tSCarriageFeeList,List<TSVehicleFeeEntity> tSVehicleFeeList,List<TSMaterialFeeEntity> tSMaterialFeeList,List<TSFeeDailyEntity> tSFeeDailyList);
	public void delMain (TSFeeBaseEntity tSFeeBase);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TSFeeBaseEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TSFeeBaseEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TSFeeBaseEntity t);
}
