package org.jeecgframework.web.system.controller.core;

import java.util.HashMap;
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
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;

import org.jeecgframework.web.system.pojo.base.TSProjectEntity;
import org.jeecgframework.web.system.pojo.base.TSProjectFilesEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSProjectServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: TSProjectController
 * @Description: TODO(公共项目管理处理类)
 * @author 刘大松
 */
@Scope("prototype")
@Controller
@RequestMapping("/tsprojectController")
public class TSProjectController extends BaseController {

	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSProjectController.class);

	@Autowired
	private TSProjectServiceI tsprojectService;
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
	@RequestMapping(params = "project")
	public ModelAndView tFinance(HttpServletRequest request) {
		return new ModelAndView("system/project/projectList");
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
	public void datagrid(TSProjectEntity tsproject,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(StringUtil.isNotEmpty(tsproject.getProjectName())){
			tsproject.setProjectName("*"+tsproject.getProjectName()+"*");
			}
		
		CriteriaQuery cq = new CriteriaQuery(TSProjectEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsproject, request.getParameterMap());
		cq.add();
	     this.tsprojectService.getDataGridReturn(cq, true);
		
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
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSProjectFilesEntity projectFile) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String projectId = oConvertUtils.getString(request.getParameter("projectId"));//项目ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			projectFile.setId(fileKey);
			projectFile = systemService.getEntity(TSProjectFilesEntity.class, fileKey);

		}
		TSProjectEntity tsproject = systemService.getEntity(TSProjectEntity.class, projectId);
		projectFile.setProject(tsproject);
		UploadFile uploadFile = new UploadFile(request, projectFile);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		projectFile = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", projectFile.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + projectFile.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + projectFile.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);

		return j;
	}
	
	/**
	 * 删除项目管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSProjectEntity tsproject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsproject = systemService.getEntity(TSProjectEntity.class, tsproject.getId());
		message = "删除成功";
		tsprojectService.deleteProject(tsproject);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
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
	public AjaxJson save(TSProjectEntity tsproject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsproject.getId())) {
			message = "更新成功";
			TSProjectEntity t = tsprojectService.get(TSProjectEntity.class, tsproject.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsproject, t);
				tsprojectService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			message = "添加成功";
			tsprojectService.save(tsproject);
		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsproject);
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
		TSProjectFilesEntity file = systemService.getEntity(TSProjectFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		tsprojectService.deleteFile(file);
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
	public ModelAndView addorupdate(TSProjectEntity tsproject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsproject.getId())) {
			tsproject = tsprojectService.getEntity(TSProjectEntity.class, tsproject.getId());
			req.setAttribute("tsProjectPage", tsproject);
		}
		return new ModelAndView("system/project/project");
	}
	
}
