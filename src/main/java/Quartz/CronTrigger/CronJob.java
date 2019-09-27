package Quartz.CronTrigger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yu
 */
public class CronJob implements org.quartz.Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //TODO 输出当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date());
        System.out.println(dateString);
    }
}
