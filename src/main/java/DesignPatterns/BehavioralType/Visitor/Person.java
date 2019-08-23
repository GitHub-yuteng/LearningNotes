package DesignPatterns.BehavioralType.Visitor;

public abstract class Person {

    //提供一个方法，访问者可以访问
    public abstract void accept(Action action);
}
