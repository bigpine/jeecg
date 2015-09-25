package org.jeecgframework.web.system.controller.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.sendmail.util.MailSenderInfo;
import org.jeecgframework.web.sendmail.util.SimpleMailSender;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSKfprojectEntity;
import org.jeecgframework.web.system.pojo.base.TSPerformanceBaseEntity;
import org.jeecgframework.web.system.pojo.base.TSPerformanceEntity;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.pojo.base.TSUserBaseInfoEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.TSPerformanceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Scope("prototype")
@Controller
@RequestMapping("/tsperformanceController")
public class TSPerformanceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSPerformanceController.class);

	@Autowired
	private TSPerformanceServiceI tsperformanceService;
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
	 * 绩效管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "performance")
	public ModelAndView tPerformance(HttpServletRequest request) {
		return new ModelAndView("system/performance/performanceList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	// 初始化加载数据与查看页面请求数据
	@RequestMapping(params = "datagrid")
	public void datagrid(TSPerformanceEntity tsperformance,HttpServletRequest request, HttpServletResponse response,DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(TSPerformanceEntity.class, dataGrid);
		
		TSDepart dempart = ResourceUtil.getSessionUserName().getCurrentDepart();
		String userName = ResourceUtil.getSessionUserName().getRealName();
		String userCode = ResourceUtil.getSessionUserName().getUserName();
		//System.out.println(userCode);
		//TSDepart d1 = ResourceUtil.getSessionUserName().getCurrentDepart(); 
		//String orgode =d1.getOrgCode();
		//System.out.println(d1);
		String dd= dempart.getDepartname();
		//System.out.println(dd+"部门名称");
		
		
		String realName = tsperformance.getRealName();
		String departName = tsperformance.getDepartName();
		String subStatus = tsperformance.getSubStatus();
		if(StringUtil.isNotEmpty(realName)){
			tsperformance.setRealName("*"+tsperformance.getRealName()+"*");
		}
		if(StringUtil.isNotEmpty(departName)){
			tsperformance.setDepartName("*"+tsperformance.getDepartName()+"*");
		}
		
		if(StringUtil.isNotEmpty(subStatus)){
			tsperformance.setSubStatus("*"+tsperformance.getSubStatus()+"*");
		}
	
		
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,tsperformance, request.getParameterMap());
	
		String markDateStart=request.getParameter("markDate_begin");
		String markDateEnd = request.getParameter("markDate_end");
		/*dataGrid.setFooter(footer);*/
		if(StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)){
			try{
				cq.ge("markDate", new SimpleDateFormat("yyyy-MM-dd").parse(markDateStart));
				cq.le("markDate", new SimpleDateFormat("yyyy-MM-dd").parse(markDateEnd));
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		
		if((!ClientManager.getInstance().getClient().getUser().getUserKey().equals("管理员,主管用户"))
		&&	(!ClientManager.getInstance().getClient().getUser().getUserKey().equals("部门经理"))
		&&	(!ClientManager.getInstance().getClient().getUser().getUserKey().equals("物流总监"))
		&&	(!ClientManager.getInstance().getClient().getUser().getUserKey().equals("管理员,开发者"))	
				){
			
			cq.eq("realName", userName);
		}
        if((ClientManager.getInstance().getClient().getUser().getUserKey().equals("主管用户"))&&!userCode.equals("10100141")){
			
			cq.eq("departName", dd);
		}
        if(ClientManager.getInstance().getClient().getUser().getUserKey().equals("主管用户")&&dd.equals("仓储部")){
        	Object [] aa = {"收货","出库","拣货","打包","仓储部"};
        	
        	cq.in("departName", aa);
        }
		
		
		
		
		cq.add();
		this.systemService.getDataGridReturn(cq, true);
		String scoreCount = null;
		if (StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)&&StringUtil.isEmpty(realName))
		  {
			scoreCount = String.valueOf(tsperformanceService.findOneForJdbc
					("select sum(score) as tt  from t_s_performance  where 1=1 and sub_status='已完成' and mark_date >=" +"'"+ markDateStart+"'" +" and mark_date <= "+ "'"+markDateEnd+"'").get("tt"));
     
		  }
		else if (StringUtil.isNotEmpty(markDateStart)&&StringUtil.isNotEmpty(markDateEnd)&&StringUtil.isNotEmpty(realName))
		  { 
			scoreCount = String.valueOf(tsperformanceService.findOneForJdbc
			("select sum(score) as tt  from t_s_performance  where 1=1  and sub_status='已完成' and mark_date >=" +"'"+ markDateStart+"'" +" and mark_date <= "+ "'"+markDateEnd+"'" +"and real_name like" +"'"+"%"+realName.trim()+"%"+"'").get("tt"));
		     
		  }
		else if (StringUtil.isEmpty(markDateStart)&&StringUtil.isEmpty(markDateEnd)&&StringUtil.isNotEmpty(realName))
		  { 
			scoreCount = String.valueOf(tsperformanceService.findOneForJdbc
			("select sum(score) as tt  from t_s_performance  where 1=1 and sub_status='已完成'  and  real_name like" +"'"+"%"+realName.trim()+"%"+"'").get("tt"));
		     
		  }
		else
		  {
			 scoreCount =
					String.valueOf(tsperformanceService.findOneForJdbc
							("select sum(score) as tt  from t_s_performance where sub_status='已完成' ").get("tt"));
		  }
		
		
		
		dataGrid.setFooter("score:"+scoreCount+"合计分值");
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	
	
	
	
	
	
	
	
	//获取部门员工数据
	@RequestMapping(params = "getUserList")
	@ResponseBody
	public AjaxJson getUserList(HttpServletRequest req){
		AjaxJson ajaxJson = new AjaxJson();
		
		String departName = StringUtil.getEncodePra(req.getParameter("departName"));
		
		String sql = "select  distinct t.real_name from t_s_user_baseinfo t where t.depart_name = '"+departName+"'";
	
		List<String> userList = this.systemService.findListbySql(sql);
		
		String options = "";
		for (String realName : userList) {
			options += "<option value=\""+realName+"\" >"+realName+"</option>";
		}
		ajaxJson.setMsg(options);
		return ajaxJson;
	}
	
	  //获取员工职责信息
	@RequestMapping(params = "getPositionList")
	@ResponseBody
	public AjaxJson getPositionList(HttpServletRequest req){
		AjaxJson ajaxJson = new AjaxJson();
		
		String departName = StringUtil.getEncodePra(req.getParameter("departName"));
		String realName = StringUtil.getEncodePra(req.getParameter("realName"));
		String sql = "select  distinct t.position from t_s_user_baseinfo t where  1=1  ";
		if(departName!=null){
			sql += " and t.depart_name like '"+"%"+departName.trim()+"%"+"'";
		}
		if(realName!=null){
			sql += " and t.real_name like '"+"%"+realName.trim()+"%"+"'";
		}
		List<String> positionList = this.systemService.findListbySql(sql);
		
		String options = "";
		for (String position : positionList) {
			options += "<option value=\""+position+"\">"+position+"</option>";
		}
		ajaxJson.setMsg(options);
		return ajaxJson;
	}
	
	
	//获取员工邮箱
	@RequestMapping(params = "getEmailList")
	@ResponseBody
	public AjaxJson getEmailList(HttpServletRequest req){
		AjaxJson ajaxJson = new AjaxJson();
		String departName = StringUtil.getEncodePra(req.getParameter("departName"));
		String realName = StringUtil.getEncodePra(req.getParameter("realName"));
		String position = StringUtil.getEncodePra(req.getParameter("position"));
		String sql = "select  distinct t.email from t_s_user_baseinfo t where  1=1  ";
		if(departName!=null){
			sql += " and t.depart_name like'"+"%"+departName.trim()+"%"+"'";
		}
		if(realName!=null){
			sql += " and t.real_name like '"+"%"+realName.trim()+"%"+"'";
		}
		if(position!=null){
			sql += " and t.position like '"+"%"+position.trim()+"%"+"'";
		}
		List<String> emailList = this.systemService.findListbySql(sql);
		
		String options = "";
		for (String email : emailList) {
			options += "<option value=\""+email+"\">"+email+"</option>";
		}
		ajaxJson.setMsg(options);
		return ajaxJson;
	}
	
	//获取绩效类别数据
	@RequestMapping(params = "getPerforTypeList")
	@ResponseBody
	public AjaxJson getPerforTypeList(HttpServletRequest req){
		AjaxJson ajaxJson = new AjaxJson();
		
		String performanceName = StringUtil.getEncodePra(req.getParameter("perforName"));
		String sql = "select  distinct t.perfor_type from t_s_performance_base t where t.perfor_name like '"+"%"+ performanceName.trim()+"%"+"'";
		List<String> perforTypeList = this.systemService.findListbySql(sql);
		
		String options = "";
		for (String perforType : perforTypeList) {
			options += "<option value=\""+perforType+"\" >"+perforType+"</option>";
		}
		ajaxJson.setMsg(options);
		return ajaxJson;
	}


	//对员工绩效做出取消操作
	@RequestMapping(params = "reset")
	@ResponseBody
	public AjaxJson reset(TSPerformanceEntity tsperformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsperformance = systemService.getEntity(TSPerformanceEntity.class, tsperformance.getId());
		if((ClientManager.getInstance().getClient().getUser().getRealName().equals("周琳"))){
		
		tsperformance.setSubStatus("已取消");
		tsperformanceService.saveOrUpdate(tsperformance);
			message = "该绩效记录已取消";
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			j.setMsg(message);
	    }else{
	    	 message = "当前用户不能进行删除！";
	 	    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	    }
	   
	    return j;
	}
	
	//确认用户绩效信息
	@RequestMapping(params = "subStatus")
	@ResponseBody
	public AjaxJson subStatus(TSPerformanceEntity tsperformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsperformance.getId())) {
			message = "员工绩效信息已完成！";
			/*TSPerformanceEntity t =tsperformanceService.get(tsperformance.class, TSPerformanceEntity.getId());*/
			TSPerformanceEntity t = tsperformanceService.get(TSPerformanceEntity.class, tsperformance.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsperformance, t);
				t.setSubStatus("已完成");
			    //	sendMail(tsperformance);
				tsperformanceService.saveOrUpdate(t);
				j.setMsg(message);
				
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return j;
	}

	/**
	 * 提交用户绩效信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveAuthor")
	@ResponseBody
	public AjaxJson saveAuthor(TSPerformanceEntity tsperformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tsperformance.getId())) {
			message = "你已成功提交信息！";
			/*TSPerformanceEntity t =tsperformanceService.get(tsperformance.class, TSPerformanceEntity.getId());*/
			TSPerformanceEntity t = tsperformanceService.get(TSPerformanceEntity.class, tsperformance.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsperformance, t);
				t.setSubStatus("待确认");
				sendMail(tsperformance);
				tsperformanceService.saveOrUpdate(t);
				j.setMsg(message);
				
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return j;
	}
	
	
    //获取绩效明细信息
	@RequestMapping(params = "getPerforDetailList")
	@ResponseBody
	public AjaxJson getPerforDetailList(HttpServletRequest req){
		AjaxJson ajaxJson = new AjaxJson();
		
		String perforType = StringUtil.getEncodePra(req.getParameter("perforType"));
		String perforName = StringUtil.getEncodePra(req.getParameter("perforName"));
		String sql = "select distinct t.perfor_detail from t_s_performance_base t where 1=1 ";
		if(perforName!=null){
			sql += " and t.perfor_name like '"+"%"+perforName.trim()+"%"+"'";
		}
		if(perforType!=null){
			sql += " and t.perfor_type like '"+"%"+perforType.trim()+"%"+"'";
		}
		List<String> perforDetailList = this.systemService.findListbySql(sql);
		
		String options = "";
		for (String perforDetail : perforDetailList) {
			options += "<option value=\""+perforDetail+"\">"+perforDetail+"</option>";
		}
		ajaxJson.setMsg(options);
		return ajaxJson;
	}
	//获取绩效分值
	@RequestMapping(params = "getScoreList")
	@ResponseBody
	public AjaxJson getScoreList(HttpServletRequest req){
		AjaxJson ajaxJson = new AjaxJson();
		String perforType = StringUtil.getEncodePra(req.getParameter("perforType"));
		String perforDetail = StringUtil.getEncodePra(req.getParameter("perforDetail"));
		String perforName = StringUtil.getEncodePra(req.getParameter("perforName"));
		String sql = "select distinct t.score from t_s_performance_base t where 1=1 ";
		if(perforName!=null){
			sql += " and t.perfor_name like'"+"%"+perforName.trim()+"%"+"'";
		}
		if(perforType!=null){
			sql += " and t.perfor_type like '"+"%"+perforType.trim()+"%"+"'";
		}
		if(perforDetail!=null){
			sql += " and t.perfor_detail like '"+"%"+perforDetail.trim()+"%"+"'";
		}
		List<Double> scoreList = this.systemService.findListbySql(sql);
		
		String options = "";
		for (Double score : scoreList) {
			options += "<option value=\""+score+"\">"+score+"</option>";
		}
		ajaxJson.setMsg(options);
		return ajaxJson;
	}
	
	
	/**
	 * 删除绩效
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSPerformanceEntity tsperformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tsperformance = systemService.getEntity(TSPerformanceEntity.class, tsperformance.getId());
		String subStatusString = tsperformance.getSubStatus();
		
		if((ClientManager.getInstance().getClient().getUser().getUserName().equals("10100152")||subStatusString.equals("未处理"))||
				(ClientManager.getInstance().getClient().getUser().getCreateName().equals("管理员"))){
			message = "删除成功";
			 tsperformanceService.delete(tsperformance);
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
	public AjaxJson save(TSPerformanceEntity tsperformance, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		
		String performanceBaseId = oConvertUtils.getString(request.getParameter("baseid"));
		String userid = oConvertUtils.getString(request.getParameter("userid"));
		String departid = oConvertUtils.getString(request.getParameter("departid"));
		
		if (StringUtil.isNotEmpty(performanceBaseId)) {
			TSPerformanceBaseEntity baseEntity = systemService.get(TSPerformanceBaseEntity.class, performanceBaseId);
			TSUser user = systemService.get(TSUser.class, userid);
			TSDepart depart = systemService.get(TSDepart.class, departid);
			tsperformance.setPerformanceBaseEntity(baseEntity);
			tsperformance.setUser(user);
			tsperformance.setDepart(depart);
		}
		System.out.println(ClientManager.getInstance().getClient().getUser().getUserName()+"员工工号");
		if((!ClientManager.getInstance().getClient().getUser().getUserName().equals("10100152"))
				||(ClientManager.getInstance().getClient().getUser().getCreateName().equals("管理员"))){
			message = "你不能进行编辑操作";
		}
		
			
		if (StringUtil.isNotEmpty(tsperformance.getId())) {
			if((ClientManager.getInstance().getClient().getUser().getUserName().equals("10100152"))||
					(ClientManager.getInstance().getClient().getUser().getCreateName().equals("管理员"))){
			
			TSPerformanceEntity t = tsperformanceService.get(TSPerformanceEntity.class, tsperformance.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(tsperformance, t);
				tsperformanceService.saveOrUpdate(t);
				message = "更新成功";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			   }
			}
		}
			
		else {
			message = "添加成功";
			tsperformance.setSubStatus("未处理");
			tsperformanceService.save(tsperformance);
		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tsperformance);
		return j;
	}
	
	/**
	 * 发送邮件
	 * @param tsVechicleFee
	 */
	private void sendMail(TSPerformanceEntity tsperformance) {
		tsperformance = systemService.getEntity(TSPerformanceEntity.class, tsperformance.getId());
		String email = tsperformance.getEmail();
		MailSenderInfo mailInfo = new MailSenderInfo(); 
		String title = "员工绩效处理通知";
		String content = tsperformance.getRealName()+",您好！"+"你的绩效发生变化："+tsperformance.getPerforName()
		+":"+tsperformance.getPerforDetail()+","+tsperformance.getPerformanceDesc()+tsperformance.getScore();
		String towho = email;
		 mailInfo.setMailServerHost("mail.rundamedical.com");    
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("WMS_ALERT");   //用户名 
	      mailInfo.setPassword("111111");//用户密码
	      mailInfo.setFromAddress("WMS_ALERT@rundamedical.com");    
	      mailInfo.setToAddress(towho);    
	      mailInfo.setSubject(title);    
	      mailInfo.setContent(content);    
	    //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	          sms.sendTextMail(mailInfo);//发送文体格式    
	       //   System.out.println(mailInfo);
	}
	
	
	
	
	/**
	 * 绩效管理页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TSPerformanceEntity tsperformance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tsperformance.getId())) {
			tsperformance = tsperformanceService.getEntity(TSPerformanceEntity.class, tsperformance.getId());
			req.setAttribute("tsperformancePage", tsperformance);
		}
		
		List<TSPerformanceBaseEntity> performanceBaseList = systemService.getList(TSPerformanceBaseEntity.class);
		List<String> performanceNameList = new ArrayList<String>();
		for (TSPerformanceBaseEntity performanceBase : performanceBaseList) {
			if(!performanceNameList.contains(performanceBase.getPerforName())){
				performanceNameList.add(performanceBase.getPerforName());
			}
		}
		List<TSUserBaseInfoEntity> userBaseList = systemService.getList(TSUserBaseInfoEntity.class);
		List<String> departNameList = new ArrayList<String>();
		for (TSUserBaseInfoEntity userBase : userBaseList) {
			if(!departNameList.contains(userBase.getDepartName())){
				departNameList.add(userBase.getDepartName());
			}
		}
		
		req.setAttribute("departNameList", departNameList);
		req.setAttribute("performanceNameList", performanceNameList);
		
		
		return new ModelAndView("system/performance/performanceInfo");
	}
	

	/**
	 * 绩效基础信息跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "performanceBases")
	public ModelAndView performanceBases(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("system/performance/performanceBases");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	

	/**
	 * 绩效基础信息显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridPerformanceBase")
	public void datagridPerformanceBase(TSPerformanceBaseEntity performanceBase, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSPerformanceBaseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, performanceBase);
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}


	/**
	 * 部门信息跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "departs")
	public ModelAndView departs(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("system/performance/performanceDeparts");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	

	/**
	 * 部门信息显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridDepart")
	public void datagridDepart(TSDepart depart, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSDepart.class, dataGrid);
		//查询条件组装器
		if(StringUtil.isNotEmpty(depart.getDepartname())){
			depart.setDepartname("*"+depart.getDepartname()+"*");
			}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, depart);
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 用户信息跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "users")
	public ModelAndView users(HttpServletRequest request) {
	
		ModelAndView mv = new ModelAndView("system/performance/performanceUsers");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}
	

	/**
	 * 用户信息显示列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagridUser")
	public void datagridUser(TSUser user, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSUser.class, dataGrid);
		//查询条件组装器
		
		if(StringUtil.isNotEmpty(user.getUserName())){
			user.setUserName("*"+user.getUserName()+"*");
			}
		if(StringUtil.isNotEmpty(user.getRealName())){
			user.setRealName("*"+user.getRealName()+"*");
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, user);
		this.systemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
}
