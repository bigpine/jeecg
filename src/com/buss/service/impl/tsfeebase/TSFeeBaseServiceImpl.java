package com.buss.service.impl.tsfeebase;
import com.buss.service.tsfeebase.TSFeeBaseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.entity.tsfeebase.TSFeeBaseEntity;
import com.buss.entity.tscarriagefee.TSCarriageFeeEntity;
import com.buss.entity.tsvehiclefee.TSVehicleFeeEntity;
import com.buss.entity.tsmaterialfee.TSMaterialFeeEntity;
import com.buss.entity.tsfeedaily.TSFeeDailyEntity;

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


@Service("tSFeeBaseService")
@Transactional
public class TSFeeBaseServiceImpl extends CommonServiceImpl implements TSFeeBaseServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((TSFeeBaseEntity)entity);
 	}
	
	public void addMain(TSFeeBaseEntity tSFeeBase,
	        List<TSCarriageFeeEntity> tSCarriageFeeList,List<TSVehicleFeeEntity> tSVehicleFeeList,List<TSMaterialFeeEntity> tSMaterialFeeList,List<TSFeeDailyEntity> tSFeeDailyList){
			//保存主信息
			this.save(tSFeeBase);
		
			/**保存-运输费用管理*/
			for(TSCarriageFeeEntity tSCarriageFee:tSCarriageFeeList){
				//外键设置
				tSCarriageFee.setFeeId(tSFeeBase.getId());
				this.save(tSCarriageFee);
			}
			/**保存-车辆费用管理*/
			for(TSVehicleFeeEntity tSVehicleFee:tSVehicleFeeList){
				//外键设置
				tSVehicleFee.setFeeId(tSFeeBase.getId());
				this.save(tSVehicleFee);
			}
			/**保存-耗材费用管理*/
			for(TSMaterialFeeEntity tSMaterialFee:tSMaterialFeeList){
				//外键设置
				tSMaterialFee.setFeeId(tSFeeBase.getId());
				this.save(tSMaterialFee);
			}
			/**保存-日常费用管理*/
			for(TSFeeDailyEntity tSFeeDaily:tSFeeDailyList){
				//外键设置
				tSFeeDaily.setFeeId(tSFeeBase.getId());
				this.save(tSFeeDaily);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(tSFeeBase);
	}

	
	public void updateMain(TSFeeBaseEntity tSFeeBase,
	        List<TSCarriageFeeEntity> tSCarriageFeeList,List<TSVehicleFeeEntity> tSVehicleFeeList,List<TSMaterialFeeEntity> tSMaterialFeeList,List<TSFeeDailyEntity> tSFeeDailyList) {
		//保存主表信息
		this.saveOrUpdate(tSFeeBase);
		//===================================================================================
		//获取参数
		Object id0 = tSFeeBase.getId();
		Object id1 = tSFeeBase.getId();
		Object id2 = tSFeeBase.getId();
		Object id3 = tSFeeBase.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-运输费用管理
	    String hql0 = "from TSCarriageFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSCarriageFeeEntity> tSCarriageFeeOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-运输费用管理
		for(TSCarriageFeeEntity oldE:tSCarriageFeeOldList){
			boolean isUpdate = false;
				for(TSCarriageFeeEntity sendE:tSCarriageFeeList){
					//需要更新的明细数据-运输费用管理
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-运输费用管理
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-运输费用管理
			for(TSCarriageFeeEntity tSCarriageFee:tSCarriageFeeList){
				if(oConvertUtils.isEmpty(tSCarriageFee.getId())){
					//外键设置
					tSCarriageFee.setFeeId(tSFeeBase.getId());
					this.save(tSCarriageFee);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-车辆费用管理
	    String hql1 = "from TSVehicleFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSVehicleFeeEntity> tSVehicleFeeOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-车辆费用管理
		for(TSVehicleFeeEntity oldE:tSVehicleFeeOldList){
			boolean isUpdate = false;
				for(TSVehicleFeeEntity sendE:tSVehicleFeeList){
					//需要更新的明细数据-车辆费用管理
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-车辆费用管理
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-车辆费用管理
			for(TSVehicleFeeEntity tSVehicleFee:tSVehicleFeeList){
				if(oConvertUtils.isEmpty(tSVehicleFee.getId())){
					//外键设置
					tSVehicleFee.setFeeId(tSFeeBase.getId());
					this.save(tSVehicleFee);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-耗材费用管理
	    String hql2 = "from TSMaterialFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSMaterialFeeEntity> tSMaterialFeeOldList = this.findHql(hql2,id2);
		//2.筛选更新明细数据-耗材费用管理
		for(TSMaterialFeeEntity oldE:tSMaterialFeeOldList){
			boolean isUpdate = false;
				for(TSMaterialFeeEntity sendE:tSMaterialFeeList){
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
			for(TSMaterialFeeEntity tSMaterialFee:tSMaterialFeeList){
				if(oConvertUtils.isEmpty(tSMaterialFee.getId())){
					//外键设置
					tSMaterialFee.setFeeId(tSFeeBase.getId());
					this.save(tSMaterialFee);
				}
			}
		//===================================================================================
		//1.查询出数据库的明细数据-日常费用管理
	    String hql3 = "from TSFeeDailyEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSFeeDailyEntity> tSFeeDailyOldList = this.findHql(hql3,id3);
		//2.筛选更新明细数据-日常费用管理
		for(TSFeeDailyEntity oldE:tSFeeDailyOldList){
			boolean isUpdate = false;
				for(TSFeeDailyEntity sendE:tSFeeDailyList){
					//需要更新的明细数据-日常费用管理
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-日常费用管理
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-日常费用管理
			for(TSFeeDailyEntity tSFeeDaily:tSFeeDailyList){
				if(oConvertUtils.isEmpty(tSFeeDaily.getId())){
					//外键设置
					tSFeeDaily.setFeeId(tSFeeBase.getId());
					this.save(tSFeeDaily);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(tSFeeBase);
	}

	
	public void delMain(TSFeeBaseEntity tSFeeBase) {
		//删除主表信息
		this.delete(tSFeeBase);
		//===================================================================================
		//获取参数
		Object id0 = tSFeeBase.getId();
		Object id1 = tSFeeBase.getId();
		Object id2 = tSFeeBase.getId();
		Object id3 = tSFeeBase.getId();
		//===================================================================================
		//删除-运输费用管理
	    String hql0 = "from TSCarriageFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSCarriageFeeEntity> tSCarriageFeeOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(tSCarriageFeeOldList);
		//===================================================================================
		//删除-车辆费用管理
	    String hql1 = "from TSVehicleFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSVehicleFeeEntity> tSVehicleFeeOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(tSVehicleFeeOldList);
		//===================================================================================
		//删除-耗材费用管理
	    String hql2 = "from TSMaterialFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSMaterialFeeEntity> tSMaterialFeeOldList = this.findHql(hql2,id2);
		this.deleteAllEntitie(tSMaterialFeeOldList);
		//===================================================================================
		//删除-日常费用管理
	    String hql3 = "from TSFeeDailyEntity where 1 = 1 AND fEE_ID = ? ";
	    List<TSFeeDailyEntity> tSFeeDailyOldList = this.findHql(hql3,id3);
		this.deleteAllEntitie(tSFeeDailyOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(TSFeeBaseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(TSFeeBaseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(TSFeeBaseEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,TSFeeBaseEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{fee_type}",String.valueOf(t.getFeeType()));
 		sql  = sql.replace("#{fee_fieds}",String.valueOf(t.getFeeFieds()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}