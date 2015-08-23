package org.jeecgframework.web.system.service.impl;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.FileUtils;
import org.jeecgframework.web.system.pojo.base.TSProjectEntity;
import org.jeecgframework.web.system.pojo.base.TSProjectFilesEntity;
import org.jeecgframework.web.system.service.TSProjectServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tsprojectService")
@Transactional
public class TSProjectServiceImpl extends CommonServiceImpl implements
		TSProjectServiceI {

	@Override
	public void deleteFile(TSProjectFilesEntity projectfile) {
		//[1].删除附件
				String sql = "select * from t_s_attachment where id = ?";
				Map<String, Object> attachmentMap = commonDao.findOneForJdbc(sql, projectfile.getId());
				//附件相对路径
				String realpath = (String) attachmentMap.get("realpath");
				String fileName = FileUtils.getFilePrefix2(realpath);
				
				//获取部署项目绝对地址
				String realPath = ContextHolderUtils.getSession().getServletContext().getRealPath("/");
				FileUtils.delete(realPath+realpath);
				FileUtils.delete(realPath+fileName+".pdf");
				FileUtils.delete(realPath+fileName+".swf");
				//[2].删除数据
				commonDao.delete(projectfile);

	}

	@Override
	public void deleteProject(TSProjectEntity project) {
		//[1].上传附件删除
				String attach_sql = "select * from t_s_attachment where id in (select id from t_s_project_files where projectId = ?)";
				List<Map<String, Object>> attachmentList = commonDao.findForJdbc(attach_sql, project.getId());
				for(Map<String, Object> map:attachmentList){
					//附件相对路径
					String realpath = (String) map.get("realpath");
					String fileName = FileUtils.getFilePrefix2(realpath);
					
					//获取部署项目绝对地址
					String realPath = ContextHolderUtils.getSession().getServletContext().getRealPath("/");
					FileUtils.delete(realPath+realpath);
					FileUtils.delete(realPath+fileName+".pdf");
					FileUtils.delete(realPath+fileName+".swf");
				}
				//[2].删除项目管理
				commonDao.delete(project);
			}

}
