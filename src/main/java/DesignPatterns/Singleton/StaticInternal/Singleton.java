package DesignPatterns.Singleton.StaticInternal;

public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.Instance;
    }

    private static class SingletonHolder {
        private static final Singleton Instance = new Singleton();
    }
}