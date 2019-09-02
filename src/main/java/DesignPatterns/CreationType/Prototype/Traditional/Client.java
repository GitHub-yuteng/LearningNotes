package DesignPatterns.CreationType.Prototype.Traditional;

/**
 * @author Yu
 */
public class Client {

    public static void main(String[] args) {
        //TODO 传统模式
        Sheep sheep = new Sheep("Tom", 1, "白色");

        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());

        System.out.println("sheep：" + sheep);
        System.out.println("sheep1：" + sheep1);
        System.out.println("sheep2：" + sheep2);
        System.out.println("sheep3：" + sheep3);
    }
}
