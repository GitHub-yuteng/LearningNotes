package DesignPatterns.Principle.CompositeReuse;

/**
 * @author Yu
 * //TODO 合成复用原则  尽量使用合成/聚合的方式，而不是使用继承
 */
public class CompositeReuse {
    public static void main(String[] args) {
        System.out.println("------依赖------");
        B b = new B();
        b.Operation1(new A());

        System.out.println("------聚合------");
        b.setA(new A());
        b.Operation2();

        System.out.println("------组合------");
        b.Operation3();
    }
}

class A {
    void Operation1() {
        System.out.println("A Operation1");
    }

    void Operation2() {
        System.out.println("A Operation2");
    }

    void Operation3() {
        System.out.println("A Operation3");
    }
}

//如果只是需要用到 A类的方法，尽量不要使用继承。而是使用，依赖，聚合，组合的方式
class B {
    void Operation1(A a) {//TODO 依赖
        a.Operation1();
        a.Operation2();
        a.Operation3();
    }

    A a;

    public void setA(A a) {
        this.a = a;
    }

    void Operation2() {//TODO 聚合
        a.Operation1();
        a.Operation2();
        a.Operation3();
    }

    A a1 = new A();

    void Operation3() {//TODO 组合
        a1.Operation1();
        a1.Operation2();
        a1.Operation3();
    }
}
