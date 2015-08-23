package org.jeecgframework.web.system.controller.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSExpressEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSExpressServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Scope("prototype")
@Controller
@RequestMapping("/tsexpressController")
public class TSExpressController extends BaseController {

	private static final Logger logger = Logger.getLogger(TSExpressController.class);

	@Autowired
	//private TSProjectServiceI tsprojectService;
	private TSExpressServiceI tsexpressService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//快递管理列表页面跳转
	@RequestMapping(params = "express")
	public ModelAndView tFinance(HttpServletRequest request) {
		return new ModelAndView("system/express/expressList");
	}
    //初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSExpressEntity tsexpress,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	/*	if(StringUtil.isNotEmpty(tsproject.getProjectName())){
			tsproject.setProjectName("*"+tsproject.getProjectName()+"*");
			}*/
		
		CriteriaQuery cq = new CriteriaQuery(TSExpressEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsexpress, request.getParameterMap());
		cq.add();
	     this.systemService.getDataGridReturn(cq, true);
		
		TagUtil.datagrid(response, dataGrid);
	}
	//删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSExpressEntity tsexpress, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsexpress = systemService.getEntity(TSExpressEntity.class, tsexpress.getId());
		message = "删除成功";
		tsexpressService.delete(tsexpress);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
	//录入 快递信息操作
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSExpressEntity tsexpress, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsexpress.getId())) {
			TSExpressEntity t = tsexpressService.get(TSExpressEntity.class, tsexpress.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsexpress, t);
				tsexpressService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsexpressService.save(tsexpress);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsexpress);
		return j;
	}
	//新增 快递信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSExpressEntity tsexpress, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsexpress.getId())) {
			tsexpress = tsexpressService.getEntity(TSExpressEntity.class, tsexpress.getId());
			req.setAttribute("tsExpressPage", tsexpress);
		}
		return new ModelAndView("system/express/express");
	}
	
	
}
