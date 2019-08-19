package DesignPatterns.CreationType.Singleton.LazyLoading.DCL;

//TODO 单例 —— 懒汉式 DCL

public class LazyLoadingSingletonDCL {
    public static void main(String[] args) {
        System.out.println("======LazyLoadingSingletonDCL======");
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {

    // 将自身实例化对象设置为一个属性，并用static修饰
    private volatile static Singleton instance;

    // 构造方法私有化
    private Singleton() {
    }

    // 静态方法返回该实例
    public static Singleton getInstance() {
        // 第一次检查instance是否被实例化出来
        if (instance == null) {
            synchronized (Singleton.class) {
                // 某个线程取得了类锁，实例化对象前第二次检查 instance 是否已经被实例化
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}