package org.jeecgframework.core.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.httpclient.util.DateUtil;
import org.jeecgframework.core.util.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Job {

 
    //@Scheduled(cron="*/10 * * * * *") 
   /* public void s10(){
        org.jeecgframework.core.util.LogUtil.info("==== 十秒执行一次=======10s");
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(cal.getTime());
        
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }*/
//    
//    @Scheduled(cron="0 */1 * * * *") 
//    public void m1(){
//        org.jeecgframework.core.util.LogUtil.info("1m");
//    }
    
    /**
     * 每天1点执行一次
     * */
    @Scheduled(cron="0 0 1 * * ?") 
    public void oneOClockPerDay(){
        org.jeecgframework.core.util.LogUtil.info("1h");
    }
    
    
    
}