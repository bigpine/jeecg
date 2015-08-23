package com.buss.service.tsmaterial;
import com.buss.entity.tsmaterial.TSMaterialEntity;
import com.buss.entity.tsmaterialinfo.TSMaterialinfoEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface TSMaterialServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(TSMaterialEntity tSMaterial,
	        List<TSMaterialinfoEntity> tSMaterialinfoList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(TSMaterialEntity tSMaterial,
	        List<TSMaterialinfoEntity> tSMaterialinfoList);
	public void delMain (TSMaterialEntity tSMaterial);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TSMaterialEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TSMaterialEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TSMaterialEntity t);
}
