package ZTest.My.Alibaba;

import java.util.*;

public class Base {
    public void methodOne() {
        System.out.print("A");
        methodTwo();
    }

    public void methodTwo() {
        System.out.print("B");
    }
}

class Derived extends Base {
    @Override
    public void methodOne() {
        super.methodOne();
        System.out.print("C");
    }

    @Override
    public void methodTwo() {
        super.methodTwo();
        System.out.print("D");
    }

    public static void main(String[] args) {
        Base base = new Derived();
        base.methodOne();

    }
}