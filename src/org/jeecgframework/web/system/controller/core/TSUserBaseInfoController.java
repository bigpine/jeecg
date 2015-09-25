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
import org.jeecgframework.web.system.pojo.base.TSUserBaseInfoEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSUserBaseInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Scope("prototype")
@Controller
@RequestMapping("/tsuserbaseinfoController")
public class TSUserBaseInfoController extends BaseController {





	private static final Logger logger = Logger.getLogger(TSUserBaseInfoController.class);

	@Autowired                    
	private TSUserBaseInfoServiceI tsuserBaseInfoService; 
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//用户基础信息列表页面跳转
	@RequestMapping(params = "userBaseInfo")
	public ModelAndView tuserBase(HttpServletRequest request) {
		return new ModelAndView("system/performance/userBaseList");
	}
	//初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSUserBaseInfoEntity tsuserBase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	/*	if(StringUtil.isNotEmpty(tsproject.getProjectName())){
			tsproject.setProjectName("*"+tsproject.getProjectName()+"*");
			}*/
		
		CriteriaQuery cq = new CriteriaQuery(TSUserBaseInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsuserBase, request.getParameterMap());
		cq.add();
	     this.systemService.getDataGridReturn(cq, true);
		
		TagUtil.datagrid(response, dataGrid);
	}
	//删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSUserBaseInfoEntity tsuserBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsuserBase = systemService.getEntity(TSUserBaseInfoEntity.class, tsuserBase.getId());
		message = "删除成功";
		tsuserBaseInfoService.delete(tsuserBase);
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
				TSUserBaseInfoEntity tsuserBase = systemService.getEntity(TSUserBaseInfoEntity.class, id);
				tsuserBaseInfoService.delete(tsuserBase);
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
	public AjaxJson save(TSUserBaseInfoEntity tsuserBase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		if (StringUtil.isNotEmpty(tsuserBase.getId())) {
			TSUserBaseInfoEntity t = tsuserBaseInfoService.get(TSUserBaseInfoEntity.class, tsuserBase.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsuserBase, t);
				t.getEmail().trim();
				t.getRealName().trim();
				t.getUserName().trim();
				t.getPosition().trim();
				t.getDepartName().trim();
				tsuserBaseInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsuserBase.setUserName(tsuserBase.getUserName().trim());
			tsuserBase.setRealName(tsuserBase.getRealName().trim());
			tsuserBase.setDepartName(tsuserBase.getDepartName().trim());
			tsuserBase.setPosition(tsuserBase.getPosition().trim());
			tsuserBase.setEmail(tsuserBase.getEmail().trim());
			tsuserBaseInfoService.save(tsuserBase);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsuserBase);
		return j;
	}
	//新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSUserBaseInfoEntity tsuserBase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsuserBase.getId())) {
			tsuserBase = tsuserBaseInfoService.getEntity(TSUserBaseInfoEntity.class, tsuserBase.getId());
			req.setAttribute("tsuserBasePage", tsuserBase);
		}
		return new ModelAndView("system/performance/userBaseInfo");
		
	}
	
	
}
