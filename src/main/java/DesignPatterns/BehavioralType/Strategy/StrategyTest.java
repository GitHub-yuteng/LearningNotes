package DesignPatterns.BehavioralType.Strategy;

import DesignPatterns.BehavioralType.Strategy.StrategyImpl.AddStrategy;
import DesignPatterns.BehavioralType.Strategy.StrategyImpl.DivisionStrategy;
import DesignPatterns.BehavioralType.Strategy.StrategyImpl.MultiplyStrategy;
import DesignPatterns.BehavioralType.Strategy.StrategyImpl.SubstractStrategy;

//TODO 只需向环境角色设置相应的算法类，然后就可以得到相应的结果。
public class StrategyTest {
    public static void main(String[] args) {
        //加法
        Context context = new Context(new AddStrategy());
        System.out.println(context.calculate(10, 5));
        //减法
        Context context2 = new Context(new SubstractStrategy());
        System.out.println(context2.calculate(3, 2));
        //乘法
        Context context3 = new Context(new MultiplyStrategy());
        System.out.println(context3.calculate(6, 8));
        //除法
        Context context4 = new Context(new DivisionStrategy());
        System.out.println(context4.calculate(90, 9));
    }
}