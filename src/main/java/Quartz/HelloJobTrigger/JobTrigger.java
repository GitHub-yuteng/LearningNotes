package Quartz.HelloJobTrigger;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yu
 */
public class JobTrigger implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //TODO 输出当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date());
        System.out.println(dateString);

        //TODO 获取 Key、JobKey、startTime、endTime
        Trigger trigger = context.getTrigger();
        System.out.println(trigger.getJobKey());//TODO getJobKey获取的是JobDetail属性。group1.job1
        System.out.println(trigger.getKey());//TODO getKey获取的是Trigger属性。tgroup1.trigger1

        System.out.println("任务开始时间：" + simpleDateFormat.format(trigger.getStartTime()) + "--> 任务结束时间：" + simpleDateFormat.format(trigger.getEndTime()));
    }
}