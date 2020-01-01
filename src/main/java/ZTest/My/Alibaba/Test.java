package ZTest.My.Alibaba;

public class Test {
    private static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.print(i);
                }
            } finally {
                System.out.print("e");
            }
        }
    }

    public static void main(String[] args) {
        try {
            test(new int[]{0, 1, 2, 3, 4, 5});
        } catch (Exception e) {
            System.out.print("E");
        }
    }

}