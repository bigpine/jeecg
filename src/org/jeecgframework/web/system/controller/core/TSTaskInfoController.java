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
import org.jeecgframework.web.system.pojo.base.TSTaskInfoEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSTaskInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: TSProjectController
 * @Description: TODO(任务管理处理类)
 * @author 刘大松
 */
@Scope("prototype")
@Controller
@RequestMapping("/tstaskInfoController")
public class TSTaskInfoController extends BaseController {

	

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSTaskInfoController.class);

	@Autowired
	private TSTaskInfoServiceI tstaskInfoService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	/**
	 * 公开项目管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "taskInfo")
	public ModelAndView tsTaskInfo(HttpServletRequest request) {
		return new ModelAndView("system/project/taskInfoList");
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
	public void datagrid(TSTaskInfoEntity tstaskInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSTaskInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tstaskInfo, request.getParameterMap());
	     this.tstaskInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	
	/**
	 * 删除任务管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSTaskInfoEntity tstaskInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tstaskInfo = systemService.getEntity(TSTaskInfoEntity.class, tstaskInfo.getId());
		message = "删除成功";
		tstaskInfoService.delete(tstaskInfo);
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
				TSTaskInfoEntity tstaskInfo = systemService.getEntity(TSTaskInfoEntity.class,id);
				tstaskInfoService.delete(tstaskInfo);
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
	
	
	/**
	 * 添加任务管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSTaskInfoEntity tstaskInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tstaskInfo.getId())) {
			message = "更新成功";
			TSTaskInfoEntity t = tstaskInfoService.get(TSTaskInfoEntity.class, tstaskInfo.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tstaskInfo, t);
				tstaskInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			message = "添加成功";
			tstaskInfoService.save(tstaskInfo);
		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tstaskInfo);
		return j;
	}

	

	/**
	 * 任务管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSTaskInfoEntity tstaskInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tstaskInfo.getId())) {
			tstaskInfo = tstaskInfoService.getEntity(TSTaskInfoEntity.class, tstaskInfo.getId());
			req.setAttribute("tsTaskPage", tstaskInfo);
		}
		return new ModelAndView("system/project/taskInfo");
	}
}
