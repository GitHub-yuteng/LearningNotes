package DesignPatterns.Singleton.Lazy;

/**
 * @author Yu
 */
//TODO 单例 —— 懒汉式 Sync
public class Singleton {

    // 构造方法私有化
    private Singleton() {
    }

    // 将自身实例化对象设置为一个属性，并用static修饰
    private static Singleton instance;

    // 静态方法返回该实例
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
