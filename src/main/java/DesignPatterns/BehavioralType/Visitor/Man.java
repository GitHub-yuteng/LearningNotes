package DesignPatterns.BehavioralType.Visitor;

public class Man extends Person {

	@Override
	public void accept(Action action) {
		action.getManResult(this);
	}
}
