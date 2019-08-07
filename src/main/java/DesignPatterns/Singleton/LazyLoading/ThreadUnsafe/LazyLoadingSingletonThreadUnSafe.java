package DesignPatterns.Singleton.LazyLoading.ThreadUnsafe;

/**
 * @author Yu
 */
//TODO 懒汉式 —— 线程不安全

public class LazyLoadingSingletonThreadUnSafe {
    public static void main(String[] args) {
        System.out.println("======LazySingletonThreadUnsafe======");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {

    // 将自身实例化对象设置为一个属性，并用static修饰
    private static Singleton instance;

    // 构造方法私有化
    private Singleton() {
    }

    // 静态方法返回该实例
    public static Singleton getInstance() {
        if (instance == null) {
            //TODO 线程在这里被阻塞，则此时对象没有被创建，UnSafe
            instance = new Singleton();
        }
        return instance;
    }
}
