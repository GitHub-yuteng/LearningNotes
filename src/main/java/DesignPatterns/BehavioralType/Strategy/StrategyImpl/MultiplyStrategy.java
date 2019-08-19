package DesignPatterns.BehavioralType.Strategy.StrategyImpl;

import DesignPatterns.BehavioralType.Strategy.Strategy;

//TODO 乘法运算 实现公共接口
public class MultiplyStrategy implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}