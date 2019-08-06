package DesignPatterns.Singleton.Hungry;

/**
 * @author Yu
 */

//TODO 简单单例  —— 饿汉式
public class Singleton {

    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    private static Singleton getInstance() {
        return instance;
    }
}
