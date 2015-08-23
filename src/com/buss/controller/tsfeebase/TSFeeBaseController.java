package com.buss.controller.tsfeebase;
import com.buss.entity.tsfeebase.TSFeeBaseEntity;
import com.buss.service.tsfeebase.TSFeeBaseServiceI;
import com.buss.page.tsfeebase.TSFeeBasePage;
import com.buss.entity.tscarriagefee.TSCarriageFeeEntity;
import com.buss.entity.tsvehiclefee.TSVehicleFeeEntity;
import com.buss.entity.tsmaterialfee.TSMaterialFeeEntity;
import com.buss.entity.tsfeedaily.TSFeeDailyEntity;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;


/**   
 * @Title: Controller
 * @Description: 费用基础信息
 * @author onlineGenerator
 * @date 2015-08-20 13:59:07
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/tSFeeBaseController")
public class TSFeeBaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSFeeBaseController.class);

	@Autowired
	private TSFeeBaseServiceI tSFeeBaseService;
	@Autowired
	private SystemService systemService;


	/**
	 * 费用基础信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSFeeBase")
	public ModelAndView tSFeeBase(HttpServletRequest request) {
		return new ModelAndView("com/buss/tsfeebase/tSFeeBaseList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TSFeeBaseEntity tSFeeBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSFeeBaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSFeeBase);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSFeeBaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除费用基础信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSFeeBaseEntity tSFeeBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tSFeeBase = systemService.getEntity(TSFeeBaseEntity.class, tSFeeBase.getId());
		String message = "费用基础信息删除成功";
		try{
			tSFeeBaseService.delMain(tSFeeBase);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用基础信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除费用基础信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "费用基础信息删除成功";
		try{
			for(String id:ids.split(",")){
				TSFeeBaseEntity tSFeeBase = systemService.getEntity(TSFeeBaseEntity.class,
				id
				);
				tSFeeBaseService.delMain(tSFeeBase);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用基础信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加费用基础信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSFeeBaseEntity tSFeeBase,TSFeeBasePage tSFeeBasePage, HttpServletRequest request) {
		List<TSCarriageFeeEntity> tSCarriageFeeList =  tSFeeBasePage.getTSCarriageFeeList();
		List<TSVehicleFeeEntity> tSVehicleFeeList =  tSFeeBasePage.getTSVehicleFeeList();
		List<TSMaterialFeeEntity> tSMaterialFeeList =  tSFeeBasePage.getTSMaterialFeeList();
		List<TSFeeDailyEntity> tSFeeDailyList =  tSFeeBasePage.getTSFeeDailyList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			tSFeeBaseService.addMain(tSFeeBase, tSCarriageFeeList,tSVehicleFeeList,tSMaterialFeeList,tSFeeDailyList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用基础信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新费用基础信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSFeeBaseEntity tSFeeBase,TSFeeBasePage tSFeeBasePage, HttpServletRequest request) {
		List<TSCarriageFeeEntity> tSCarriageFeeList =  tSFeeBasePage.getTSCarriageFeeList();
		List<TSVehicleFeeEntity> tSVehicleFeeList =  tSFeeBasePage.getTSVehicleFeeList();
		List<TSMaterialFeeEntity> tSMaterialFeeList =  tSFeeBasePage.getTSMaterialFeeList();
		List<TSFeeDailyEntity> tSFeeDailyList =  tSFeeBasePage.getTSFeeDailyList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			tSFeeBaseService.updateMain(tSFeeBase, tSCarriageFeeList,tSVehicleFeeList,tSMaterialFeeList,tSFeeDailyList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新费用基础信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 费用基础信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSFeeBaseEntity tSFeeBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSFeeBase.getId())) {
			tSFeeBase = tSFeeBaseService.getEntity(TSFeeBaseEntity.class, tSFeeBase.getId());
			req.setAttribute("tSFeeBasePage", tSFeeBase);
		}
		return new ModelAndView("com/buss/tsfeebase/tSFeeBase-add");
	}
	
	/**
	 * 费用基础信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSFeeBaseEntity tSFeeBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSFeeBase.getId())) {
			tSFeeBase = tSFeeBaseService.getEntity(TSFeeBaseEntity.class, tSFeeBase.getId());
			req.setAttribute("tSFeeBasePage", tSFeeBase);
		}
		return new ModelAndView("com/buss/tsfeebase/tSFeeBase-update");
	}
	
	
	/**
	 * 加载明细列表[运输费用管理]
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSCarriageFeeList")
	public ModelAndView tSCarriageFeeList(TSFeeBaseEntity tSFeeBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = tSFeeBase.getId();
		//===================================================================================
		//查询-运输费用管理
	    String hql0 = "from TSCarriageFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    try{
	    	List<TSCarriageFeeEntity> tSCarriageFeeEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("tSCarriageFeeList", tSCarriageFeeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/tscarriagefee/tSCarriageFeeList");
	}
	/**
	 * 加载明细列表[车辆费用管理]
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSVehicleFeeList")
	public ModelAndView tSVehicleFeeList(TSFeeBaseEntity tSFeeBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id1 = tSFeeBase.getId();
		//===================================================================================
		//查询-车辆费用管理
	    String hql1 = "from TSVehicleFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    try{
	    	List<TSVehicleFeeEntity> tSVehicleFeeEntityList = systemService.findHql(hql1,id1);
			req.setAttribute("tSVehicleFeeList", tSVehicleFeeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/tsvehiclefee/tSVehicleFeeList");
	}
	/**
	 * 加载明细列表[耗材费用管理]
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSMaterialFeeList")
	public ModelAndView tSMaterialFeeList(TSFeeBaseEntity tSFeeBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id2 = tSFeeBase.getId();
		//===================================================================================
		//查询-耗材费用管理
	    String hql2 = "from TSMaterialFeeEntity where 1 = 1 AND fEE_ID = ? ";
	    try{
	    	List<TSMaterialFeeEntity> tSMaterialFeeEntityList = systemService.findHql(hql2,id2);
			req.setAttribute("tSMaterialFeeList", tSMaterialFeeEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/tsmaterialfee/tSMaterialFeeList");
	}
	/**
	 * 加载明细列表[日常费用管理]
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSFeeDailyList")
	public ModelAndView tSFeeDailyList(TSFeeBaseEntity tSFeeBase, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id3 = tSFeeBase.getId();
		//===================================================================================
		//查询-日常费用管理
	    String hql3 = "from TSFeeDailyEntity where 1 = 1 AND fEE_ID = ? ";
	    try{
	    	List<TSFeeDailyEntity> tSFeeDailyEntityList = systemService.findHql(hql3,id3);
			req.setAttribute("tSFeeDailyList", tSFeeDailyEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/tsfeedaily/tSFeeDailyList");
	}
	
}
