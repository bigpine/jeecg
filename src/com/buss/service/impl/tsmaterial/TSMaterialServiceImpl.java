package com.buss.service.impl.tsmaterial;
import com.buss.service.tsmaterial.TSMaterialServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.entity.tsmaterial.TSMaterialEntity;
import com.buss.entity.tsmaterialinfo.TSMaterialinfoEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("tSMaterialService")
@Transactional
public class TSMaterialServiceImpl extends CommonServiceImpl implements TSMaterialServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((TSMaterialEntity)entity);
 	}
	
	public void addMain(TSMaterialEntity tSMaterial,
	        List<TSMaterialinfoEntity> tSMaterialinfoList){
			//保存主信息
			this.save(tSMaterial);
		
			/**保存-耗材费用管理*/
			for(TSMaterialinfoEntity tSMaterialinfo:tSMaterialinfoList){
				//外键设置
				tSMaterialinfo.setMaterialId(tSMaterial.getId());
				this.save(tSMaterialinfo);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(tSMaterial);
	}

	
	public void updateMain(TSMaterialEntity tSMaterial,
	        List<TSMaterialinfoEntity> tSMaterialinfoList) {
		//保存主表信息
		this.saveOrUpdate(tSMaterial);
		//===================================================================================
		//获取参数
		Object id0 = tSMaterial.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-耗材费用管理
	    String hql0 = "from TSMaterialinfoEntity where 1 = 1 AND mATERIAL_ID = ? ";
	    List<TSMaterialinfoEntity> tSMaterialinfoOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-耗材费用管理
		for(TSMaterialinfoEntity oldE:tSMaterialinfoOldList){
			boolean isUpdate = false;
				for(TSMaterialinfoEntity sendE:tSMaterialinfoList){
					//需要更新的明细数据-耗材费用管理
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-耗材费用管理
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-耗材费用管理
			for(TSMaterialinfoEntity tSMaterialinfo:tSMaterialinfoList){
				if(oConvertUtils.isEmpty(tSMaterialinfo.getId())){
					//外键设置
					tSMaterialinfo.setMaterialId(tSMaterial.getId());
					this.save(tSMaterialinfo);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(tSMaterial);
	}

	
	public void delMain(TSMaterialEntity tSMaterial) {
		//删除主表信息
		this.delete(tSMaterial);
		//===================================================================================
		//获取参数
		Object id0 = tSMaterial.getId();
		//===================================================================================
		//删除-耗材费用管理
	    String hql0 = "from TSMaterialinfoEntity where 1 = 1 AND mATERIAL_ID = ? ";
	    List<TSMaterialinfoEntity> tSMaterialinfoOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(tSMaterialinfoOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TSMaterialEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TSMaterialEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TSMaterialEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,TSMaterialEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{item_name}",String.valueOf(t.getItemName()));
 		sql  = sql.replace("#{item_detail}",String.valueOf(t.getItemDetail()));
 		sql  = sql.replace("#{standard}",String.valueOf(t.getStandard()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{supplier}",String.valueOf(t.getSupplier()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}