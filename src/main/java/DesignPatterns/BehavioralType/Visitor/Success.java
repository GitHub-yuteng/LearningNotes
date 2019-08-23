package DesignPatterns.BehavioralType.Visitor;

public class Success extends Action {

    @Override
    public void getManResult(Man man) {
        System.out.println("Man 评价成功！");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("Woman 评价成功！");
    }
}
