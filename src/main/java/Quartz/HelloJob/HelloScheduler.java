package Quartz.HelloJob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Yu
 */
public class HelloScheduler {
    public static void main(String[] args) throws Exception {
        //TODO 调度器  scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //TODO 任务实例 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)//TODO 加载任务类，与任务类完成绑定；
                .withIdentity("job1", "group1")//TODO 参数1：任务的名称（唯一实例）；参数2：任务组的名称
                .usingJobData("JobDetail", "任务详情")
                .usingJobData("count", 0)
                .build();

        System.out.println("name：" + jobDetail.getKey().getName());
        System.out.println("group：" + jobDetail.getKey().getGroup());//TODO 如果没有指定，默认 default
        System.out.println("jobClass：" + jobDetail.getJobClass().getName());

        //TODO 触发器 Trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "tgroup1")//TODO 参数1：触发器的名称（唯一实例）；参数2：触发器组的名称
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))
                .usingJobData("Trigger", "触发器详情")
                .build();

        //TODO 让调度器关联任务和触发器，保证按照触发器的条件执行任务
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();//TODO 启动

        //TODO 挂起
//        scheduler.standby();

        /**
         * shutdown(true):表示等待所有正在执行的job执行完毕之后，再关闭Scheduler;
         * shutdown(false):表示直接关闭Scheduler。
         */
        //TODO 关闭
        scheduler.shutdown(true);

        //TODO 重新启动任务
        scheduler.start();
    }
}
