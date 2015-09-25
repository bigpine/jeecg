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
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.TSDevprojectEntity;
import org.jeecgframework.web.system.pojo.base.TSDevprojectFilesEntity;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSDevprojectServiceI;
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
@RequestMapping("/tsdevprojectController")
public class TSDevprojectController extends BaseController {



	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSDevprojectController.class);

	@Autowired
	private TSDevprojectServiceI tsdevprojectService;
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
	@RequestMapping(params = "devproject")
	public ModelAndView tFinance(HttpServletRequest request) {
		return new ModelAndView("system/project/devprojectList");
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
	public void datagrid(TSDevprojectEntity tsdevproject,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSDevprojectEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tsdevproject, request.getParameterMap());
	     this.tsdevprojectService.getDataGridReturn(cq, true);
	     TSUser user = ResourceUtil.getSessionUserName();
	     System.out.println(user+"测试数据值！");
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
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSDevprojectFilesEntity devprojectFile) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String devprojectId = oConvertUtils.getString(request.getParameter("devprojectId"));//项目ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			devprojectFile.setId(fileKey);
			devprojectFile = systemService.getEntity(TSDevprojectFilesEntity.class, fileKey);

		}
		TSDevprojectEntity tsdevproject = systemService.getEntity(TSDevprojectEntity.class, devprojectId);
		devprojectFile.setDevproject(tsdevproject);
		UploadFile uploadFile = new UploadFile(request, devprojectFile);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		devprojectFile = systemService.uploadFile(uploadFile);
		attributes.put("fileKey", devprojectFile.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + devprojectFile.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + devprojectFile.getId());
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
	public AjaxJson del(TSDevprojectEntity tsdevproject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsdevproject = systemService.getEntity(TSDevprojectEntity.class, tsdevproject.getId());
		 if(ClientManager.getInstance().getClient().getUser().getUserName().equals(tsdevproject.getCreateBy())){
			 message = "删除成功";
				tsdevprojectService.deleteDevproject(tsdevproject);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
				j.setMsg(message);
		 }else{
			    message = "对不起,您不能进行删除操作";
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		 }
		
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
	public AjaxJson save(TSDevprojectEntity tsdevproject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsdevproject.getId())) {
			
			TSDevprojectEntity t = tsdevprojectService.get(TSDevprojectEntity.class, tsdevproject.getId());
			  if(ClientManager.getInstance().getClient().getUser().getUserName().equals(tsdevproject.getCreateBy())){
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsdevproject, t);
				tsdevprojectService.saveOrUpdate(t);
				message = "更新成功";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			   }
			 }else{
				    message = "对不起,您没有修改权限!";
					systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			  }
		} else {
			message = "添加成功";
			tsdevprojectService.save(tsdevproject);
		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsdevproject);
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
		TSDevprojectFilesEntity file = systemService.getEntity(TSDevprojectFilesEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		tsdevprojectService.deleteFile(file);
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
	public ModelAndView addorupdate(TSDevprojectEntity tsdevproject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsdevproject.getId())) {
			tsdevproject = tsdevprojectService.getEntity(TSDevprojectEntity.class, tsdevproject.getId());
			req.setAttribute("tsDevprojectPage", tsdevproject);
		}
		return new ModelAndView("system/project/devproject");
	}
}
