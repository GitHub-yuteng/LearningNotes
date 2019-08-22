package DesignPatterns.BehavioralType.Command;

public class TVOnCommand implements Command {

	// 聚合 TVReceiver
	TVReceiver tv;

	public TVOnCommand(TVReceiver tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {
		//调用接收者方法
		tv.on();
	}

	@Override
	public void undo() {
		//调用接收者方法
		tv.off();
	}
}
