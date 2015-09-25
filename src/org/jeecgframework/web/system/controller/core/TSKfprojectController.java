package org.jeecgframework.web.system.controller.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.UUIDGenerator;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.TSKfprojectEntity;
import org.jeecgframework.web.system.pojo.base.TSKfprojectFilesEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSKfprojectServiceI;
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



/**
 * @ClassName: TSProjectController
 * @Description: TODO(客服项目管理处理类)
 * @author 刘大松
 */
@Scope("prototype")
@Controller
@RequestMapping("/tskfprojectController")
public class TSKfprojectController extends BaseController {
	


	private static final String KFPROJECT_UPLOAD_PAGE = "system/project/kfprojectUpload";

	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSKfprojectController.class);

	@Autowired
	private TSKfprojectServiceI tskfprojectService;
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
	@RequestMapping(params = "kfproject")
	public ModelAndView kfProject(HttpServletRequest request) {
		return new ModelAndView("system/project/kfprojectList");
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
	public void datagrid(TSKfprojectEntity tskfproject,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//客户名称 
		if(StringUtil.isNotEmpty(tskfproject.getKfprojectName())){
			tskfproject.setKfprojectName("*"+tskfproject.getKfprojectName()+"*");
			}
		//客户联系人
		if(StringUtil.isNotEmpty(tskfproject.getContactUser())){
			tskfproject.setContactUser("*"+tskfproject.getContactUser()+"*");
			}
		//入加要求
		if(StringUtil.isNotEmpty(tskfproject.getRkRequire())){
			tskfproject.setRkRequire("*"+tskfproject.getRkRequire()+"*");
			}
		//出库要求
		if(StringUtil.isNotEmpty(tskfproject.getCkRequire())){
			tskfproject.setCkRequire("*"+tskfproject.getCkRequire()+"*");
			}
		//开票要求
		if(StringUtil.isNotEmpty(tskfproject.getKpRequire())){
			tskfproject.setKpRequire("*"+tskfproject.getKpRequire()+"*");
		}
		//备注相关信息
		if(StringUtil.isNotEmpty(tskfproject.getKfprojectStatus())){
			tskfproject.setKfprojectDesc("*"+tskfproject.getKfprojectStatus()+"*");
		}
		
		CriteriaQuery cq = new CriteriaQuery(TSKfprojectEntity.class, dataGrid);
		//查询条件组装器

		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tskfproject, request.getParameterMap());
		cq.add();
		this.tskfprojectService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 保存文件
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSKfprojectFilesEntity kfprojectFile) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String kfprojectId = oConvertUtils.getString(request.getParameter("kfprojectId"));//项目ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			kfprojectFile.setId(fileKey);
			kfprojectFile = systemService.getEntity(TSKfprojectFilesEntity.class, fileKey);

		}
		TSKfprojectEntity tskfproject = systemService.getEntity(TSKfprojectEntity.class, kfprojectId);
		kfprojectFile.setKfproject(tskfproject);
		UploadFile uploadFile = new UploadFile(request, kfprojectFile);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		kfprojectFile = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", kfprojectFile.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + kfprojectFile.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + kfprojectFile.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	
	/**
	 * 删除项目管理
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSKfprojectEntity tskfproject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tskfproject = systemService.getEntity(TSKfprojectEntity.class, tskfproject.getId());
		//System.out.println( "user"+ClientManager.getInstance().getClient().getUser().getUserName());
	    //if(ClientManager.getInstance().getClient().getUser().getUserName().equals(tskfproject.getCreateBy())){
	    	tskfprojectService.deleteKfproject(tskfproject);
			message = "删除成功";
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			j.setMsg(message);
	   /* }else{
	    	 message = "当前用户不能进行删除！";
	 	    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	    }
	   */
	    return j;
	}


	/**
	 * 添加项目管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TSKfprojectEntity tskfproject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tskfproject.getId())) {
			
			TSKfprojectEntity t = tskfprojectService.get(TSKfprojectEntity.class, tskfproject.getId());
			 if(ClientManager.getInstance().getClient().getUser().getUserName().equals(tskfproject.getCreateBy())){
				 
				 try {
						MyBeanUtils.copyBeanNotNull2Bean(tskfproject, t);
						tskfprojectService.saveOrUpdate(t);
						message = "更新成功";
						systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
					} catch (Exception e) {
						e.printStackTrace();
					}
			 }else{

				 message = "对不起,您没有修改权限！";
				 systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				 
			 }
			
		} else {
			message = "添加成功";
			tskfprojectService.save(tskfproject);
		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tskfproject);
		return j;
	}

	
	/**
	 * 删除文档
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String id  = request.getParameter("id");
		TSKfprojectFilesEntity file = systemService.getEntity(TSKfprojectFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		tskfprojectService.deleteFile(file);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 项目管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSKfprojectEntity tskfproject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tskfproject.getId())) {
			tskfproject = tskfprojectService.getEntity(TSKfprojectEntity.class, tskfproject.getId());
			req.setAttribute("tsKfprojectPage", tskfproject);
		}
		return new ModelAndView("system/project/kfproject");
	}

    //导入excel 上传	
	@RequestMapping(params = "upload")
	public String upload(HttpServletRequest req) {
		return KFPROJECT_UPLOAD_PAGE;
	}
	
	
	
	
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<TSKfprojectEntity> listkfprojects =  ExcelImportUtil.importExcel(file.getInputStream(),TSKfprojectEntity.class,params);
				for (TSKfprojectEntity kfproject : listkfprojects) {
					if(kfproject.getKfprojectName()!=null){
						kfproject.setId(UUIDGenerator.generate());
						tskfprojectService.save(kfproject);
					}
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


	
	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSKfprojectEntity kfproject,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap map) {

        CriteriaQuery cq = new CriteriaQuery(TSKfprojectEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, kfproject, request.getParameterMap());
        List<TSKfprojectEntity> kfprojects = this.tskfprojectService.getListByCriteriaQuery(cq,false);

        map.put(NormalExcelConstants.FILE_NAME,"项目信息");
        map.put(NormalExcelConstants.CLASS,TSKfprojectEntity.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("项目列表", "导出人:刘大松",
                "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,kfprojects);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;

	}
}
