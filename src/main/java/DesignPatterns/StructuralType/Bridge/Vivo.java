package DesignPatterns.StructuralType.Bridge;

public class Vivo implements Brand {

    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println(" Vivo Open！");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println(" Vivo Close！");
    }

    @Override
    public void call() {
        // TODO Auto-generated method stub
        System.out.println(" Vivo Call！");
    }
}
