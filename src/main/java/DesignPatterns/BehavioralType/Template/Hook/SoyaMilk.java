package DesignPatterns.BehavioralType.Template.Hook;

//抽象类，表示制作豆浆的流程
public abstract class SoyaMilk {

    //模版方法，final 不让子类覆盖
    final void make() {

        select();
        if (customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();

    }

    void select() {
        System.out.println("1、选材准备");
    }

    //抽象方法，子类去实现，添加不同的配料
    abstract void addCondiments();

    //浸泡
    void soak() {
        System.out.println("3、浸泡");
    }

    //打碎
    void beat() {
        System.out.println("4、放入豆浆机打碎");
    }

    //钩子方法，判断是否添加配料
    boolean customerWantCondiments() {
        return true;
    }
}
