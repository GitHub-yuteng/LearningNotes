package DesignPatterns.BehavioralType.Command;

public class TVOffCommand implements Command {

    // 聚合 TVReceiver
    TVReceiver tv;

    public TVOffCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        //调用接收者方法
        tv.off();
    }

    @Override
    public void undo() {
        //调用接收者方法
        tv.on();
    }
}
