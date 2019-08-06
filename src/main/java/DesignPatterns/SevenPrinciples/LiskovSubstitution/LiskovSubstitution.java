package DesignPatterns.SevenPrinciples.LiskovSubstitution;

/**
 * @author Yu
 * TODO 里氏替换原则
 * <p>
 * 1、里氏替换原则(Liskov Substitution Principle)在1988年，由麻省理工学院的以为姓里的女士提出的。
 * <p>
 * 2、如果对每个类型为T1的对象o1，都有类型为T2的对象o2，使得以T1定义的所有程序
 *     P在所有的对象o1都代换成o2时，程序P的行为没有发生变化，那么类型T2是类型T1
 *    的子类型。换句话说，所有引用基类的地方必须能透明地使用其子类的对象。
 *
 * 3、在使用继承时，遵循里氏替换原则，在子类中尽量不要重写父类的方法；
 * 4、//TODO 里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当的情况下，可以通过聚合，组合，依赖来解决问题。
 * 5、继承会给程序带来侵入性
 */
public class LiskovSubstitution {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("2-1=" + a.func1(2, 1));

        B b = new B();
        System.out.println("2+1=" + b.func1(2, 1));
        System.out.println("2+1+9=" + b.func2(2, 1));
        System.out.println("B类使用A类方法：2-1=" + b.func3(2, 1));
    }
}

class Base {
    //把基础方法和成员抽取成基类
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class A extends Base {

//    public int func1(int num1, int num2) {
//        return num1 - num2;
//    }
}

class B extends Base {

    // TODO 类 B 无意 重写了父类 A 方法，造成原有方法发生错误。
//    @Override
//    public int func1(int num1, int num2) {
//        return num1 + num2;
//    }

    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    private A a = new A();

    public int func2(int num1, int num2) {
        return func1(num1, num2) + 9;
    }

    //使用 A 方法
    public int func3(int num1, int num2) {
        return this.a.func1(num1, num2);
    }
}
