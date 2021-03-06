package org.jeecgframework.web.system.controller.core;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSVechicleFeeEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSVechicleFeeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
@RequestMapping("/tsvechiclefeeController")
// 车辆费用管理controller
public class TSVechicleFeeController extends BaseController {

	private static final Logger logger = Logger
			.getLogger(TSVechicleFeeController.class);

	@Autowired
	private TSVechicleFeeServiceI tsvechiclefeeService;
	@Autowired
	private SystemService systemService;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 配送信息管理列表页面跳转
	@RequestMapping(params = "tsvechiclefee")
	public ModelAndView tVechicleFee(HttpServletRequest request) {
		return new ModelAndView("system/feemanage/vechicleFeeList");
	}

	// 初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSVechicleFeeEntity tsVechicleFee,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
        
		if(StringUtil.isNotEmpty(tsVechicleFee.getCarCode())){
			tsVechicleFee.setCarCode("*"+tsVechicleFee.getCarCode()+"*");
			}
		if(StringUtil.isNotEmpty(tsVechicleFee.getDriver())){
			tsVechicleFee.setDriver("*"+tsVechicleFee.getDriver()+"*");
		}
		
		CriteriaQuery cq = new CriteriaQuery(TSVechicleFeeEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsVechicleFee, request.getParameterMap());
		String markDateStart=request.getParameter("sendDate_begin");
		String markDateEnd = request.getParameter("sendDate_end");
		if(StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)){
			try{
				cq.ge("sendDate", new SimpleDateFormat("yyyy-MM-dd").parse(markDateStart));
				cq.le("sendDate", new SimpleDateFormat("yyyy-MM-dd").parse(markDateEnd));
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
	     String vichfeeCount = null;//市内运输费用总和
		  if(StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)){
		    	 vichfeeCount = String.valueOf(tsvechiclefeeService.findOneForJdbc
		    	("select sum (oil_fee)+sum(stop_fee)+sum(park_fee)+sum(etc_fee)+sum(wash_fee)+sum(service_fee) as ssum from t_s_vehiclefee  where send_date >= "+"'"+markDateStart+"'"+ " and send_date <="+"'"+markDateEnd+"'").get("ssum"));
		    	 dataGrid.setFooter("amout:"+(vichfeeCount.equalsIgnoreCase("null")?"0.0":vichfeeCount));
		       
		         System.out.println(vichfeeCount+"市内运输");	   
		         }else{
		    	 vichfeeCount = String.valueOf(tsvechiclefeeService.findOneForJdbc
		    	("select sum (oil_fee)+sum(stop_fee)+sum(park_fee)+sum(etc_fee)+sum(wash_fee)+sum(service_fee) as ssum from t_s_vehiclefee").get("ssum"));

		    	 dataGrid.setFooter("amout:"+(vichfeeCount.equalsIgnoreCase("null")?"0.0":vichfeeCount));
		    	 System.out.println(vichfeeCount+"市内运输");	 
		     }

		TagUtil.datagrid(response, dataGrid);
	}

	// 删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSVechicleFeeEntity tsVechicleFee,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsVechicleFee = systemService.getEntity(TSVechicleFeeEntity.class,
				tsVechicleFee.getId());
		message = "删除成功";
		tsvechiclefeeService.delete(tsVechicleFee);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDeleteALLSelect")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "数据删除成功";
		try {
			for (String id : ids.split(",")) {
				TSVechicleFeeEntity tsVechicleFee = systemService.getEntity(
						TSVechicleFeeEntity.class, id);
				tsvechiclefeeService.delete(tsVechicleFee);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	// 录入信息管理操作
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSVechicleFeeEntity tsVechicleFee,
			HttpServletRequest request) {
		
		dealAmountFee(tsVechicleFee);
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsVechicleFee.getId())) {
			TSVechicleFeeEntity t = tsvechiclefeeService.get(
					TSVechicleFeeEntity.class, tsVechicleFee.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsVechicleFee, t);
				/*BigDecimal amout = t.getAmout();
				if(amout==null){
					amout= 0 ;
				}*/
				System.out.println(t.getDriver());
				tsvechiclefeeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE,
						Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsvechiclefeeService.save(tsVechicleFee);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		}
		j.setObj(tsVechicleFee);
		return j;
	}

	/**
	 * 计算总费用
	 * @param tsVechicleFee
	 */
	private void dealAmountFee(TSVechicleFeeEntity tsVechicleFee) {
		tsVechicleFee.setDayKm(tsVechicleFee.getDayKm()==null?new BigDecimal(0.0D):tsVechicleFee.getDayKm());
		tsVechicleFee.setOutKm(tsVechicleFee.getOutKm()==null?new BigDecimal(0.0D):tsVechicleFee.getOutKm());
		tsVechicleFee.setParkFee(tsVechicleFee.getParkFee()==null?new BigDecimal(0.0D):tsVechicleFee.getParkFee());
		tsVechicleFee.setOilFee(tsVechicleFee.getOilFee()==null?new BigDecimal(0.0D):tsVechicleFee.getOilFee());
		tsVechicleFee.setOilMouse(tsVechicleFee.getOilMouse()==null?new BigDecimal(0.0D):tsVechicleFee.getOilMouse());
		tsVechicleFee.setStopFee(tsVechicleFee.getStopFee()==null?new BigDecimal(0.0D):tsVechicleFee.getStopFee());
		tsVechicleFee.setPikeFee(tsVechicleFee.getPikeFee()==null?new BigDecimal(0.0D):tsVechicleFee.getPikeFee());
		tsVechicleFee.setServiceFee(tsVechicleFee.getServiceFee()==null?new BigDecimal(0.0D):tsVechicleFee.getServiceFee());
		tsVechicleFee.setWashFee(tsVechicleFee.getWashFee()==null?new BigDecimal(0.0D):tsVechicleFee.getWashFee());
		tsVechicleFee.setEtcFee(tsVechicleFee.getEtcFee()==null?new BigDecimal(0.0D):tsVechicleFee.getEtcFee());
		tsVechicleFee.setStartKm(tsVechicleFee.getStartKm()==null?new BigDecimal(0.0D):tsVechicleFee.getStartKm());
		tsVechicleFee.setEndKm(tsVechicleFee.getEndKm()==null?new BigDecimal(0.0D):tsVechicleFee.getEndKm());
		tsVechicleFee.setAddOilKm(tsVechicleFee.getAddOilKm()==null?new BigDecimal(0.0D):tsVechicleFee.getAddOilKm());
		tsVechicleFee.setOilNum(tsVechicleFee.getOilNum()==null?new BigDecimal(0.0D):tsVechicleFee.getOilNum());
		
		BigDecimal amount = tsVechicleFee.getParkFee().add(tsVechicleFee.getOilFee()).add(tsVechicleFee.getPikeFee())
			.add(tsVechicleFee.getStopFee()).add(tsVechicleFee.getServiceFee()).add(tsVechicleFee.getEtcFee()).add(tsVechicleFee.getWashFee());
		tsVechicleFee.setAmout(amount);
	}

	// 新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSVechicleFeeEntity tsVechicleFee,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsVechicleFee.getId())) {
			tsVechicleFee = tsvechiclefeeService.getEntity(
					TSVechicleFeeEntity.class, tsVechicleFee.getId());
			req.setAttribute("tsVechicleFeePage", tsVechicleFee);
		}
		return new ModelAndView("system/feemanage/vechicleFeeInfo");

	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "tsvechiclefeeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSVechicleFeeEntity tsVechicleFee,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSVechicleFeeEntity.class,
				dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsVechicleFee, request.getParameterMap());
		List<TSVechicleFeeEntity> tsVechicleFees = this.tsvechiclefeeService
				.getListByCriteriaQuery(cq, false);
		modelMap.put(NormalExcelConstants.FILE_NAME, "车辆信息表");
		modelMap.put(NormalExcelConstants.CLASS, TSVechicleFeeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("车辆信息列表",
				"导出人:" + ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST, tsVechicleFees);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TSVechicleFeeEntity> listtsVechicleFees = ExcelImportUtil
						.importExcel(file.getInputStream(),
								TSVechicleFeeEntity.class, params);
				for (TSVechicleFeeEntity tsVechicleFee : listtsVechicleFees) {
					tsvechiclefeeService.save(tsVechicleFee);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			} finally {
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}

}
