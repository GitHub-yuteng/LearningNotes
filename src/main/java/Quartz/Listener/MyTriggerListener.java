package Quartz.Listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @author Yu
 */
public class MyTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        String simpleName = this.getClass().getSimpleName();
        return simpleName;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        String name = trigger.getKey().getName();
        System.out.println(name + "-> 被触发！triggerFired");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        String name = trigger.getKey().getName();
        System.out.println(name + "-> vetoJobExecution");
        return false; //TODO false表示会执行Job的方法。 true 表示不会执行Job方法
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        String name = trigger.getKey().getName();
        System.out.println(name + "-> 错过触发！triggerMisfired");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        String name = trigger.getKey().getName();
        System.out.println(name + "-> 触发并且完成Job！triggerComplete");

        System.out.println("================================================");
    }
}
