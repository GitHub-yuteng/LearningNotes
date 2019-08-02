package Juc;

public class Singleton {

    // 将自身实例化对象设置为一个属性，并用static修饰
    // 因为有指令重排序的存在， DCL不一定安全。但是加了 volatile 可以禁止指令重排序。
    private volatile static Singleton instance;

    // 构造方法私有化
    private Singleton() {
    }

    // 静态方法返回该实例
    public static Singleton getInstance() {
        // 第一次检查instance是否被实例化出来，如果没有进入if块
        if (instance == null) {
            synchronized (Singleton.class) {
                // 某个线程取得了类锁，实例化对象前第二次检查instance是否已经被实例化出来，如果没有，才最终实例出对象
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}