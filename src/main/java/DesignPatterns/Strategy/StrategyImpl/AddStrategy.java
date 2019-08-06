package DesignPatterns.Strategy.StrategyImpl;

import DesignPatterns.Strategy.Strategy;

//TODO 定义具体的算法类
//TODO 实现两个整数的加减乘除运算，但是外部调用形式需要符合接口的定义。
public class AddStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}