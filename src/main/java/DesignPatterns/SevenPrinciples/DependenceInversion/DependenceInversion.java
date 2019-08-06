package DesignPatterns.SevenPrinciples.DependenceInversion;

/**
 * @author Yu
 * //TODO 依赖倒转原则
 * <p>
 * 1、高层模块不应该依赖低层模块，二者都应该依赖其抽象
 * 2、抽象不应该依赖细节，细节应该依赖抽象
 * 3、依赖倒转(倒置)的中心思想是面向接口编程
 * <p>
 * 4、依赖倒转原则是基于这样的设计理念:相对于细节的多变性，抽象的东西要稳定的
 *    多。以抽象为基础搭建的架构比以细节为基础的架构要稳定的多。在java中， 抽象
 *    指的是接口或抽象类，细节就是具体的实现类
 * <p>
 * 5、使用接口或抽象类的目的是制定好规范，而不涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成
 *
 * 依赖关系三种传递方式：
 *  接口传递
 *  构造方法传递
 *  setter方式传递
 *
 */
public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

interface Info{
    String getInfo();
}

class Email implements Info{

    @Override
    public String getInfo() {
        return "Receive Email";
    }
}

class WeChat implements Info{

    @Override
    public String getInfo() {
        return "Receive WeChat";
    }
}

//person 接受信息
class Person {

    public void receive(Info info) {
        System.out.println(info.getInfo());
    }
}
