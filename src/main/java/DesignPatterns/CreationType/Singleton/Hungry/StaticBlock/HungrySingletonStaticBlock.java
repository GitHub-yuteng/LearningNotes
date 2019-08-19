package DesignPatterns.CreationType.Singleton.Hungry.StaticBlock;

/**
 * @author Yu
 */
public class HungrySingletonStaticBlock {
    public static void main(String[] args) {
        System.out.println("======HungrySingletonStaticBlock======");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
