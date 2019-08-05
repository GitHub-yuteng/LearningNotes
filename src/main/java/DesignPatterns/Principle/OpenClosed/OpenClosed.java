package DesignPatterns.Principle.OpenClosed;

/**
 * @author Yu
 * //TODO 开闭原则
 * <p>
 * 1、开闭原则(Open Closed Principle) 是编程中最基础、最重要的设计原则
 * 2、一个软件实体，比如类，模块和函数应该对提供方扩展开放，对使用方修改关闭。用抽象构建框架，用实现扩展细节。
 * 3、当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化。
 * 4、编程中遵循其它原则，以及使用设计模式的目的就是遵循开闭原则。
 */
public class OpenClosed {
    public static void main(String[] args) {
        Use use = new Use();
        use.drawShape(new Triangle());
        use.drawShape(new Circle());
        use.drawShape(new OtherGraphics());//只需要让 此类继承 抽象类，子类实现具体方法  OCP原则
    }
}

class Use {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

abstract class Shape {
    public abstract void draw();
}

class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("子类实现具体功能：三角形");
    }
}

class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("子类实现具体功能：圆形");
    }
}

class OtherGraphics extends Shape {

    @Override
    public void draw() {
        System.out.println("子类实现具体功能：任何形状");
    }
}


