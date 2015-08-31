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
import org.jeecgframework.web.system.service.TSBaseFeeServiceI;
import org.jeecgframework.web.system.service.TSConsumfeeServiceI;
import org.jeecgframework.web.system.service.TSFeeCountServiceI;
import org.jeecgframework.web.system.service.TSTransportFeeServiceI;
import org.jeecgframework.web.system.service.TSVechicleFeeServiceI;
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
	private TSTransportFeeServiceI tstransportfeeService;
	@Autowired
	private TSConsumfeeServiceI tsconsumfeeService;
	@Autowired
	private TSVechicleFeeServiceI tsvechiclefeeService;
	@Autowired
	private TSBaseFeeServiceI tsbasefeeService;
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
          String basefeeCount = null;//日常基础费用总和
          String tranfeeCount = null;//外地运输费用总和
          String vichfeeCount = null;//市内运输费用总和
          String consumfeeCount = null;//耗材费用总和
	     if(StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)){
	    	 basefeeCount = String.valueOf(tsbasefeeService.findOneForJdbc("select sum(amout) as ssum from t_s_basefee where mark_date >= "+"'"+markDateStart+"'"+ " and mark_date <="+"'"+markDateEnd+"'").get("ssum"));
	    	 tranfeeCount = String.valueOf(tstransportfeeService.findOneForJdbc("select sum(amout) as ssum from t_s_transportfee  where send_date >= "+"'"+markDateStart+"'"+ " and send_date <="+"'"+markDateEnd+"'").get("ssum"));
	    	 vichfeeCount = String.valueOf(tsvechiclefeeService.findOneForJdbc
	    	("select sum (oil_fee)+sum(stop_fee)+sum(park_fee)+sum(etc_fee)+sum(wash_fee)+sum(service_fee) as ssum from t_s_vehiclefee  where send_date >= "+"'"+markDateStart+"'"+ " and send_date <="+"'"+markDateEnd+"'").get("ssum"));
	    	 consumfeeCount = String.valueOf(tsconsumfeeService.findOneForJdbc("select sum(amout) as ssum from t_s_consumfee  where mark_date >= "+"'"+markDateStart+"'"+ " and mark_date <="+"'"+markDateEnd+"'").get("ssum"));
	    	 dataGrid.setFooter("baseFeeCount:"+basefeeCount+","+"tranFeeCount:"+tranfeeCount+","+"vehicleFeeCount:"+vichfeeCount+","+"consumFeeCount:"+consumfeeCount);
	       
	         System.out.println(basefeeCount+"基础费用"+tranfeeCount+"外地运输"+vichfeeCount+"市内运输"+consumfeeCount+"耗材");	     }else{
	    	 basefeeCount = String.valueOf(tsbasefeeService.findOneForJdbc("select sum(amout) as ssum from t_s_basefee").get("ssum"));
	    	 tranfeeCount = String.valueOf(tstransportfeeService.findOneForJdbc("select sum(amout) as ssum from t_s_transportfee ").get("ssum"));
	    	 vichfeeCount = String.valueOf(tsvechiclefeeService.findOneForJdbc
	    	("select sum (oil_fee)+sum(stop_fee)+sum(park_fee)+sum(etc_fee)+sum(wash_fee)+sum(service_fee) as ssum from t_s_vehiclefee").get("ssum"));
	    	 consumfeeCount = String.valueOf(tsconsumfeeService.findOneForJdbc("select sum(amout) as ssum from t_s_consumfee").get("ssum"));

	    	 dataGrid.setFooter("baseFeeCount:"+basefeeCount+","+"tranFeeCount:"+tranfeeCount+","+"vehicleFeeCount:"+vichfeeCount+","+"consumFeeCount:"+consumfeeCount);
	    	 System.out.println(basefeeCount+"基础费用"+tranfeeCount+"外地运输"+vichfeeCount+"市内运输"+consumfeeCount+"耗材");
	     }
		
		

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
