package com.buss.controller.tsmaterial;

import com.buss.entity.tsmaterial.TSMaterialEntity;
import com.buss.service.tsmaterial.TSMaterialServiceI;
import com.buss.page.tsmaterial.TSMaterialPage;
import com.buss.entity.tsmaterialinfo.TSMaterialinfoEntity;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDeliverInfoEntity;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

/**
 * @Title: Controller
 * @Description: 耗材基础信息
 * @author onlineGenerator
 * @date 2015-08-19 13:46:42
 * @version V1.0
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/tSMaterialController")
public class TSMaterialController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(TSMaterialController.class);

	@Autowired
	private TSMaterialServiceI tSMaterialService;
	@Autowired
	private SystemService systemService;

	/**
	 * 耗材基础信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSMaterial")
	public ModelAndView tSMaterial(HttpServletRequest request) {
		return new ModelAndView("com/buss/tsmaterial/tSMaterialList");
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
	public void datagrid(TSMaterialEntity tSMaterial,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSMaterialEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tSMaterial);
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSMaterialService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除耗材基础信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSMaterialEntity tSMaterial,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tSMaterial = systemService.getEntity(TSMaterialEntity.class,
				tSMaterial.getId());
		String message = "耗材基础信息删除成功";
		try {
			tSMaterialService.delMain(tSMaterial);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "耗材基础信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除耗材基础信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "耗材基础信息删除成功";
		try {
			for (String id : ids.split(",")) {
				TSMaterialEntity tSMaterial = systemService.getEntity(
						TSMaterialEntity.class, id);
				tSMaterialService.delMain(tSMaterial);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "耗材基础信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加耗材基础信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSMaterialEntity tSMaterial,
			TSMaterialPage tSMaterialPage, HttpServletRequest request) {
		List<TSMaterialinfoEntity> tSMaterialinfoList = tSMaterialPage
				.getTSMaterialinfoList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try {
			tSMaterialService.addMain(tSMaterial, tSMaterialinfoList);
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "耗材基础信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新耗材基础信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSMaterialEntity tSMaterial,
			TSMaterialPage tSMaterialPage, HttpServletRequest request) {
		List<TSMaterialinfoEntity> tSMaterialinfoList = tSMaterialPage
				.getTSMaterialinfoList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try {
			tSMaterialService.updateMain(tSMaterial, tSMaterialinfoList);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新耗材基础信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 耗材基础信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSMaterialEntity tSMaterial,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSMaterial.getId())) {
			tSMaterial = tSMaterialService.getEntity(TSMaterialEntity.class,
					tSMaterial.getId());
			req.setAttribute("tSMaterialPage", tSMaterial);
		}
		return new ModelAndView("com/buss/tsmaterial/tSMaterial-add");
	}

	/**
	 * 耗材基础信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSMaterialEntity tSMaterial,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSMaterial.getId())) {
			tSMaterial = tSMaterialService.getEntity(TSMaterialEntity.class,
					tSMaterial.getId());
			req.setAttribute("tSMaterialPage", tSMaterial);
		}
		return new ModelAndView("com/buss/tsmaterial/tSMaterial-update");
	}

	/**
	 * 加载明细列表[耗材费用管理]
	 * 
	 * @return
	 */
	@RequestMapping(params = "tSMaterialinfoList")
	public ModelAndView tSMaterialinfoList(TSMaterialEntity tSMaterial,
			HttpServletRequest req) {

		// ===================================================================================
		// 获取参数
		Object id0 = tSMaterial.getId();
		// ===================================================================================
		// 查询-耗材费用管理
		String hql0 = "from TSMaterialinfoEntity where 1 = 1 AND mATERIAL_ID = ? ";
		try {
			List<TSMaterialinfoEntity> tSMaterialinfoEntityList = systemService
					.findHql(hql0, id0);
			req.setAttribute("tSMaterialinfoList", tSMaterialinfoEntityList);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/tsmaterialinfo/tSMaterialinfoList");
	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "tSMaterialController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSMaterialEntity tSMaterial,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSMaterialEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				tSMaterial, request.getParameterMap());
		List<TSMaterialEntity> tSMaterials = this.tSMaterialService
				.getListByCriteriaQuery(cq, false);
		modelMap.put(NormalExcelConstants.FILE_NAME, "耗材基础表");
		modelMap.put(NormalExcelConstants.CLASS, TSMaterialEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("耗材基础列表",
				"导出人:" + ResourceUtil.getSessionUserName().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST, tSMaterials);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	@SuppressWarnings("unchecked")
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
				List<TSMaterialEntity> listtSMaterials = ExcelImportUtil
						.importExcel(file.getInputStream(),
								TSMaterialEntity.class, params);
				for (TSMaterialEntity tSMaterial : listtSMaterials) {
					tSMaterialService.save(tSMaterial);
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
