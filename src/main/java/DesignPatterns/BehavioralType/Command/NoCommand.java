package DesignPatterns.BehavioralType.Command;

//空执行：省去空判断
public class NoCommand implements Command {

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
