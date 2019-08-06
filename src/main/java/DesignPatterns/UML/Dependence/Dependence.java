package DesignPatterns.UML.Dependence;

/**
 * @author Yu
 * 类中用到了对方；
 * 类的成员属性；
 * 方法的返回类型；
 * 方法接收的参数类型；
 * 方法中使用到；
 */
public class Dependence {
    A a;//TODO 类的成员属性

    public A save(B b) {//TODO 方法接收的参数类型
        //TODO 方法的返回类型
        System.out.println("");
        A a = new A();//TODO 方法中使用到
        return a;
    }
}

class A {
}

class B {
}
