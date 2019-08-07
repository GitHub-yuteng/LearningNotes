package DesignPatterns.Singleton.LazyLoading.SyncLazy;

public class LazyLoadingSingletonSync {
    public static void main(String[] args) {
        System.out.println("======LazyLoadingSingletonSync======");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {

    // TODO 将自身实例化对象设置为一个属性，并用 volatile、static修饰
    private volatile static Singleton instance;

    // 构造方法私有化
    private Singleton() {
    }

    // 静态方法返回该实例
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}