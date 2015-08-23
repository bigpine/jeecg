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
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDeliverInfoEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSDeliveryInfoServiceI;

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
@RequestMapping("/tsdeliveryInfoController")
public class TSDeliveryInfoController extends BaseController {

	private static final Logger logger = Logger.getLogger(TSDeliveryInfoController.class);

	@Autowired
	private TSDeliveryInfoServiceI tsdeliveryInfoService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//配送信息管理列表页面跳转
	@RequestMapping(params = "deliveryInfo")
	public ModelAndView tFinance(HttpServletRequest request) {
		return new ModelAndView("system/deliveryInfo/deliveryInfoList");
	}
	//初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSDeliverInfoEntity tsDeliveryInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
	/*	if(StringUtil.isNotEmpty(tsproject.getProjectName())){
			tsproject.setProjectName("*"+tsproject.getProjectName()+"*");
			}*/
		
		CriteriaQuery cq = new CriteriaQuery(TSDeliverInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsDeliveryInfo, request.getParameterMap());
		cq.add();
	     this.systemService.getDataGridReturn(cq, true);
		
		TagUtil.datagrid(response, dataGrid);
	}
	//删除操作方法
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSDeliverInfoEntity tsDeliveryInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsDeliveryInfo = systemService.getEntity(TSDeliverInfoEntity.class, tsDeliveryInfo.getId());
		message = "删除成功";
		tsdeliveryInfoService.delete(tsDeliveryInfo);
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
		message = "配送信息管理表中数据删除成功";
		try{
			for(String id:ids.split(",")){
				TSDeliverInfoEntity tsDeliveryInfo = systemService.getEntity(TSDeliverInfoEntity.class, 
				id
				);
				tsdeliveryInfoService.delete(tsDeliveryInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "配送信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	//录入配送信息管理操作
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSDeliverInfoEntity tsDeliveryInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsDeliveryInfo.getId())) {
			TSDeliverInfoEntity t = tsdeliveryInfoService.get(TSDeliverInfoEntity.class, tsDeliveryInfo.getId());
			message = "更新成功";
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsDeliveryInfo, t);
				tsdeliveryInfoService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			tsdeliveryInfoService.save(tsDeliveryInfo);
			message = "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsDeliveryInfo);
		return j;
	}
	//新增 配送信息页面,查看详情,修改页面。
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSDeliverInfoEntity tsDeliveryInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsDeliveryInfo.getId())) {
			tsDeliveryInfo = tsdeliveryInfoService.getEntity(TSDeliverInfoEntity.class, tsDeliveryInfo.getId());
			req.setAttribute("tsDeliveryPage", tsDeliveryInfo);
		}
		return new ModelAndView("system/deliveryInfo/deliveryInfo");
		
	}
	

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tsdeliveryInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSDeliverInfoEntity tsDeliveryInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSDeliverInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsDeliveryInfo, request.getParameterMap());
		List<TSDeliverInfoEntity> tsDeliveryInfos = this.tsdeliveryInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"配送信息表");
		modelMap.put(NormalExcelConstants.CLASS,TSDeliverInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("配送信息表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tsDeliveryInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	/*@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TSDeliverInfoEntity tsDeliveryInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "配送信息表");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,TSDeliverInfoEntity.class);
		modelMap.put(TemplateExcelConstants.LIST_DATA,null);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
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
				List<TSDeliverInfoEntity> listtsDeliveryInfos = ExcelImportUtil.importExcel(file.getInputStream(),TSDeliverInfoEntity.class,params);
				for (TSDeliverInfoEntity tsDeliveryInfo : listtsDeliveryInfos) {
					tsdeliveryInfoService.save(tsDeliveryInfo);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
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
