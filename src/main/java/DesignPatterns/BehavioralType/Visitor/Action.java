package DesignPatterns.BehavioralType.Visitor;

public abstract class Action {
    //得到男人的测评
    public abstract void getManResult(Man man);

    //得到女人的测评
    public abstract void getWomanResult(Woman woman);
}
