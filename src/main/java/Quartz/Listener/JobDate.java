package Quartz.Listener;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yu
 */
public class JobDate implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //TODO 输出当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date());
        System.out.println(dateString);
    }
}
