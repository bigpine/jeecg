package org.jeecgframework.web.sendmail.util; 

public class Snippet {
	public static void main(String[] args){   
	         //这个类主要是设置邮件   
	      MailSenderInfo mailInfo = new MailSenderInfo(); 
	      String biaoti ="邮件标题内容";
	      String neirong = "邮件内容信息";
	      String towho="liudasong@rundamedical.com";
	      mailInfo.setMailServerHost("mail.rundamedical.com");    
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName("WMS_ALERT");   //用户名 
	      mailInfo.setPassword("111111");//用户密码
	      mailInfo.setFromAddress("WMS_ALERT@rundamedical.com");    
	      mailInfo.setToAddress(towho);    
	      mailInfo.setSubject(biaoti);    
	      mailInfo.setContent(neirong);    
	    //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	          sms.sendTextMail(mailInfo);//发送文体格式    
	          System.out.println(mailInfo);
	       //  sms.sendHtmlMail(mailInfo);//发送html格式   
	    }  
	
}
