package DesignPatterns.BehavioralType.Visitor;

public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
