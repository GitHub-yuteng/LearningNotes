package DesignPatterns.BehavioralType.Template.Hook;

public class PureSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
    }

    @Override
    boolean customerWantCondiments() {
        System.out.println("2、不添加配料，制造纯豆浆");
        return false;
    }
}
