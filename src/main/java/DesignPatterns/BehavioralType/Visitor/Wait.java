package DesignPatterns.BehavioralType.Visitor;

public class Wait extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("Man 评价待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("Woman 评价待定");
    }
}
