package org.jeecgframework.web.system.controller.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSFeeCountEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSFeeCountServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Scope("prototype")
@Controller
@RequestMapping("/tsfeecountcontroller")
// 费用统计查询controller
public class TSFeeCountController extends BaseController {


	

	private static final Logger logger = Logger.getLogger(TSFeeCountController.class);
			

	@Autowired
	private TSFeeCountServiceI tscfeecountService;
	@Autowired
	private SystemService systemService;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 费用统计查询页面
	@RequestMapping(params = "tsfeecount")
	public ModelAndView tFeeCount(HttpServletRequest request) {
		return new ModelAndView("system/feemanage/tsfeecountList");
	}

	// 初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSFeeCountEntity tsFeeCount,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(TSFeeCountEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsFeeCount, request.getParameterMap());
		String markDateStart=request.getParameter("markDate_begin");
		String markDateEnd = request.getParameter("markDate_end");
		if(StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)){
			try{
				cq.ge("markDate", new SimpleDateFormat("yyyy-MM-dd").parse(markDateStart));
				cq.le("markDate", new SimpleDateFormat("yyyy-MM-dd").parse(markDateEnd));
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		
		cq.add();
		this.systemService.getDataGridReturn(cq, true);

		TagUtil.datagrid(response, dataGrid);
	}

	//查看明细页面需要做出修改
	/*@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSConsumfeeEntity tsConsumFee,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsConsumFee = systemService.getEntity(TSConsumfeeEntity.class,
				tsConsumFee.getId());
		message = "删除成功";
		tsconsumfeeService.delete(tsConsumFee);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
*/
	
	// 新增 配送信息页面,查看详情,修改页面。
	/*@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSConsumfeeEntity tsConsumFee,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsConsumFee.getId())) {
			tsConsumFee = tsconsumfeeService.getEntity(
					TSConsumfeeEntity.class, tsConsumFee.getId());
			req.setAttribute("tsConsumFeePage", tsConsumFee);
		}
		return new ModelAndView("system/feemanage/consumfeeInfo");

	}*/

}
