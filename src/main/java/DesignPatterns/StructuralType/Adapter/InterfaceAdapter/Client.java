package DesignPatterns.StructuralType.Adapter.InterfaceAdapter;

public class Client {
    public static void main(String[] args) {

        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("m1");
            }

            @Override
            public void m2() {
                System.out.println("m2");
            }
        };

        absAdapter.m1();
        absAdapter.m2();
    }
}
