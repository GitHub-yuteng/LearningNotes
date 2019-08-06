package DesignPatterns.Strategy;

//TODO 定义具体的环境角色
//TODO 持有接口的引用，并且有get和set方法可以完成策略更换。在环境角色中调用接口的方法完成动作。
public class Context {

    private Strategy strategy;
    
    public Context(Strategy strategy) {
        super();
        this.strategy = strategy;
    }
    public Strategy getStrategy() {
        return strategy;
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public int calculate(int a,int b){
        return strategy.calculate(a, b);
    }
}