package DesignPatterns.BehavioralType.Visitor;

public class Fail extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("Man 评价失败！");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("Woman 评价失败！");
    }
}
