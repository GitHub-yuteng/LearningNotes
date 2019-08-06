package ZTest.My;

public class OverFlowInt {

    public static void main(String[] args) {

        for (int i = 0; true; i++) {
            if (i + 1 < i) { // int 溢出时满足条件  2147483647 2^31 - 1
                System.out.println(i);
                break;
            }
        }

        byte b1 = 0;
        int a = 2;
        int b = 2;
        int c = 2;

        b1 = (byte) (a + b + c);
        System.out.println(b1);
        b1 = (byte) ((byte) a + (byte) b + (byte) c);
        System.out.println(b1);
    }
}