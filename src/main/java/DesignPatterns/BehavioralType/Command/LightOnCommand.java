package DesignPatterns.BehavioralType.Command;

public class LightOnCommand implements Command {

    // 聚合 LightReceiver
    LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者方法
        light.on();
    }

    @Override
    public void undo() {
        //调用接收者方法
        light.off();
    }
}
