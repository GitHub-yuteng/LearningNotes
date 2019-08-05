package DesignPatterns.Principle.SingleResponsility;

/**
 * @author Yu
 * //TODO  单一职责
 * <p>
 * 单一职责原则注意事项和细节
 * 1、降低类的复杂度，一个类只负责一项职责。
 * 2、提高类的可读性，可维护性
 * 3、降低变更引起的风险
 * 4、通常情况下，我们应当遵守单一职责原则， 只有逻辑足够简单，才可以在代码级违反单一职责原则
 * <p>
 * //TODO ：只有类中方法数量足够少，可以在方法级别保持单一职责原则
 */
public class SingleResponsility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("布加迪威龙");
        vehicle.fly("波音747");
    }
}

// 逻辑简单 方法级别单一职责
// 逻辑复杂，分类实现单一职责
class Vehicle {

    public void run(String string) {
        System.out.println(string + "：是陆地交通工具");
    }

    public void fly(String string) {
        System.out.println(string + "：是空中交通工具");
    }
}