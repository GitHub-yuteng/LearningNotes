package Quartz.Listener;

import org.quartz.*;

/**
 * @author Yu
 */
public class MySchedulerListener implements SchedulerListener {
    @Override
    public void jobScheduled(Trigger trigger) {
        //TODO 用于部署 JobDetail 时调用
        System.out.println("SchedulerListener...jobScheduled... 部署");
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        //TODO 用于卸载 JobDetail 时调用
        System.out.println("SchedulerListener...jobUnscheduled... 卸载");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        System.out.println("SchedulerListener...triggerFinalized... 移除");
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        System.out.println("SchedulerListener...triggerPaused... TriggerKey 暂停");
    }

    @Override
    public void triggersPaused(String triggerGroup) {
        System.out.println("SchedulerListener...triggersPaused... triggerGroup 暂停");
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        System.out.println("SchedulerListener...triggerResumed... TriggerKey 暂停中恢复！");
    }

    @Override
    public void triggersResumed(String triggerGroup) {
        System.out.println("SchedulerListener...triggerResumed... triggerGroup 暂停中恢复！");
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        System.out.println("SchedulerListener...jobAdded... 添加工作任务！");
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        System.out.println("SchedulerListener...jobDeleted... 删除工作任务！");
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        System.out.println("SchedulerListener...jobPaused... JobKey 暂停工作任务！");
    }

    @Override
    public void jobsPaused(String jobGroup) {
        System.out.println("SchedulerListener...jobPaused... jobGroup 暂停工作组！");
    }

    @Override
    public void jobResumed(JobKey jobKey) {
        System.out.println("SchedulerListener...jobResumed... jobGroup 恢复工作任务！");
    }

    @Override
    public void jobsResumed(String jobGroup) {
        System.out.println("SchedulerListener...jobResumed... jobGroup 恢复工作组！");
    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {
        System.out.println("SchedulerListener...schedulerError... 运行期间产生严重错误！" + msg + " " + cause.getUnderlyingException());
    }

    @Override
    public void schedulerInStandbyMode() {
        System.out.println("SchedulerListener...schedulerInStandbyMode... 当 scheduler 处于挂起standBy模式下...");
    }

    @Override
    public void schedulerStarted() {
        System.out.println("SchedulerListener...schedulerStarted... 开启 scheduler...");
    }

    @Override
    public void schedulerStarting() {
        System.out.println("SchedulerListener...schedulerStarting... 正在开启 scheduler...");
    }

    @Override
    public void schedulerShutdown() {
        System.out.println("SchedulerListener...schedulerShutdown... 关闭 scheduler...");
    }

    @Override
    public void schedulerShuttingdown() {
        System.out.println("SchedulerListener...schedulerShutdown... 正在关闭 scheduler...");
    }

    @Override
    public void schedulingDataCleared() {
        System.out.println("SchedulerListener...schedulingDataCleared... 数据被清除... scheduler...");
    }
}
