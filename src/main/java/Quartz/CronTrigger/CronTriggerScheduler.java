package Quartz.CronTrigger;

import Quartz.SimpleTrigger.JobSimple;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author Yu
 */
public class CronTriggerScheduler {
    public static void main(String[] args) throws Exception {
        //TODO 调度器  scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //TODO 开始时间
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 1000);

        //TODO 开始时间
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 10000);

        //TODO 任务实例 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(CronJob.class)//TODO 加载任务类，与任务类完成绑定；
                .withIdentity("job1", "group1")//TODO 参数1：任务的名称（唯一实例）；参数2：任务组的名称
                .build();

        //TODO 触发器 Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "tgroup1")
                .startAt(startDate)
                .endAt(endDate)//TODO 设置结束时间，优先级高。重复次数在结束之前执行
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))//日历
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();//TODO 启动
    }
}
