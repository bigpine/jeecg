package org.jeecgframework.web.system.controller.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSPerformanceBaseEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSPerformanceBaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Scope("prototype")
@Controller
@RequestMapping("/tsperformanceBaseController")
public class TSPerformanceBaseController extends BaseController {



	private static final Logger logger = Logger.getLogger(TSPerformanceBaseController.class);

	@Autowired
	private TSPerformanceBaseServiceI tsperformanceBaseService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//绩效基础信息列表页面跳转
	@RequestMapping(params = "performanceBase")
	public ModelAndView tPerformanceBase(HttpServletRequest request) {
		return new ModelAndView("system/performance/performanceBaseList");
	}
	//初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSPerformanceBaseEntity tsperformanceBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	/*	if(StringUtil.isNotEmpty(tsproject.getProjectName())){
			tsproject.setProjectName("*"+tsproject.getProjectName()+"*");
			}*/
		
		CriteriaQuery cq = new CriteriaQuery(TSPerformanceBaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsperformanceBase, request.getParameterMap());
		cq.add();
	     this.systemService.getDataGridReturn(cq, true);
		
		TagUtil.datagrid(response, dataGrid);
	}
	//删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSPerformanceBaseEntity tsperformanceBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsperformanceBase = systemService.getEntity(TSPerformanceBaseEntity.class, tsperformanceBase.getId());
		message = "删除成功";
		tsperformanceBaseService.delete(tsperformanceBase);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除配送信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "数据删除成功";
		try{
			for(String id:ids.split(",")){
				TSPerformanceBaseEntity tsperformanceBase = systemService.getEntity(TSPerformanceBaseEntity.class, 
				id
				);
				tsperformanceBaseService.delete(tsperformanceBase);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	//录入配送信息管理操作
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSPerformanceBaseEntity tsperformanceBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsperformanceBase.getId())) {
			TSPerformanceBaseEntity t = tsperformanceBaseService.get(TSPerformanceBaseEntity.class, tsperformanceBase.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsperformanceBase, t);
				tsperformanceBaseService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsperformanceBaseService.save(tsperformanceBase);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsperformanceBase);
		return j;
	}
	//新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSPerformanceBaseEntity tsperformanceBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsperformanceBase.getId())) {
			tsperformanceBase = tsperformanceBaseService.getEntity(TSPerformanceBaseEntity.class, tsperformanceBase.getId());
			req.setAttribute("tsperformanceBasePage", tsperformanceBase);
		}
		return new ModelAndView("system/performance/performanceBaseInfo");
		
	}
	

	
	
}
