package Quartz.Listener;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

import java.util.Date;

/**
 * @author Yu
 */
public class ListenerScheduler {
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
        JobDetail jobDetail = JobBuilder.newJob(JobDate.class)//TODO 加载任务类，与任务类完成绑定；
                .withIdentity("job1", "group1")//TODO 参数1：任务的名称（唯一实例）；参数2：任务组的名称
                .build();

        //TODO 触发器 Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "tgroup1")//TODO 参数1：触发器的名称（唯一实例）；参数2：触发器组的名称
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(3))
                .build();

        //TODO 让调度器关联任务和触发器，保证按照触发器的条件执行任务
        scheduler.scheduleJob(jobDetail, trigger);

        //TODO 创建一个全局 JobDetail Listener
        scheduler.getListenerManager().addJobListener(new JobDetailListener(), EverythingMatcher.allJobs());//TODO 全局

        //TODO 创建一个局部 JobDetail Listener  表示指定的任务 Job
//        scheduler.getListenerManager().addJobListener(new JobDetailListener(), KeyMatcher.keyEquals(JobKey.jobKey("job1", "group1")));


        //TODO 创建一个全局 Trigger Listener
//        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),EverythingMatcher.allTriggers());//TODO 全局

        //TODO 创建一个局部 Trigger Listener
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),
                KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger1", "tgroup1")));

        //TODO 创建一个全局 scheduler  Listener
        scheduler.getListenerManager().addSchedulerListener(new MySchedulerListener());

        scheduler.start();//TODO 启动

        Thread.sleep(7000L);//TODO 延迟7秒关闭

        scheduler.shutdown();
    }
}
