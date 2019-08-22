package DesignPatterns.BehavioralType.Command;

public class LightOffCommand implements Command {

    // 聚合 LightReceiver
    LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        super();
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者方法
        light.off();
    }

    @Override
    public void undo() {
        //调用接收者方法
        light.on();
    }
}
