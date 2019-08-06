package DesignPatterns.Strategy.StrategyImpl;

import DesignPatterns.Strategy.Strategy;

//TODO 除法运算 实现公共接口
public class DivisionStrategy  implements Strategy {
    @Override
    public int calculate(int a, int b) {
        if(b!=0){
            return a/b;
        }
        else {
            throw new RuntimeException("除数不能为零");
        }
    }
}