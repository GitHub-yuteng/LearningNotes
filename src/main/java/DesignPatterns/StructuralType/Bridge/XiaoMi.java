package DesignPatterns.StructuralType.Bridge;

public class XiaoMi implements Brand {

    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println("MI Open！");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println("MI Close！");
    }

    @Override
    public void call() {
        // TODO Auto-generated method stub
        System.out.println("MI Call！");
    }
}
