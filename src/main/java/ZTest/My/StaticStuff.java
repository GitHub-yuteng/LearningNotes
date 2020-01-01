package ZTest.My;

import java.util.List;

class StaticStuff {
    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String args[]) {
        System.out.println("x = " + x);

        int[] arr = {};
        List list = null;
        Object a = list;

    }

    static {
        x /= 3;
    }

}