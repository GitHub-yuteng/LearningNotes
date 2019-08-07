package DesignPatterns.Singleton.Hungry.StaticInstance;

/**
 * @author Yu
 */
//TODO  饿汉式 —— 静态常量
public class HungrySingletonStaticInstance {
    public static void main(String[] args) {
        System.out.println("======HungrySingletonStaticInstance======");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {

    // 将自身实例化对象设置为一个属性，并用static、final修饰
    private final static Singleton instance = new Singleton();

    // 构造方法私有化
    private Singleton() {
    }

    // 提供静态方法返回该实例
    public static Singleton getInstance() {
        return instance;
    }
}
