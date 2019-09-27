package Quartz.Listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author Yu
 */
public class JobDetailListener implements JobListener {
    @Override
    public String getName() {
        String simpleName = this.getClass().getSimpleName();
//        System.out.println("监听器名称：" + simpleName);
        return simpleName;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        //TODO Scheduler 在 JobDetail将要被执行时调用的方法
        String name = context.getJobDetail().getKey().getName();
        System.out.println("执行前：" + name);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        //TODO Scheduler在JobDetail即将被执行，但又被TriggerListener否决时调用该方法
        String name = context.getJobDetail().getKey().getName();
        System.out.println("执行前否决：" + name);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        //TODO Scheduler 在 JobDetail 执行之后调用的方法
        String name = context.getJobDetail().getKey().getName();
        System.out.println("执行后：" + name);
    }
}
