package DesignPatterns.CreationType.Singleton.Enum;

public class EnumSingleton {
    public static void main(String[] args) {
        System.out.println("======EnumSingleton======");
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println("instance1 == instance2：" + (instance1 == instance2));//true

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        instance1.method();
        instance2.method();
    }
}

enum Singleton {
    INSTANCE;

    public void method() {
        System.out.println("EnumSingleton");
    }
}