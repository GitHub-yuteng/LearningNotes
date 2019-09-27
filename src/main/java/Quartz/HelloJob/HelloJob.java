package Quartz.HelloJob;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yu
 */
//TODO 加注解 使 JobDataMap 变成有状态 Job，每次调用都会对 Job进行持久化 ，使用同一个JobDataMap，是参数可以累加复用
@PersistJobDataAfterExecution
public class HelloJob implements Job {

    public HelloJob() {
        //TODO 每次调度器执行Job时，在调用execute方法前都会创建一个新的Job实例。
        //TODO 当调用完成后，关联的Job对象实例会被释放，被垃圾GC回收。
        System.out.println("Instance...");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //TODO 输出当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date());
        System.out.println(dateString);

        //TODO JobExecutionContext context
        //TODO 获取JobDetail内容
        JobKey key = context.getJobDetail().getKey();
        System.out.println(key.getName() + "--" + key.getGroup() + "--" + key.getClass().getName() + "--" + key.getClass().getSimpleName());
        //TODO 获取JobDetail —>JobDataMap
        String jobDetailDataMap = (String) context.getJobDetail().getJobDataMap().get("JobDetail");
        System.out.println("JobDetailDataMap：" + jobDetailDataMap);
        Integer count = (Integer) context.getJobDetail().getJobDataMap().get("count");
        ++count;
        System.out.println("count：------------->" + count);//TODO 每次都创建新的 JobDataMap 无状态 Job
        //TODO 加注解 使 JobDataMap 变成有状态 Job
        context.getJobDetail().getJobDataMap().put("count", count);

        //TODO 获取Trigger内容
        System.out.println("Trigger：" + context.getTrigger());
        //TODO 获取Trigger —>JobDataMap
        String triggerDataMap = (String) context.getTrigger().getJobDataMap().get("Trigger");
        System.out.println("JobDetailDataMap：" + triggerDataMap);

        //TODO 当前任务的执行时间
        System.out.println("当前任务执行时间：" + context.getFireTime());
        System.out.println("下一次任务执行时间：" + context.getNextFireTime());
    }
}
