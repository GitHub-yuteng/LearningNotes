package Quartz.HelloJobTrigger;

import Quartz.HelloJob.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author Yu
 */
public class TriggerScheduler {
    public static void main(String[] args) throws Exception {
        //TODO 调度器  scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //TODO 开始时间
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 1000);

        //TODO 结束时间
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 10000);//TODO 推迟十秒

        //TODO 任务实例 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(JobTrigger.class)//TODO 加载任务类，与任务类完成绑定；
                .withIdentity("job1", "group1")//TODO 参数1：任务的名称（唯一实例）；参数2：任务组的名称
                .usingJobData("JobDetail", "任务详情")
                .build();

        //TODO 触发器 Trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "tgroup1")//TODO 参数1：触发器的名称（唯一实例）；参数2：触发器组的名称
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1))
                .build();

        //TODO 让调度器关联任务和触发器，保证按照触发器的条件执行任务
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();//TODO 启动
    }
}
