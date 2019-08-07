package DesignPatterns.Singleton.ContainerOfMapKey;

import java.util.HashMap;
import java.util.Map;

public class ContainerOfMapKeySingleton {
    public static void main(String[] args) {
        System.out.println("======ContainerOfMapKeySingleton======");
        Singleton.registerService("Singleton", new Object());
        Object instance1 = Singleton.getService("Singleton");
        Object instance2 = Singleton.getService("Singleton");

        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {
    private static Map<String, Object> objMap = new HashMap<>();

    public Singleton() {}

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}