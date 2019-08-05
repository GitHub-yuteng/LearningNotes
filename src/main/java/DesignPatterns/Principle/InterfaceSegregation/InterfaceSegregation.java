package DesignPatterns.Principle.InterfaceSegregation;

/**
 * @author Yu
 * <p>
 * TODO 接口隔离原则
 * <p>
 * 应传统方法的问题和使用接口隔离原则改进
 * 1、类A通过接口 Interface1 依赖类B，类C通过接口 Interface1 依赖类D,如果接口
 * Interface1对于类A和类C来说不是最小接口，那么类B和类D必须去实现他们不
 * 需要的方法
 * 2、将接口Interface1拆分为独立的几个接口，类A和类C分别与他们需要的接口建立
 * 依赖关系。也就是采用接口隔离原则
 * 3、接口Interface中出现的方法，根据实际情祝拆分为三个接口
 */
public class InterfaceSegregation {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface interface1 {
    void Operation1();
}

interface interface2 {
    void Operation2();

    void Operation3();
}

interface interface3 {
    void Operation4();

    void Operation5();
}

class B implements interface1, interface2 {

    @Override
    public void Operation1() {
        System.out.println("B 实现了 Operation1");
    }

    @Override
    public void Operation2() {
        System.out.println("B 实现了 Operation2");
    }

    @Override
    public void Operation3() {
        System.out.println("B 实现了 Operation3");
    }
}

class D implements interface1, interface3 {

    @Override
    public void Operation1() {
        System.out.println("D 实现了 Operation1");
    }

    @Override
    public void Operation4() {
        System.out.println("D 实现了 Operation4");
    }

    @Override
    public void Operation5() {
        System.out.println("D 实现了 Operation5");
    }
}

class A {

    public void depend1(interface1 i) {
        i.Operation1();
    }

    public void depend2(interface2 i) {
        i.Operation2();
    }

    public void depend3(interface2 i) {
        i.Operation3();
    }
}

class C {

    public void depend1(interface1 i) {
        i.Operation1();
    }

    public void depend4(interface3 i) {
        i.Operation4();
    }

    public void depend5(interface3 i) {
        i.Operation5();
    }
}
