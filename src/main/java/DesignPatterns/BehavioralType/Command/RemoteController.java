package DesignPatterns.BehavioralType.Command;

public class RemoteController {

    Command[] onCommands;//打开
    Command[] offCommands;//关闭
    Command undoCommand;//撤销

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开按钮
    public void onButtonWasPushed(int no) {// no=1
        onCommands[no].execute();
        undoCommand = onCommands[no];//记录操作，用于撤销
    }

    //按下关按钮
    public void offButtonWasPushed(int no) { // no=0
        offCommands[no].execute();
        undoCommand = offCommands[no];//记录操作，用于撤销
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
