package ZTest.My;

class Value {
    public int i = 15;
}

public class Test {
    public static void main(String argv[]) {
        Test t = new Test();
        t.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value temp, int i) {
        i = 0;
        temp.i = 20;
        Value val = new Value();
        temp = val;
        System.out.print(temp.i + " " + i + " ");
    }
}