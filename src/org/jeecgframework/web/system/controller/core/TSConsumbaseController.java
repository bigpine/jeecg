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
import org.jeecgframework.web.system.pojo.base.TSConsumbaseEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSConsumbaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Scope("prototype")
@Controller
@RequestMapping("/tsconsumbaseController")
//针对于基础耗材费用的基础资料数据
public class TSConsumbaseController extends BaseController {

	private static final Logger logger = Logger.getLogger(TSConsumbaseController.class);

	@Autowired
	private TSConsumbaseServiceI tsconsumbaseService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//进入耗材基础资料列表页面
	@RequestMapping(params = "consumbase")
	public ModelAndView tConsumbase(HttpServletRequest request) {
		return new ModelAndView("system/feemanage/consumbaseList");
	}
	//初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSConsumbaseEntity tsConsumbase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	
		CriteriaQuery cq = new CriteriaQuery(TSConsumbaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsConsumbase, request.getParameterMap());
	
		cq.add();
	     this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	//删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSConsumbaseEntity tsConsumbase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsConsumbase = systemService.getEntity(TSConsumbaseEntity.class, tsConsumbase.getId());
		message = "删除成功";
		tsconsumbaseService.delete(tsConsumbase);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除
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
				TSConsumbaseEntity tsConsumbase = systemService.getEntity(TSConsumbaseEntity.class,id);
				tsconsumbaseService.delete(tsConsumbase);
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
	
	//录入信息管理操作
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSConsumbaseEntity tsConsumbase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsConsumbase.getId())) {
			TSConsumbaseEntity t = tsconsumbaseService.get(TSConsumbaseEntity.class, tsConsumbase.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsConsumbase, t);
				tsconsumbaseService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsconsumbaseService.save(tsConsumbase);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsConsumbase);
		return j;
	}
	//新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSConsumbaseEntity tsConsumbase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsConsumbase.getId())) {
			tsConsumbase = tsconsumbaseService.getEntity(TSConsumbaseEntity.class, tsConsumbase.getId());
			req.setAttribute("tsConsumbasePage", tsConsumbase);
		}
		return new ModelAndView("system/feemanage/consumbaseInfo");
		
	}

}
