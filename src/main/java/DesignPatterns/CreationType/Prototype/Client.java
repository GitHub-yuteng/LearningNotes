package DesignPatterns.CreationType.Prototype;

/**
 * @author Yu
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        //TODO 传统模式
        Sheep sheep = new Sheep("Tom", 1, "黑色");

        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();

        System.out.println("sheep：" + sheep);
        System.out.println("sheep1：" + sheep1);
        System.out.println("sheep2：" + sheep2);
    }
}
