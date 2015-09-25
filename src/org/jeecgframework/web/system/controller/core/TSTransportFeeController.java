package org.jeecgframework.web.system.controller.core;

import java.io.IOException;
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
import org.jeecgframework.web.system.pojo.base.TSTransportFeeEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSTransportFeeServiceI;
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
@RequestMapping("/tstransportfeeController")
// 外地运输费用管理controller
public class TSTransportFeeController extends BaseController {

	private static final Logger logger = Logger
			.getLogger(TSTransportFeeController.class);

	@Autowired
	private TSTransportFeeServiceI tstransportfeeService;
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
	@RequestMapping(params = "tstransportfee")
	public ModelAndView tTransportFee(HttpServletRequest request) {
		return new ModelAndView("system/feemanage/transportfeeList");
	}

	// 初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSTransportFeeEntity tsTransport,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(TSTransportFeeEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsTransport, request.getParameterMap());
		String sendDateStart=request.getParameter("sendDate_begin");
		String sendDateEnd = request.getParameter("sendDate_end");
		if(StringUtil.isNotEmpty(sendDateStart)&&StringUtil.isNotEmpty(sendDateEnd)){
			try{
				cq.ge("sendDate", new SimpleDateFormat("yyyy-MM-dd").parse(sendDateStart));
				cq.le("sendDate", new SimpleDateFormat("yyyy-MM-dd").parse(sendDateEnd));
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
		String tranfeeCount = null;
		if(StringUtil.isNotEmpty(sendDateStart)&&StringUtil.isNotEmpty(sendDateEnd)){
			 tranfeeCount = String.valueOf(tstransportfeeService.
		findOneForJdbc("select sum(amout) as ssum from t_s_transportfee where send_date >= "+"'"+sendDateStart+"'" +"and send_date <= "+"'"+sendDateEnd+"'").get("ssum"));
			 dataGrid.setFooter("amout:"+(tranfeeCount.equalsIgnoreCase("null")?"0.0":tranfeeCount)+"费用合计");
		}else{
			 tranfeeCount = String.valueOf(tstransportfeeService.
					findOneForJdbc("select sum(amout) as ssum from t_s_transportfee ").get("ssum"));
			 dataGrid.setFooter("amout:"+(tranfeeCount.equalsIgnoreCase("null")?"0.0":tranfeeCount)+"费用合计");
		}
		  
		TagUtil.datagrid(response, dataGrid);
	}

	// 删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSTransportFeeEntity tsTransport,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsTransport = systemService.getEntity(TSTransportFeeEntity.class,
				tsTransport.getId());
		message = "删除成功";
		tstransportfeeService.delete(tsTransport);
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
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "数据删除成功";
		try {
			for (String id : ids.split(",")) {
				TSTransportFeeEntity tsTransport = systemService.getEntity(
						TSTransportFeeEntity.class, id);
				tstransportfeeService.delete(tsTransport);
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
	public AjaxJson save(TSTransportFeeEntity tsTransport,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsTransport.getId())) {
			TSTransportFeeEntity t = tstransportfeeService.get(
					TSTransportFeeEntity.class, tsTransport.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsTransport, t);
				tstransportfeeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE,
						Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tstransportfeeService.save(tsTransport);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		}
		j.setObj(tsTransport);
		return j;
	}

	// 新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSTransportFeeEntity tsTransport,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsTransport.getId())) {
			tsTransport = tstransportfeeService.getEntity(
					TSTransportFeeEntity.class, tsTransport.getId());
			req.setAttribute("tsTransportPage", tsTransport);
		}
		return new ModelAndView("system/feemanage/tstransportInfo");

	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "tstransportfeeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSTransportFeeEntity tsTransport,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSTransportFeeEntity.class,
				dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsTransport, request.getParameterMap());
		List<TSTransportFeeEntity> tsTransports = this.tstransportfeeService
				.getListByCriteriaQuery(cq, false);
		modelMap.put(NormalExcelConstants.FILE_NAME, "运输信息表");
		modelMap.put(NormalExcelConstants.CLASS, TSTransportFeeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("运输信息列表",
				"导出人:" + ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST, tsTransports);
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
				List<TSTransportFeeEntity> listtstransportfees = ExcelImportUtil
						.importExcel(file.getInputStream(),
								TSTransportFeeEntity.class, params);
				for (TSTransportFeeEntity tsTransport : listtstransportfees) {
					tstransportfeeService.save(tsTransport);
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
