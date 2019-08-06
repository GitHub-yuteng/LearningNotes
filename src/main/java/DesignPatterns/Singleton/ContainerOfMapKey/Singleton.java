package DesignPatterns.Singleton.ContainerOfMapKey;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private static Map<String, Object> objMap = new HashMap<>();

    private Singleton() {
    }

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}