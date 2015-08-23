package org.jeecgframework.web.system.controller.core;

import java.io.IOException;
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
import org.jeecgframework.web.system.pojo.base.TSConsumfeeEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSConsumfeeServiceI;
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
@RequestMapping("/tsconsumfeeController")
// 耗材费用管理controller
public class TSConsumfeeController extends BaseController {
	


	private static final Logger logger = Logger
			.getLogger(TSConsumfeeController.class);

	@Autowired
	private TSConsumfeeServiceI tsconsumfeeService;
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
	@RequestMapping(params = "tsconsumfee")
	public ModelAndView tConsumFee(HttpServletRequest request) {
		return new ModelAndView("system/feemanage/consumfeeList");
	}

	// 初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSConsumfeeEntity tsConsumFee,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(TSConsumfeeEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsConsumFee, request.getParameterMap());
		cq.add();
		this.systemService.getDataGridReturn(cq, true);

		TagUtil.datagrid(response, dataGrid);
	}

	// 删除操作方法
	@RequestMapping(params = "del")
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
				TSConsumfeeEntity tsConsumFee = systemService.getEntity(
						TSConsumfeeEntity.class, id);
				tsconsumfeeService.delete(tsConsumFee);
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
	public AjaxJson save(TSConsumfeeEntity tsConsumFee,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsConsumFee.getId())) {
			TSConsumfeeEntity t = tsconsumfeeService.get(
					TSConsumfeeEntity.class, tsConsumFee.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsConsumFee, t);
				tsconsumfeeService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE,
						Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsconsumfeeService.save(tsConsumFee);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		}
		j.setObj(tsConsumFee);
		return j;
	}

	// 新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSConsumfeeEntity tsConsumFee,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsConsumFee.getId())) {
			tsConsumFee = tsconsumfeeService.getEntity(
					TSConsumfeeEntity.class, tsConsumFee.getId());
			req.setAttribute("tsConsumFeePage", tsConsumFee);
		}
		return new ModelAndView("system/feemanage/consumfeeInfo");

	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "tsconsumfeeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSConsumfeeEntity tsConsumFee,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSConsumfeeEntity.class,
				dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tsConsumFee, request.getParameterMap());
		List<TSConsumfeeEntity> tsConsumFees = this.tsconsumfeeService
				.getListByCriteriaQuery(cq, false);
		modelMap.put(NormalExcelConstants.FILE_NAME, "耗材信息表");
		modelMap.put(NormalExcelConstants.CLASS, TSConsumfeeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("耗材信息列表",
				"导出人:" + ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST, tsConsumFees);
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
				List<TSConsumfeeEntity> listtsConsumfees = ExcelImportUtil
						.importExcel(file.getInputStream(),
								TSConsumfeeEntity.class, params);
				for (TSConsumfeeEntity tsConsumfee : listtsConsumfees) {
					tsconsumfeeService.save(tsConsumfee);
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
